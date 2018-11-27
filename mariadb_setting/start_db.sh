source $(pwd)/config.sh

docker ps -a | grep $APP_NAME
docker run -d --name $APP_NAME -h $APP_NAME \
    -p 3306:3306 \
    -v /data/$APP_NAME:/var/lib/mysql \
    mariadb
docker ps -a | grep $APP_NAME
docker logs $APP_NAME