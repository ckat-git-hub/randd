#!/bin/sh

# Setting custom tomcat arguments
# Tomcat startup.sh in bin folder contains reference for setenv.sh file - this is default feature of tomcat
export JAVA_OPTS='-Dapp.properties=/opt/cpda/config'

echo "Properties Location Set"
