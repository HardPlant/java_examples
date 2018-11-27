# 스프링 부트로 애플리케이션 만들기

스프링 부트는 예를 들어 Thymeleaf가 패스에 있으면 `SpringTemplateEngine`을 추가함

### 간단한 웹앱 만들기

`HelloController.java`

`@RestController`는 `클래스가` Spring MVC가 웹 요청을 받을 준비가 됬다고 알림

`@Controller`와 `@ResponseBody`를 조합해서 데이터를 반환하도록 함

`@RequestMapping`은 웹 요청과 메서드를 묶음


### 애플리케이션 클래스 만들기

`Application.java`

`@SpringBootApplication`은 다음 것들을 모두 추가한다.

`@Configuration` : 클래스를 앱 문맥을 위한 빈 정의 출처로 취급함
`@EnableAutoConfiguration` : 클래스패스의 빈들을 추가함
`@EnableWebMvc`는 스프링 부트가 **spring-webmvc**를 보면 자동으로 추가함
`@ComponentScan`

`CommandLineRunner` 메서드는 `@Bean`으로 마크되어 있고, 시작 시 실행한다.

### 유닛 테스트

`MockMvc`는 간편한 빌더 클래스를 통해 `DispatcherServlet`에 HTTP 요청을 보내고 결과에 대해 단언할 수 있게 해 준다.
`MockMvc` 인스턴스를 삽입하려면 `@SpringBootTest`와 함께 `AutoConfigureMockMvc`를 지정해줘야 한다.

대신 `@WebMvcTest`로 웹 레이어 컨텍스트만 스프링 부트가 생성하게 만들 수 있다.

HTTP Request 사이클을 모킹하는 것처럼 스프링 부트로 풀스택 통합 테스트를 할 수 있다.
Mock 테스트 대신 실제로 URL을 날리려면..

`HelloControllerIT.java`

여기서 웹 서버가 실제로 실행되는데, `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`에 의해 임의 포트에서 서버가 실행되고 `@LocalServerPort` 어노테이션이 실행된 서버를 지정한다.