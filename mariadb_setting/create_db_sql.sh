#!/bin/bash
APP_NAME=${1:-mariadbprod}
PASSWD=${2:-FeGam8yaci3UeyaVReey3ud1Upae9miiOaz5aeNaeiG7ray5aaV9EtoWEBe8ibut}
DBNAME=${3:-somedb}
USERNAME=${4:-somedbuser}
USERPASS=${5:-'USERPASS_HERE'}

mysql -uroot -p$PASSWD -e "
create database $DBNAME;
--CREATE USER someuser IDENTIFIED BY $USERPASS; 
grant all privileges on $DBNAME.* to $USERNAME identified by $USERPASS;
flush privileges;
"