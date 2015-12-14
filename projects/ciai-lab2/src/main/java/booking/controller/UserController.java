package booking.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import booking.model.Authority;
import booking.model.Booking;
import booking.model.CustomUserDetail;
import booking.model.CustomUserDetailsService;
import booking.model.User;
import booking.repository.AuthorityRepository;
import booking.repository.BookingRepository;
import booking.repository.UserRepository;
import booking.security.AllowedForAdmin;
import booking.security.AllowedForManageUser;
import booking.security.SecurityConfig;
import booking.util.HotelNotFoundException;
import booking.util.UserNotFoundException;

@Controller
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	UserRepository users;

	@Autowired
	BookingRepository bookings;

	@Autowired
	AuthorityRepository authorities;

	@Autowired 
	private AuthenticationManager authMgr;

	@Autowired 
	private CustomUserDetailsService customUserDetailsSvc;

	// GET  /users 			- the list of users
	@RequestMapping(method=RequestMethod.GET)
	@AllowedForAdmin
	public String index(Model model) {
		model.addAttribute("users", users.findAll());
		return "users/index";
	}

	// GET  /users/new			- the form to fill the data for a new user
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newHotel(Model model) {
		model.addAttribute("user", new User());
		return "users/create";
	}

	// POST /users         	- creates a new user
	@RequestMapping(method=RequestMethod.POST)
	public String saveIt(@ModelAttribute User user, Model model)
	{
		try{
			Authority authority = authorities.findByRole("ROLE_USER");
			user.setAuthority(authority);
			String pass = user.getPassword();
			user.setPassword(SecurityConfig.encoder.encode(user.getPassword()));
			users.save(user);
			UserDetails userDetails = customUserDetailsSvc.loadUserByUsername(user.getUsername());
			
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, pass, userDetails.getAuthorities());
			authMgr.authenticate(auth);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return "redirect:/users/me";
			 
		}
		catch(Exception e){
			return "error";
		}
	}

	// GET /login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "index";
	}

	// GET  /users/{id} 		- the user with identifier {id}
	@RequestMapping(value="{id}", method=RequestMethod.GET) 
	@AllowedForManageUser
	public String show(@PathVariable("id") long id, Model model) {
		User user = users.findOne(id);
		if( user == null )
			throw new HotelNotFoundException();    	
		model.addAttribute("user", user);    
		model.addAttribute("bookings", getUserBookings(user.getId()));   
		return "users/show";
	}

	@RequestMapping(value="/me", method=RequestMethod.GET)
	public String showActiveProfile(Model model) throws HotelNotFoundException
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();    	    
		CustomUserDetail myUser= (CustomUserDetail) auth.getPrincipal();
		User user = users.findOne(myUser.getUser().getId());
		model.addAttribute("bookings", getUserBookings(user.getId()));    	    	
		model.addAttribute("user", user);
		return "users/show";
	}

	public Iterable<Booking> getUserBookings(long user_id)
	{
		Iterator<Booking> itbookings = bookings.findAll().iterator();
		List<Booking> bookingsList = new ArrayList<Booking>();

		while(itbookings.hasNext())
		{
			Booking b = itbookings.next();
			if(b.getUser().getId() == user_id)
				bookingsList.add(b);
		}

		return bookingsList;
	}    

	// GET  /users/{id}/remove 	- removes the user with identifier {id}
	@RequestMapping(value="{id}/remove", method=RequestMethod.GET)
	@AllowedForManageUser
	public String remove(@PathVariable("id") long id, Model model) {
		User user = users.findOne(id);    	
		if( user == null )
			throw new UserNotFoundException();    	
		users.delete(user);
		model.addAttribute("users", users.findAll());
		return "users/index";
	}  

	// GET /users/{id}/edit - form to edit user
	@RequestMapping(value="{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model) { 	
		User user = users.findOne(id);
		model.addAttribute("user", user);    	
		model.addAttribute("authorities", authorities.findAll());
		return "users/edit";
	}

	// POST /users/{id}        	- edit a user
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") long id, @ModelAttribute User user, Model model)
	{
		users.save(user);
		model.addAttribute("user", user);
		return "redirect:/admin";
	}	
}
