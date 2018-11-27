package hello;

import org.springframework.data.repository.CrudRepository;
import hello.User;

// 스프링에 의해 자동 구현됨
// userRepository 빈으로 구현되며, CRUD함

public interface UserRepository extends CrudRepository<User, Integer>{

}