# 스프링 MySQL

* JPA

Java Persistance API

RDB에 자바를 연동하는 방법을 제공

* MySQL Connector

의존성에 있음

### DB 만들기

```
mysql> create database db_example; -- Create the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database
```

### `application.properties` 파일 만들기

스프링 부트의 기본 데이터베이스는 `H2`임, `application.properties`에서 연결 속성을 바꿔줘야 함