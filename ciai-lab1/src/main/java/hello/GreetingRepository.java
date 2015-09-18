package hello;

import org.springframework.data.repository.CrudRepository;


public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}

