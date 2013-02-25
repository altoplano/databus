#!/bin/bash

script_dir=`dirname $0`
source ${script_dir}/espresso_cluster_setup_settings.inc
source ${script_dir}/common_funcs.inc

if [ ! -d ${DBUS_CONFIG_PATH} ] ; then
	svn co svn+ssh://svn.corp.linkedin.com/netrepo/databus2/trunk/config ${DBUS_CONFIG_PATH}
else
	svn up ${DBUS_CONFIG_PATH}
fi

relay_cluster_cfg=${DBUS_CONFIG_PATH}/app/databus3-relay-espresso-war/${CLUSTER_FABRIC}/${RELAY_CLUSTER_NAME}.src

if [ -f ${relay_cluster_cfg} ] ; then
	read -p "Cluster tag config exists: ${relay_cluster_cfg} exists! If you continue, it will be overwritten. Continue (y/n)" overwrite_cfg
	if [ "$overwrite_cfg" != "y" -a "$overwrite_cfg" != "Y" -a "$overwrite_cfg" != "yes" -a "$overwrite_cfg" != "Yes" -a "$overwrite_cfg" != "YES" ] ; then
		echo "Aborting ..."
		exit 1
	fi

	echo "Saving tag config to ${relay_cluster_cfg}.bak"
	cp ${relay_cluster_cfg} ${relay_cluster_cfg}.bak
fi

sn_num="${#SN_HOSTS[@]}"
relay_num="${#RELAY_HOSTS[@]}"

read -p "Number of partitions:" partition_num
read -p "Average event size:" avg_event_size
read -p "Average update/s:" avg_eps

buffer_size=$((avg_eps * avg_event_size * 3600 * RELAY_BUFFER_HOURSPAN / partition_num))
scn_index_size=$((buffer_size / 256))

echo "Using buffer size: ${buffer_size}"
echo "Using SCN index size: ${scn_index_size}"

(
cat <<EOF
<application xmlns="urn:com:linkedin:ns:configuration:source:1.0" xmlns:w="urn:com:linkedin:ns:configuration:wildcard:1.0">
  <configuration-source>
    <property name="databus.relay.clusterManager.relayClusterName" value="${RELAY_CLUSTER_NAME}" />
    <property name="databus.relay.clusterManager.storageClusterName" value="${ESPRESSO_CLUSTER_NAME}" />
    <property name="databus2.relay.eventBuffer.readBufferSize" value="20480000" />
    <property name="databus2.relay.eventBuffer.scnIndexSize" value="${scn_index_size}" />
    <property name="databus2.relay.eventBuffer.maxSize" value="${buffer_size}" />
    <property name="databus.relay.clusterManager.relayReplicationFactor" value="${RELAY_REPL_FACTOR}" />
    <property name="databus.relay.runtime.container.defaultExecutor.maxThreadsNum" value="100" />
    <property name="tracker.producer.events.batch.size" value="50" />
  </configuration-source>
</application>
EOF
) > ${relay_cluster_cfg}

cat ${relay_cluster_cfg}

svn add ${relay_cluster_cfg}
svin review -r cbotev,bshkolni,pganti -g databus-dev --summary "Relay configuration for ${RELAY_CLUSTER_NAME} in ${CLUSTER_FABRIC}" --description "Automatically generated by $(basename $0)" ${relay_cluster_cfg} 
