source $(pwd)/config.sh

APP_NAME=${1:-mariadbprod}
PASSWD=${2:-FeGam8yaci3UeyaVReey3ud1Upae9miiOaz5aeNaeiG7ray5aaV9EtoWEBe8ibut}
DBNAME=${3:-somedb}
USERNAME=${4:-somedbuser}
USERPASS=${5:-'USERPASS_HERE'}

docker cp $(pwd)/config.sh $APP_NAME:/tmp/config.sh
docker cp $(pwd)/_sql_create_db.sh $APP_NAME:/tmp/_sql_create_db.sh
docker exec $APP_NAME /bin/bash -c /tmp/_sql_create_db.sh
#docker exec $APP_NAME /bin/bash < $(pwd)/create_db_sql.sh $1 $2 $3 $4 $5
docker exec -it $APP_NAME mysql -uroot -p$PASSWD