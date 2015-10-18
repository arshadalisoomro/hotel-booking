package booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import booking.model.Hotel;
import booking.model.Room;
import booking.repository.HotelRepository;
import booking.repository.RoomRepository;
import booking.repository.RoomTypeRepository;

@Controller
@RequestMapping(value="/hotels")
public class RoomController {

    @Autowired
    HotelRepository hotels;
    
    @Autowired
    RoomTypeRepository roomTypes;
    
    @Autowired
    RoomRepository rooms;
    
    // GET  /hotels/{id}/rooms/new - the form to fill the data for a new room
    @RequestMapping(value="{id}/rooms/new", method=RequestMethod.GET)
    public String newRoom(@PathVariable("id") long id, Model model) {
    	model.addAttribute("hotel", hotels.findOne(id));
    	model.addAttribute("room", new Room());
    	model.addAttribute("roomTypes", roomTypes.findAll());
    	return "rooms/create";
    }
    
    // POST /hotels/{id}/rooms/ - creates a new room
    @RequestMapping(value="{id}/rooms/", method=RequestMethod.POST)
    public String saveRoom(@PathVariable("id") long id, @ModelAttribute Room room, Model model) {    	
    	Hotel hotel = hotels.findOne(id);
    	room.setType(roomTypes.findOne(room.getType().getId()));
    	rooms.save(room);
    	hotel.getRooms().put(room.getId(), room);
    	hotels.save(hotel);
    	model.addAttribute("hotel", hotel);
    	model.addAttribute("room", room);
    	return "rooms/show";
    }
    
    // GET  /hotels/{id}/rooms/{id} - show a room
    @RequestMapping(value="{id}/rooms/{id_room}", method=RequestMethod.GET)
    public String showRoom(@PathVariable("id") long id, @PathVariable("id_room") long id_room, Model model) {
    	Hotel hotel = hotels.findOne(id);
    	model.addAttribute("hotel", hotel);
    	model.addAttribute("room", hotel.getRooms().get(id_room));
    	return "rooms/show";
    }
    
    // GET  /hotels/{id}/rooms/ - show the list of rooms of the hotel
    @RequestMapping(value="{id}/rooms/", method=RequestMethod.GET)
    public String showRooms(@PathVariable("id") long id, Model model) {
    	Hotel hotel = hotels.findOne(id);
    	model.addAttribute("hotel", hotel);
    	return "rooms/hotel-rooms";
    }
    
    // GET /hotels/{id}/rooms/{id_room}/edit - shows the form to edit a room
    @RequestMapping(value="{id}/rooms/{id_room}/edit", method=RequestMethod.GET)
    public String editRoom(@PathVariable("id") long id, @PathVariable("id_room") long id_room, Model model) {
    	
    	Hotel hotel = hotels.findOne(id);
    	model.addAttribute("hotel", hotel);
    	model.addAttribute("room", hotel.getRooms().get(id_room));
    	model.addAttribute("roomTypes", roomTypes.findAll()); 
    	return "rooms/edit";
    }
    
    @RequestMapping(value="{id}/rooms/{id_room}/remove", method=RequestMethod.GET)
    public String removeRoom(@PathVariable("id") long id, @PathVariable("id_room") long id_room, Model model){
    	
    	Hotel hotel = hotels.findOne(id);
    	hotel.getRooms().remove(id_room);
    	rooms.delete(id_room);
    	model.addAttribute("hotel", hotel);
		return "redirect:/hotels/{id}/rooms/";	
    }
}
