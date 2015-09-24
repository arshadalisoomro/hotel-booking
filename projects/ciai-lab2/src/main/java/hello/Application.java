package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	/**
	 * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
	 * The run() method returns an ApplicationContext where all the beans that were created 
	 * either by your app or automatically added thanks to Spring Boot are.
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


