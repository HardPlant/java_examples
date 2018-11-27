#!/bin/bash
source /tmp/config.sh

mysql -uroot -p$PASSWD -e "
create database $DBNAME;s
grant all privileges on $DBNAME.* to $USERNAME identified by '$USERPASS';
flush privileges;
"