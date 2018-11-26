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

