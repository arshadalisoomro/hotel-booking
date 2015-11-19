package booking;


import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import booking.model.User;
import booking.repository.AuthorityRepository;
import booking.repository.UserRepository;
import security.SecurityConfig;


@SpringBootApplication
public class Application implements CommandLineRunner {

	/**
	 * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
	 * The run() method returns an ApplicationContext where all the beans that were created 
	 * either by your app or automatically added thanks to Spring Boot are.
	 * @param args
	 */
	@Autowired
	UserRepository users;
	
	@Autowired
	AuthorityRepository authorities;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(String... strings) {
		
		Iterator<User> it = users.findAll().iterator();
		
		while(it.hasNext()){
			User u1 = it.next();
			String pass = u1.getPassword();
			u1.setPassword(SecurityConfig.encoder.encode(pass));
			users.save(u1);
		}
		
	}
}


