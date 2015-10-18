package booking;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import booking.model.Booking;
import booking.model.Category;
import booking.model.Comment;
import booking.model.Hotel;
import booking.model.Room;
import booking.model.RoomType;
import booking.model.User;
import booking.repository.BookingRepository;
import booking.repository.CategoryRepository;
import booking.repository.HotelRepository;
import booking.repository.RoomTypeRepository;
import booking.repository.UserRepository;


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

	@Autowired
	UserRepository users;
	
	@Autowired
	BookingRepository bookings;

	@Override
	public void run(String... strings) {

		log.info("Setting up seed data");

		users.deleteAll();
		User myUsers[] = {new User(1,"Pedro", "elcapitan", "123456", "pedro@gmail.com"),
				new User(2,"Manuel", "manuel27", "123456", "manuel@gmail.com"),
				new User(3,"Rui", "rui_cc", "123456", "rui@gmail.com"),
				new User(4,"Henrique", "hcunha", "123456", "henrique@gmail.com")};

		for(User user : myUsers) users.save(user);

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


		roomTypes.deleteAll();
		RoomType[] typesArray = { new RoomType(1, "Single"), new RoomType(2, "Double"), new RoomType(3, "Presidential Suite") };

		for(RoomType type : typesArray)
			roomTypes.save(type);    	

		/* Add rooms to hotels */

		Room [] roomArrayIntercontinental = { new Room(1, 2, "209", roomTypes.findOne((long) 1), myHotels[0]),
				new Room(2, 3, "310", roomTypes.findOne((long) 3), myHotels[0])
		};

		Comment[] commentArray = { new Comment(1, "The best thing about this hotel were the owners. They were lovely friendly people. Giovanni asked us what he"
				+ " could cook for us. In no time we had a delicious pasta all'amatriciana and a mixed meat dish. It was very nice.",
				new Date(), myUsers[0], true, myHotels[0]),
				new Comment(2, "Great getaway destination with a virtually private sand beach 50m from the hotel. No need for a restaurant - Fabiana (owner)"
						+ " cooked exquisite brazilian dishes. Very calm and tranquil place.", new Date(), myUsers[1], false, myHotels[0]),
				new Comment(3, "The hosts are simply amazing and constantly go an extra mile in their efforts to make you feel welcome. Genuine family atmosphere!"
						+ " The hotel is rated as a three-star establishment, but the hosts, deserve seven stars. :)", new Date(), myUsers[2], true, myHotels[0])
		};

		Hotel intercontinental = myHotels[0];

		for(Room room : roomArrayIntercontinental)
		{
			intercontinental.getRooms().put(room.getId(), room);
		}

		for(Comment comment : commentArray)
		{
			intercontinental.getComments().put(comment.getId(), comment);    	
		}

		hotels.save(intercontinental);    	
		
		Booking[] bookingsArray={new Booking(1,new Date(), new Date(), true,myUsers[1],  roomArrayIntercontinental[1])};
		
		for(Booking booking : bookingsArray)
			bookings.save(booking);    	
	}

}


