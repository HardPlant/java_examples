source /tmp/config.sh

mysql -u$USERNAME -p$USERPASS $DBNAME < /tmp/schema.sql