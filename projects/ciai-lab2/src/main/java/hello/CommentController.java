package hello;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hotels")
public class CommentController {
	
	@Autowired
	HotelRepository hotels;
	
	@Autowired
	CommentRepository comments;
	
//    @RequestMapping(value="/{id}/comments", method=RequestMethod.GET)
//    public String newComment(@PathVariable("id") long id, Model model) {
//    	model.addAttribute("hotel", hotels.findOne(id));
//    	return "redirect:";
//    }
    
    @RequestMapping(value="/{id}/comments/", method = RequestMethod.POST)
    public String createComment(@ModelAttribute Comment comment, @PathVariable("id") long id, Model model){
    	Hotel hotel = hotels.findOne(id);
    	Date date = new Date();
    	comment.setDate(date);
    	comments.save(comment);
    	
    	hotel.getComments().put(comment.getId(), comment);
    	hotels.save(hotel);
    	model.addAttribute("hotel", hotel);
    	
    	return "redirect:/hotels/{id}/";
    }
    
    @RequestMapping(value="/{id}/comments/new", method = RequestMethod.GET)
    public String newComment(@ModelAttribute Comment comment, @PathVariable("id") long id, Model model){
    	model.addAttribute("comment", new Comment());
    	model.addAttribute("hotel", hotels.findOne(id));
    	return "comments/create";
    }
    
    // GET  /hotels/{id}/rooms/ - show the list of rooms of the hotel
    @RequestMapping(value="{id}/comments/", method=RequestMethod.GET)
    public String showRooms(@PathVariable("id") long id, Model model) {
    	Hotel hotel = hotels.findOne(id);
    	model.addAttribute("hotel", hotel);
    	return "comments/hotel-comments";
    }
    
}
