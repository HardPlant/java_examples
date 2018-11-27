#!/bin/bash
source /tmp/config.sh


mysql -uroot -p$PASSWD -e "drop database $DBNAME;"
mysql -uroot -p$PASSWD -e "drop user $USERNAME;"

mysql -uroot -p$PASSWD -e "create database $DBNAME;"
mysql -uroot -p$PASSWD -e "grant all privileges on $DBNAME.* to $USERNAME identified by '$USERPASS';"
mysql -uroot -p$PASSWD -e "flush privileges;"