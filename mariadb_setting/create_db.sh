source $(pwd)/config.sh

docker cp $(pwd)/config.sh $APP_NAME:/tmp/config.sh
docker cp $(pwd)/_sql_create_db.sh $APP_NAME:/tmp/_sql_create_db.sh
docker exec $APP_NAME /bin/bash -c /tmp/_sql_create_db.sh
#docker exec $APP_NAME /bin/bash < $(pwd)/create_db_sql.sh $1 $2 $3 $4 $5
docker exec -it $APP_NAME mysql -uroot -p$PASSWD