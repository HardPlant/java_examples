source $(pwd)/config.sh

docker cp $(pwd)/config.sh $APP_NAME:/tmp/config.sh
docker cp $(pwd)/_sql_check_db.sh $APP_NAME:/tmp/_sql_check_db.sh
docker exec $APP_NAME /bin/bash -c /tmp/_sql_check_db.sh
docker exec -it $APP_NAME mysql -uroot -p$PASSWD