#!/bin/bash
source $(pwd)/config.sh
docker exec -it $APP_NAME mysql -uroot -p$PASSWD