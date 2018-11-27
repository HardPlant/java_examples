#!/bin/bash
source /tmp/config.sh


mysql -u$USERNAME -p$USERPASS $DBNAME -e "show databases";
mysql -u$USERNAME -p$USERPASS $DBNAME -e "use somedb";
mysql -u$USERNAME -p$USERPASS $DBNAME -e "show tables";