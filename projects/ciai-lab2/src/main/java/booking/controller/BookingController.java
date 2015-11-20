package booking.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import booking.model.Booking;
import booking.model.CustomUserDetail;
import booking.model.Hotel;
import booking.model.Room;
import booking.model.RoomType;
import booking.model.User;
import booking.repository.BookingRepository;
import booking.repository.HotelRepository;
import booking.repository.RoomRepository;
import booking.repository.RoomTypeRepository;
import booking.repository.UserRepository;
import booking.security.AllowedForApprovingBookings;
import booking.security.AllowedForHotelManager;
import booking.security.AllowedForRemovingBookings;
import booking.security.AllowedForSystemUsers;
import booking.util.BookingNotFoundException;

@Controller
@RequestMapping(value="/bookings")
@SessionAttributes({"booking", "numberRooms","roomType"})
public class BookingController {

	@Autowired
	BookingRepository bookings;

	@Autowired
	HotelRepository hotels;

	@Autowired
	RoomRepository rooms;

	@Autowired
	UserRepository users;

	@Autowired
	RoomTypeRepository roomTypes;

	@RequestMapping(method=RequestMethod.GET)
	@AllowedForHotelManager
	public String index(Model model) {
		model.addAttribute("bookings", bookings.findAll());
		return "bookings/index";
	}

	@RequestMapping(value="/new/{hotel_id}", method=RequestMethod.GET)
	@AllowedForSystemUsers
	public String bookRoom(Model model, @PathVariable("hotel_id") long hotel_id, @ModelAttribute("booking") Booking booking, @ModelAttribute("numberRooms") int numberRooms,
			@ModelAttribute("roomType") long roomType, Authentication authentication){

		RoomType rt = roomTypes.findOne(roomType);
		List<Date> dates = getDates(booking);
		
		booking.setUser(getCurrentUser());
		Hotel hotel = hotels.findOne(hotel_id);		
		Map<Long,Room> roomsFromHotel = hotel.getRooms();
		List<Room> rooms_available = new ArrayList<Room>();
		int counter = 1;
		for(Long entry : roomsFromHotel.keySet())
		{
			Room r = roomsFromHotel.get(entry);
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
			if(!found && r.getType() == rt && counter <= numberRooms)
			{						
				rooms_available.add(r);
				for(Date date: dates)
					room_bookings.put(date, booking.getId());
				counter++;
			}
			else if(counter > numberRooms)
				break;
		}
		Set<Room> roomsBooking = new HashSet<Room>(rooms_available);
		booking.setRooms(roomsBooking);
		bookings.save(booking);
		model.addAttribute("bookings", bookings.findAll());
		
		CustomUserDetail principal = (authentication != null) ? (CustomUserDetail) authentication.getPrincipal() : null;
		if(principal != null)
		{
			String a = ((SimpleGrantedAuthority) principal.getAuthorities().iterator().next()).getAuthority();
			
			if (a.equals(("ROLE_USER")))
				return "redirect:/users/me";
		}
		
		return "redirect:/bookings";
	}

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newBooking(Model model)
	{
		model.addAttribute("booking", new Booking());
		model.addAttribute("roomTypes", roomTypes.findAll());
		return "bookings/create";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	@AllowedForSystemUsers
	public String searchRooms(@ModelAttribute Booking booking, Model model, @RequestParam("roomType") long roomType, @RequestParam("numberRooms") int numberRooms) {

		RoomType rt = roomTypes.findOne(roomType);
		List<Room> rooms_available = new ArrayList<Room>();
		List<Date> dates = getDates(booking);
		Iterator<Hotel> ithotels = hotels.findAll().iterator();

		while(ithotels.hasNext()){
			Hotel hotel = ithotels.next();
			Map<Long, Room> rooms = hotel.getRooms();
			int counter = 0;
			Room currentRoom = null;
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
				
				if(!found && r.getType().getDescription().equals(rt.getDescription()))
				{						
					counter++;
					currentRoom = r;
				}
			}
			if(counter >= numberRooms)
				rooms_available.add(currentRoom);
		}
		
		model.addAttribute("rooms", rooms_available);
		model.addAttribute("booking", booking);
		model.addAttribute("roomType", rt);
		model.addAttribute("numberRooms", numberRooms);
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

	@RequestMapping(value="/{booking_id}/approve", method=RequestMethod.GET)
	@AllowedForApprovingBookings
	public String approveBooking(Model model, @PathVariable("booking_id") long booking_id){

		Booking booking = bookings.findOne(booking_id);

		if(booking == null)
			throw new BookingNotFoundException();

		booking.setState(true);
		bookings.save(booking);
		return "redirect:/bookings/";
	}

	@RequestMapping(value="/{booking_id}/remove", method=RequestMethod.GET)
	@AllowedForRemovingBookings
	public String removeBooking(Model model, @PathVariable("booking_id") long booking_id, Authentication authentication){
		Booking booking = bookings.findOne(booking_id);

		if(booking == null)
			throw new BookingNotFoundException();

		Set<Room> rooms = booking.getRooms();
		Iterator<Room> it = rooms.iterator();

		while(it.hasNext()){
			Room room = it.next();
			Map<Date, Long> daysReserved = room.getDays_reserved();

			List<Date> dates = getDates(booking);

			for (Date d : dates)
				daysReserved.remove(d);

			room.setDays_reserved(daysReserved);
		}
		
		bookings.delete(booking);
		
		CustomUserDetail principal = (authentication != null) ? (CustomUserDetail) authentication.getPrincipal() : null;
		
		if(principal != null)
		{
			String a = ((SimpleGrantedAuthority) principal.getAuthorities().iterator().next()).getAuthority();
			
			if (a.equals(("ROLE_USER")))
				return "redirect:/users/me";
		}
		
		return "redirect:/bookings";
	}

	private User getCurrentUser(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();    	    
		CustomUserDetail myUser= (CustomUserDetail) auth.getPrincipal(); 
		return myUser.getUser();
    }

}
