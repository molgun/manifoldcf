#!/bin/bash -e

# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

if [[ $OSTYPE == "cygwin" ]] ; then
    PATHSEP=";"
else
    PATHSEP=":"
fi

#Make sure environment variables are properly set
if [ -e "$JAVA_HOME"/bin/java ] ; then
    if [ -f "$MCF_HOME"/properties.xml ] ; then
        # TODO: Check this on both Windows and Redhat
        if [ -f "$DOCUMENTUM"/dmcl.ini -o -f "$DOCUMENTUM"/dfc.properties ] ; then
    
            # Build the classpath
            CLASSPATH=""
            for filename in $(ls -1 "$MCF_HOME"/../documentum-server-process/lib) ; do
                if [ -n "$CLASSPATH" ] ; then
                    CLASSPATH="$CLASSPATH""$PATHSEP""$MCF_HOME"/../documentum-server-process/lib/"$filename"
                else
                    CLASSPATH="$MCF_HOME"/../documentum-server-process/lib/"$filename"
                fi
            done

            for filename in $(ls -1 "$MCF_HOME"/../documentum-server-process/lib-proprietary | grep "\.jar$") ; do
                if [ -n "$CLASSPATH" ] ; then
                    CLASSPATH="$CLASSPATH""$PATHSEP""$MCF_HOME"/../documentum-server-process/lib-proprietary/"$filename"
                else
                    CLASSPATH="$MCF_HOME"/../documentum-server-process/lib-proprietary/"$filename"
                fi
            done

            LIB_STATEMENT=""
            if [[ $JAVA_LIB_PATH != "" ]] ; then
                LIB_STATEMENT=-Djava.library.path="$JAVA_LIB_PATH"
            fi
            "$JAVA_HOME/bin/java" -Xmx512m -Xms32m $LIB_STATEMENT -cp "$CLASSPATH" org.apache.manifoldcf.crawler.server.DCTM.DCTM
            exit $?
        else
            echo "Environment variable DOCUMENTUM is not properly set." 1>&2
            exit 1
        fi      

    else
        echo "Environment variable MCF_HOME is not properly set." 1>&2
        exit 1
    fi    

else
    echo "Environment variable JAVA_HOME is not properly set." 1>&2
    exit 1
fi
