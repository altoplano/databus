package com.linkedin.databus3.espresso.cmclient;
/*
 *
 * Copyright 2013 LinkedIn Corp. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/


import org.apache.log4j.Logger;

public class ClusterParams {
	private String _clusterName;
    private String _zkConnectString;
	private final Logger LOG = Logger.getLogger(ClusterParams.class.getName());

	public ClusterParams(String clusterName, String zkConnectString)
    {
		_clusterName = clusterName;
		_zkConnectString = zkConnectString;
		LOG.info("Obtained ClusterParams " + _clusterName + " " + _zkConnectString);
    }
    	
    public String getClusterName() {
		return _clusterName;
	}
    
	public String getZkConnectString() {
		return _zkConnectString;
	}
}
