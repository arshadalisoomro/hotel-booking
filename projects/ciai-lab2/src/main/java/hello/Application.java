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
    
    @Autowired
    CategoryRepository categories;
    
    @Override
    public void run(String... strings) {
    	    
    	log.info("Setting up seed data");
    	
    	hotels.deleteAll();
    	Hotel myHotels[] = {new Hotel(0,"Marriot", "Rua do Pico", 5), 
    						new Hotel(1,"Intercontinental", "Rua do Caramulo", 5), 
    						new Hotel(2,"Trip", "Rua do Pinheiro", 2), 
    						new Hotel(3,"Holiday Inn", "Rua da Fonte", 4), 
    						new Hotel(4,"Tulip", "Rua do Lousado", 1), 
    						new Hotel(5,"Hostel da Costa", "Rua do Painel", 3)};
    	
    	for(Hotel hotel : myHotels) hotels.save(hotel);
    	
    	categories.deleteAll();
    	Category myCategories[] = {new Category(0,"Resort"),
    								new Category(1,"Apartment Hotel"),
    								new Category(2,"Luxury"),
    								new Category(3,"Bed & Breakfast"),
    								new Category(4,"Hostel")};
    	
    	
    	for(Category category : myCategories) categories.save(category);
    }

}


