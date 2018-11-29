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

### Data-driven 테스트

Parametrized Test로 가능
입력, 예상 결과를 적고 어떻게 행동하는지 보는 테스트 가능
계산 포함, 경계조건, 코너, 범위 테스트에 효과적임

```java
@RunWith(Parameterized.class)
public class PermiumTweetsServiceTest{
    private int numberOfTweets;
    private double expectedFee;
    @Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
            {0, 0.00}, {99,9.00}
        });
    }
    public PremiumTweetsServiceTest(int numberOfTweets, double expectedFee){
        this.numberOfTweets = numberOfTweets;
        this.expectedFee = expectedFee;
    }
    @Test
    public void shouldCalculateCorretFee(){
        PremiumTweetsService pts = new PremiumTweetsService();
        double calculatedFees = pts.calculateFeesDue(numberOfTweets);
        assertThat(calculatedFees, is(expectedFee));
    }
}
```
멤버 변수로 입력값 `numberOfTweets`, 예상 결과 `expectedFee`가 있음

`@RunWith()` 어노테이션이 테스트 데이터를 테스트 클래스에 주입함

`@Parameters`로 테스트 데이터가 주어짐, 컬렉션을 반환하는 것이 필요함
