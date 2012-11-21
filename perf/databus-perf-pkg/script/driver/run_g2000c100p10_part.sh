#!/bin/bash

script_dir=`dirname $0`
exp=g2000c100p10_part
source ${script_dir}/common.inc

stop_relay member2_mmap
sleep 5
clean_relay_logs
start_relay member2_mmap

groupn=0
for h in ${remote_hosts_all} ; do
  ssh -tt $h "nohup tools/remote/run_n_consumers.sh $exp $relay:11183 com.linkedin.events.member2.profile.MemberProfile 2000 50000000 10 300s $ts 10 100 $groupn"
  groupn=$((groupn+1))
done

sleep 15
${genscript} -s 40 -b 2000 -e 2000 -t 1800000 --server_host=$relay --server_port=11183
sleep 360

${script_dir}/sync_remote.sh
get_relay_logs $exp

#ssh -tt eat1-app170.corp.linkedin.com 'nohup relay01/bin/stop-perf-relay.sh member2_mmap'
