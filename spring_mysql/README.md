# MySQL 연동

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