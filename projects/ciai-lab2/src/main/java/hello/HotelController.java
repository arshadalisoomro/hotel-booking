package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Mapping
 * GET  /hotels 			- the list of hotels
 * GET  /hotels/new			- the form to fill the data for a new hotel 
 * POST /hotels         	- creates a new hotel
 * GET  /hotels/{id} 		- the hotel with identifier {id}
 * GET  /hotels/{id}/edit 	- the form to edit the hotel with identifier {id}
 * POST /hotels/{id} 	 	- update the hotel with identifier {id}
 * 
 * GET /hotels/{id}/rooms/{id_room} - the room with identifier {id_room} of hotel with identifier {id}
 * GET /hotels/{id}/rooms/new - the form to fill the data for a new room
 * 
 */

@Controller
@RequestMapping(value="/hotels")
public class HotelController {

    @Autowired
    HotelRepository hotels;
    
    @Autowired
    CategoryRepository categories;
    
    @Autowired
    RoomTypeRepository roomTypes;
    
    @Autowired
    RoomRepository rooms;
   

	// GET  /hotels 			- the list of hotels
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("hotels", hotels.findAll());
        return "hotels/index";
    }

	// GET  /hotels.json 			- the list of hotels
    @RequestMapping(method=RequestMethod.GET, produces={"text/plain","application/json"})
    public @ResponseBody Iterable<Hotel> indexJSON(Model model) {
        return hotels.findAll();
    }

    // GET  /hotels/new			- the form to fill the data for a new hotel
    @RequestMapping(value="/new", method=RequestMethod.GET)
    public String newHotel(Model model) {
    	model.addAttribute("hotel", new Hotel());
//    	model.addAttribute("categories", categories.findAll());
    	return "hotels/create";
    }
    
    // POST /hotels         	- creates a new hotel
    @RequestMapping(method=RequestMethod.POST)
    public String saveIt(@ModelAttribute Hotel hotel, Model model) {
    	hotels.save(hotel);
    	model.addAttribute("hotel", hotel);
    	return "redirect:/hotels";
    }
    
    // GET  /hotels/{id} 		- the hotel with identifier {id}
    @RequestMapping(value="{id}", method=RequestMethod.GET) 
    public String show(@PathVariable("id") long id, Model model) {
    	Hotel hotel = hotels.findOne(id);
    	if( hotel == null )
    		throw new HotelNotFoundException();
    	model.addAttribute("hotel", hotel );
    	return "hotels/show";
    }
    
    // GET  /hotels/{id}.json 		- the hotel with identifier {id}
    @RequestMapping(value="{id}", method=RequestMethod.GET, produces={"text/plain","application/json"})
    public @ResponseBody Hotel showJSON(@PathVariable("id") long id, Model model) {
    	Hotel hotel = hotels.findOne(id);
    	if( hotel == null )
    		throw new HotelNotFoundException();
    	return hotel;
    }
    
    // GET  /hotels/{id}/edit 	- the form to edit the hotel with identifier {id}
    @RequestMapping(value="{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
    	model.addAttribute("hotel", hotels.findOne(id));
    	return "hotels/edit";
    }
   
    // POST /hotels/{id} 	 	- update the hotel with identifier {id}
    @RequestMapping(value="{id}", method=RequestMethod.POST)
    public String editSave(@PathVariable("id") long id, Hotel hotel, Model model) {
    	hotels.save(hotel);
    	return "redirect:/";
    }
    
    // GET  /hotels/{id}/remove 	- removes the hotel with identifier {id}
    @RequestMapping(value="{id}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {
    	hotels.delete(hotels.findOne(id));
    	return "redirect:/";
    }
    
    
    /* ROOMS */
    
    
    // GET  /hotels/{id}/rooms/new - the form to fill the data for a new room
    @RequestMapping(value="{id}/rooms/new", method=RequestMethod.GET)
    public String newRoom(@PathVariable("id") long id, Model model) {
    	model.addAttribute("hotel", hotels.findOne(id));
    	model.addAttribute("room", new Room());
    	return "rooms/create";
    }
    
    // POST /hotels/{id}/rooms/        	- creates a new room
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
    
    @RequestMapping(value="{id}/rooms/{id_room}/edit", method=RequestMethod.GET)
    public String editRoom(@PathVariable("id") long id, @PathVariable("id_room") long id_room, Model model){
    	
    	Hotel hotel = hotels.findOne(id);
    	model.addAttribute("hotel", hotel);
    	model.addAttribute("room", hotel.getRooms().get(id_room));
    	model.addAttribute("roomTypes", roomTypes.findAll()); 
    	return "rooms/edit";
    }
    
}







