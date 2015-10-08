package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	/**
	 * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
	 * The run() method returns an ApplicationContext where all the beans that were created 
	 * either by your app or automatically added thanks to Spring Boot are.
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    HotelRepository hotels;
    
    @Override
    public void run(String... strings) {
    	    
    	log.info("Setting up seed data");
    	
    	hotels.deleteAll();
    	Hotel myHotels[] = {new Hotel(0,"Marriot"), 
    						new Hotel(1,"Intercontinental"), 
    						new Hotel(2,"Trip"), 
    						new Hotel(3,"Holiday Inn"), 
    						new Hotel(4,"Tulip"), 
    						new Hotel(5,"Hostel da Costa")};
    	
    	for(Hotel hotel : myHotels) hotels.save(hotel);
    }

}


