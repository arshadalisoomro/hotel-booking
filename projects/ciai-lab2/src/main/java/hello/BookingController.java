package hello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bookings")
public class BookingController {

	@Autowired
	BookingRepository bookings;
	
	@Autowired
	HotelRepository hotels;
	
	@RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
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
    	
    	List<Room> rooms_available = new ArrayList<Room>();
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
    				rooms_available.add(r);
    		}
    	}
    	model.addAttribute("rooms", rooms_available);
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
