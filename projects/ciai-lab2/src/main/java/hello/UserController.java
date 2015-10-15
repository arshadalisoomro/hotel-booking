package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserRepository users;
	
	
	// GET  /users 			- the list of users
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("users", users.findAll());
        return "users/index";
    }
    
    // GET  /users/{id}/remove 	- removes the user with identifier {id}
    @RequestMapping(value="{id}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {
    	User user = users.findOne(id);
    	
    	if( user == null )
    		throw new UserNotFoundException();
    	
    	users.delete(user);
    	model.addAttribute("users", users.findAll());
    	return "redirect:/users";
    }  
    
    @RequestMapping(value="{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) { 	
    	User user = users.findOne(id);
    	model.addAttribute("user", user);    	
    	return "users/edit";
    }
    
    // POST /users/{id}        	- edit a user
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @ModelAttribute User user, Model model) {
    	users.save(user);
    	model.addAttribute("user", user);
    	return "redirect:/users/";
    }
	
}
