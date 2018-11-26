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
