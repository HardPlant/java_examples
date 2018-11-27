source $(pwd)/config.sh

SQL_NAME=${1:-schema.sql}

docker cp $(pwd)/config.sh $APP_NAME:/tmp/config.sh
docker cp $(pwd)/_sql_sql_run.sh $APP_NAME:/tmp/_sql_sql_run.sh
docker cp $(pwd)/$SQL_NAME $APP_NAME:/tmp/schema.sql

docker exec $APP_NAME /bin/bash -c /tmp/_sql_sql_run.sh
docker exec -it $APP_NAME mysql -uroot -p$PASSWD
