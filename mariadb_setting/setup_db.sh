APP_NAME=${1:mariadbprod}
PASSWD=${2:FeGam8yaci3UeyaVReey3ud1Upae9miiOaz5aeNaeiG7ray5aaV9EtoWEBe8ibut}

docker ps -a | grep $APP_NAME
docker run -d --name $APP_NAME -h $APP_NAME \
    -p 3306:3306 \
    -v /data/$APP_NAME:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD=$PASSWD \
    mariadb
docker ps -a | grep $APP_NAME
docker logs $APP_NAME