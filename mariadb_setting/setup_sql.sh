SQLNAME=$1
DBNAME=${2:somedb}
USERNAME=${3:someuser}
USERPASS=${4:USERPASS_HERE}

app=mariadbprod

if [ $# -eq 0 ]
    then
        echo "No SQLNAME"
        exit 1
fi
docker exec -ti $app mysql \
-u$USERNAME -p$USERPASS $DBNAME < $SQLNAME