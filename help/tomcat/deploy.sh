#!/bin/sh

# This below operation changes the permission of properties file and copies properties file to specified location
sudo chmod 777 /home/cpdavm/cpda/code/automate-dataentry/config/application.properties
sudo cp /opt/cpda/config/backup/application.properties /opt/cpda/config
echo "Properties file copied"


# This below operation changes the permission of MSAccess template file and copies AGSFormFilling.accdb( template ) file to specified location
sudo chmod 777 /home/cpdavm/cpda/code/automate-dataentry/src/com/data/export/template/AGSFormFilling.accdb
sudo cp /home/cpdavm/cpda/code/automate-dataentry/src/com/data/export/template/AGSFormFilling.accdb /opt/cpda/template
echo "Template file copied"


# This below operation changes the permission of war file and copies war file to tomcat's webapps location
sudo chmod 777 /home/cpdavm/cpda/code/automate-dataentry/target/automate-dataentry-0.0.1-SNAPSHOT.war
sudo cp /home/cpdavm/cpda/code/automate-dataentry/target/automate-dataentry-0.0.1-SNAPSHOT.war /opt/cpda/tools/server/apache-tomcat-9.0.14/webapps/automate-dataentry.war
sudo chmod 777 /opt/cpda/tools/server/apache-tomcat-9.0.14/webapps/automate-dataentry.war
echo "automate-dataentry War Deployed"