# 도커 MariaDB 설정

[](http://doc.nethence.com/docker/mariadb)

### 컨테이너 실행

* 데이터 폴더 확인

```bash
app=mariadbprod
sudo ls -alhF /data/$app
```

* 강한 비밀번호 만들기

```bash
sudo apt install pwgen
pwgen
```

* 데이터폴더를 mapping volume으로 마리아DB 실행

```bash
app=mariadbprod
docker ps -a | grep $app
docker run -d --name $app -h $app \
    -p 3306:3306 \
    -v /data/$app:/var/lib/mysql \
    -e MYSQL_ROOT_PASSWORD= ... \
    mariadb
docker ps -a | grep $app
docker logs $app
```

다음 실행부터는 `-\e ..` 부분을 제거해야 함

### 데이터베이스 설정

* 'somedb' 데이터베이스 추가

```bash
app=mariadbprod
docker exec -ti $app mysql -uroot -pPASSWORD_HERE

create database somedb;
--CREATE USER someuser IDENTIFIED BY 'USERPASS_HERE'; 
grant all privileges on somdb.* to somedbuser identified by 'USERPASS_HERE';
flush privileges;
```

* sql 추가

```bash
app=mariadbprod
docker exec -ti $app mysql -usomedbuser -pUSERPASS_HERE somedb < ~/schema.sql
```

* 체크

```bash
app=mariadbprod
docker exec -ti $app mysql -usomedbuser -pUSERPASS_HERE somedb
show databases;
use somedb;
show tables;
```

### 네트워크 접근

다른 컨테이너에서 DB에 접근하려면 --link :aias 사용

```bash
app=tmpcheckmaria
docker run -ti --name $app -h $app --link mariadbprod:mariadb custom/ubuntu bash
cat /etc/hosts
ping -c1 mariadb
nc -z -v mariadb 3306
apt -y update && apt -y install mariadb-client
mysql -uroot -pPASSWORD_HERE -h mariadb
show databases;
use somedb;
show tables;
```