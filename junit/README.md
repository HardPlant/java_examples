# Junit

### 자바 파일 컴파일

```
javac Calculator.java
```

### 테스트 컴파일

```
javac -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar CalculatorTest.java
```

### 테스트 실행

```
java -cp .:junit-4.XX.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest
```

### 테스트 실패하게 만들기

Calc 변경

### 계속적 테스팅
[](http://groups.csail.mit.edu/pag/continuoustesting/what.html)

코드가 변경될 때마다 테스트를 수행해 실패, 에러를 알림

### Apache POI
