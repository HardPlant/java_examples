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

```properties
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
```

`spring.jpa.hibernate.ddl-auto`는 `none`, `update`, `create`, `create-drop`이 될 수 있음

* `none` : MySQL 디폴트, 데이터베이스 구조 변경 없음

* `update` : Hibernate가 주어진 Entity 구조에 따라 데이터베이스 변경

* `create` : 매번 데이터베이스 생성, 닫을 때 드롭하지 않음

* `create-drop` : `SessionFactory`가 닫힐 때 데이터베이스를 드롭함

데이터베이스가 만들어지지 않았기 때문에 `create`를 사용하고, 첫 번째 실행 이후애 `update`나 `none`으로 바꿀 수 있음, `update`는 데이터베이스 구조를 변경하고 싶으면 사용

`H2`와 내장 DB 기본값은 `create-drop`임

* 좋은 보안 습관은 제품 상태일 때 이걸 `none`로 바꾸고 MySQL 유저에게 모든 권한을 박탈하고 DDL 관련 권한만 주는 것임

### @Entity 모델 만들기

`User.java`

`@Entity` 어노테이션은 하이버네이트에게 이 클래스의 테이블을 만들라고 지시함

### Repository 생성

CrudRepository<Class, PrimaryKey(클래스에서 어노테이션 붙인 값)>을 만들면 스프링이 빈을 자동으로 구현해 줌

### 컨트롤러 추가

`@GetMapping`은 `@RequestMapping(method=GET)`의 짧은 표현이고, `@RequestMapping`은 모든 HTTP 연산을 매핑함

`@Autowired`를 `UserRepository`에 붙임으로서 자동 생성된 객체를 사용할 것임

`@ResponseBody`로 응답을 만들 메서드를 만들고, 메서드의 인자에 `@RequestParam`을 붙이는 것이 가능함

### 실행 가능하게 만들기

```java
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 애플리케이션 테스트하기

`curl`을 사용해서..

`curl 'localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com'`

의 결과로 Saved가 반환되고

`curl 'localhost:8080/demo/all'`

으로 JSON이 반환되는 것을 볼 수 있음