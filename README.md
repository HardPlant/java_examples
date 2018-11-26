# Java Project with Maven

[](https://spring.io/guides/gs/maven/)

### pom.xml 구조

`<modelVersion>` POM 모델 버전 (4.0.0)
`<groupId>` 프로젝트가 속한 그룹/기관 ID, 반전된 도메인 이름으로 나타냄

`<artifactId>` 프로젝트의 라이브러리 아티펙트에 주어지는 이름(JAR,WAR 파일)
`<version>` 프로젝트 버전
`<packaging>` 프로젝트가 어떻게 패키지되어야 하는지

이 정도만 있으면 메이븐 프로젝트를 정의할 수 있음

### 자바 코드 실행

메이븐으로 코드를 컴파일하고, 라이브러리 패키지를 만들고(JAR), 지역 메이븐 의존성 레포지토리에 라이브러리를 인스톨할 수 있음

빌드하려면

```
mvn compile
```

으로, target/classes 디렉터리에 .class 파일을 컴파일할 수 있음

바로 만들려면 `package` 골을 사용하면 됨

```
mvn package
```

자바 코드를 컴파일하고, 테스트를 실행하고, JAR 파일로 패키징함
JAR 파일은 `<artifactId>`, `<version>`에 영향을 받음

mvn 의존성 라이브러리는 `.m2/repository`에 설치되며,

```
mvn install
```
은 컴파일, 테스트, 페키지를 한 뒤 의존성 라이브러리 저장소에 넣어 다른 프로젝트가 의존성으로 사용할 수 있또록 함

### 의존성 정의

애플리케이션에 전체 날짜, 시간을 넣도록 할 것임

```xml
<dependencies>
		<dependency>
			<groupId>joda-time</groupId>
			<artifactId>joda-time</artifactId>
			<version>2.9.2</version>
		</dependency>
</dependencies>
```

넣을 라이브러리를 `pom.xml`에 넣으면 됨

여기도 마찬가지로 `groupId`, `artifactId`, `version`을 넣으면 됨

모든 의존성은 `compile` 타임에 확보되며, WAR 파일을 만든다면 `/WEB-INF/libs/` 폴더에 있음
`scope`를 지정할 수 있는데, `provided`(컴파일에 필요할 시, 그리고 코드를 실행하는 런타임에 제공될 시, Servlet), `test` (테스트 시)

`mvn compile`, `mvn package` 시에 Maven Central Repository에서 의존성을 가져와서 빌드함

### 테스트 작성

JUnit을 디펜던시 테스트 스코프에 넣음

```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
```

`src/test/java/hello/GreeterTest.java`

메이븐은 surefire 플러그인으로 테스트를 진행함
이 플러그인의 기본 설정은 모든 `src/test/java`에 있는 `*Test` 클래스를 컴파일하고 실행함

`mvn test`

## Securing with Web

Spring Boot Maven Plugin은 많은 이점이 있음

* 클래스패스에 있는 모든 jar를 모아 하나의 jar를 만듬

* `public static void main()` 메서드를 찾아 실행가능한 클래스를 만듬

* 빌트인 의존성 해결자를 가지고 있음

#### 의존성 분석

스프링 부트 스타터 : themleaf 템플릿 엔진

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

스프링 부트 스타터 : 웹

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

스프링 부트 스타터 : 테스트

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

스프링 시큐리티 테스트

```xml
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-test</artifactId>
	<scope>test</scope>
</dependency>
```


#### 비안전한 웹 애플리케이션 만들기

안전하게 할 웹 애플리케이션이 필요함
간단한 웹 애플리케이션을 만들어 보겠음

홈페이지와 Hello World 페이지를 가진 간단한 뷰를 만들어 보겠음

Thymeleaf 템플릿을 따름

`home.html`은 /hello로 향하는 링크를 가지고 있음

웹 애플리케이션은 스프링 MVC를 따르고 있으므로, 스프링 MVC를 설정하고 컨트롤러가 템플릿을 노출하게 만듬

* MvcConfig.java

addViewControllers() 메서드는 (WebMvcConfigurer에서 오버라이드됨) 뷰 컨트롤러 4개를 추가함

#### 애플리케이션을 실행 가능하게 하기

이 서비스를 WAR로 만들어 외부 WAS에 올릴 수 있지만, 스탠드얼론 애플리케이션으로 만들 수 있음
main() 메서드로 만들면 스프링의 내장 톰캣 서버에서 실행 가능함

`@SpringBootApplication` 어노테이션은 다음을 추가함

* `@Configuration` 태그를 추가해 애플리케이션 컨텍스트의 빈 정의를 추가함
* `@EnableAutoConfiguration`으로 스프링 부트가 클래스패스 세팅 기반으로 빈을 추가함
* `@EnableWebMvc`를 보통 스프링 MVC 앱에 추가하지만, 스프링 부트는 spring-webmvc가 클래스패스에 보이면 자동적으로 추가해 `DispatcherServler` 설정같은 것을 활성화함

* `@ComponentScan`은 `hello` 패키지의 다른 컴포넌트, 설정, 서비스를 스프링이 찾게 함

`web.xml` 파일이 없음

`./mvnw spring-boot:run`으로 실행하거나 jar 파일을 `./mvnw clean package`로 만들 수 있음

애플리케이션이 실행되면 `localhost:8080`에 가면 됨

### 스프링 시큐리티 설정

hello를 인가된 유저만 볼 수 있게 장벽을 추가함
클래스패스에 스프링 시큐리티가 있으면 스프링 부트는 기본 인증을 통해 [자동적으로 모든 HTTP 엔드포인트를 보호함](https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/htmlsingle/#boot-features-security)
나중에 보안 설정을 커스터마이즈할 수 있음

클래스패스에 스프링 시큐리티를 추가하려면 `pom.xml`에 의존성을 추가함

```xml
<dependencies>
    ...
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
    ...
</dependencies>
```
