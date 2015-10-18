package booking.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import booking.model.Booking;
import booking.model.Hotel;
import booking.model.Room;
import booking.model.User;
import booking.repository.BookingRepository;
import booking.repository.HotelRepository;
import booking.repository.RoomRepository;

@Controller
@RequestMapping(value="/bookings")
public class BookingController {

	@Autowired
	BookingRepository bookings;
	
	@Autowired
	HotelRepository hotels;
	@Autowired
	RoomRepository rooms;
	
	User user = new User(5,"Tiago", "tds", "123456", "tds@gmail.com");
	
	@RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("bookings", bookings.findAll());
        return "bookings/index";
    }
	
	@RequestMapping(value="/new/{room_id}", method=RequestMethod.POST)
	public String bookRoom(Model model, @PathVariable("room_id") long room_id, @ModelAttribute Booking booking){

//		System.out.println("bookRoom");
//		System.out.println("ID: " + booking.getId());
//		System.out.println(booking.getId());
//		System.out.println(begin_date);
//		System.out.println(booking.getBegin_date());
//		System.out.println(booking.getEnd_date());
//		System.out.println(booking);
		
//		booking.setUser(user);
//		Room room = rooms.findOne(room_id);
//		if(room == null)
//			throw new RoomNotFoundException();
//		
//		booking.setRoom(room);
//		bookings.save(booking);
		
//		Map<Long, Booking> booking_map = room.getBookings();
//		booking_map.put(booking.getId(), booking);
//		room.setBookings(booking_map);
		
//		Map<Date, Long> days_reserved = room.getDays_reserved();
//		
//		List<Date> dates_list = getDates(booking);
		
//		for(Date date: dates_list)
//			days_reserved.put(date, booking.getId());
//		
//		room.setDays_reserved(days_reserved);
		
		model.addAttribute("bookings", bookings.findAll());
		return "bookings/index";
	}
	
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newBooking(Model model) {
    	model.addAttribute("booking", new Booking());
    	return "bookings/create";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String searchRooms(@ModelAttribute Booking booking, Model model) {
    	
    	Map<Room, Hotel> rooms_available = new HashMap<Room,Hotel>();
    	List<Date> dates = getDates(booking);
    	
    	Iterator<Hotel> ithotels = hotels.findAll().iterator();
    	
    	while(ithotels.hasNext()){
    		Hotel hotel = ithotels.next();
    		Map<Long, Room> rooms = hotel.getRooms();
    		for(Entry<Long, Room> room : rooms.entrySet()){
    			Room r = room.getValue();
    			Map<Date, Long> room_bookings = r.getDays_reserved();
    			boolean found = false;
    			Iterator<Date> itDates = dates.iterator();

    			while(itDates.hasNext()){
    				Date day = itDates.next();
    				if(room_bookings.get(day) != null){
    					found = true;
    					break;
    				}
    			}	
    			if(!found)
    				rooms_available.put(r, hotel);
    		}
    	}
    	model.addAttribute("rooms", rooms_available);
    	model.addAttribute("booking", booking);
    	return "bookings/results";
    }
    
    private List<Date> getDates(Booking booking){
    	
    	List<Date> dates = new ArrayList<Date>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(booking.getBegin_date());

        while (calendar.getTime().getTime() <= booking.getEnd_date().getTime()){
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);       
        }      
        return dates;
    }
	
}
