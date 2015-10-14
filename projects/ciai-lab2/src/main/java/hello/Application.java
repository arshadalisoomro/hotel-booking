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
    
    @Autowired
    RoomTypeRepository roomTypes;
    
    @Override
    public void run(String... strings) {
    	    
    	log.info("Setting up seed data");
    	
    	categories.deleteAll();
    	Category myCategories[] = {	new Category(1,"Apartment Hotel"),
    								new Category(2,"Luxury"),
    								new Category(3,"Bed & Breakfast"),
    								new Category(4,"Hostel"),
    								new Category(5,"Resort")};
    	
    	
    	for(Category category : myCategories) categories.save(category);
    	
    	hotels.deleteAll();
    	Hotel myHotels[] = {
    						new Hotel(1,"Intercontinental", "Rua do Caramulo", 5, myCategories[1]), 
    						new Hotel(2,"Trip", "Rua do Pinheiro", 2, myCategories[2]), 
    						new Hotel(3,"Holiday Inn", "Rua da Fonte", 4, myCategories[3]), 
    						new Hotel(4,"Tulip", "Rua do Lousado", 1, myCategories[4]), 
    						new Hotel(5,"Hostel da Costa", "Rua do Painel", 3, myCategories[2]),
    						new Hotel(6,"Marriot", "Rua do Pico", 5, myCategories[0])};
    	
    	for(Hotel hotel : myHotels) hotels.save(hotel);
    	
    	RoomType[] typesArray = { new RoomType(1, "Single"), new RoomType(2, "Double"), new RoomType(3, "Presidential Suite") };
    	
    	for(RoomType type : typesArray)
    		roomTypes.save(type);    	
    	
    	/* Add rooms to hotels */
    	
    	Room [] roomArrayIntercontinental = { new Room(1, 2, "209", roomTypes.findOne((long) 1)),
    						  				  new Room(2, 3, "310", roomTypes.findOne((long) 3))
    	};
    	
    	Hotel intercontinental = myHotels[0];
    	
    	for(Room room : roomArrayIntercontinental)
    	{
    		intercontinental.getRooms().put(room.getId(), room);
    		log.info("Added room: " + room.getId());
    	}
    	
    	hotels.save(intercontinental);
    	
    	
    	Room [] roomArrayTrip = { new Room(3, 11, "1109", roomTypes.findOne((long) 1)),
				  				  new Room(4, 5, "510", roomTypes.findOne((long) 2)),
				  				  new Room(5, 2, "205", roomTypes.findOne((long) 2))
		};
		
		Hotel trip = myHotels[2];
		
		for(Room room : roomArrayTrip)
		{
			trip.getRooms().put(room.getId(), room);
			log.info("Added room: " + room.getId());
		}
		
		hotels.save(trip);
    	
    	/* ----------------- */
  /*  	
    	    	
    	RoomType [] types = { new RoomType(1, "Single")}
    	
    	for(Roomtype type:types)
    		roomtypes.save(type)
    	
    	Room [] roomArray = { new Room (1, 12, "121", types[0])}
    	
    	Hotel marriot = myHotels[0];
    	
    	for(Room room:roomArray)
    	{
    		marriot.getRooms().add(room);
    		log.info("Added room");
    	}
    	
    	hotels.save(marriot);
    	
    	cascade=CascadeType.ALL -> operacoes feitas no hotel passam para os quartos. incluir isto na relacao onetomany
    	@onetomany (fetch lazy e adicionar cascade)
    	private collection<room> rooms = new arraylist<room>()
    	
    	
    	no roomtype:
    	
    	onetomany(cascade persist)
    	
    	id e descricao
    	
    	private list<room> rooms = new array list()
    	
    	
    	
    	no room:
    	
    	id floor number type
    	
    	@onetomany(mappedby="type")
    	private roomtype type;
    	
    	
    	
    */	
    	
    }

}


