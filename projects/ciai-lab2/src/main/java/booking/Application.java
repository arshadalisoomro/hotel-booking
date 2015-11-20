package booking;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import booking.model.Booking;
import booking.model.Room;
import booking.model.User;
import booking.repository.AuthorityRepository;
import booking.repository.BookingRepository;
import booking.repository.RoomRepository;
import booking.repository.UserRepository;
import booking.security.SecurityConfig;

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

	@Autowired
	BookingRepository bookings;

	@Autowired
	RoomRepository rooms;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings)
	{
		Iterator<User> it = users.findAll().iterator();

		while(it.hasNext()){
			User u1 = it.next();
			String pass = u1.getPassword();
			u1.setPassword(SecurityConfig.encoder.encode(pass));
			users.save(u1);
		}

		Iterator<Booking> books = bookings.findAll().iterator();

		while(books.hasNext()){
			Booking book = books.next();
			Date begin = book.getBegin_date();
			Date end = book.getEnd_date();
			List<Date> dates = new ArrayList<Date>();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(begin);

			while (calendar.getTime().getTime() <= end.getTime())
			{
				Date result = calendar.getTime();			
				dates.add(result);				
				calendar.add(Calendar.DATE, 1);       
			}  

			Map<Date, Long> tmpMap = new HashMap<Date, Long>();

			for(Date d : dates)
			{
				tmpMap.put(d, book.getId());
			}

			Set<Room> rt = book.getRooms();

			for(Room r : rt)
			{
				r.setDays_reserved(tmpMap);
				rooms.save(r);
			}

			bookings.save(book);
		}
	}

	public Date removeTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}


