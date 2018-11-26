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


