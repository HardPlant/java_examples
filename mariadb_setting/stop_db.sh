source $(pwd)/config.sh

docker stop $APP_NAME
docker rm $APP_NAME