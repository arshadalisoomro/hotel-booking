package booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booking.model.CustomUserDetail;
import booking.repository.HotelRepository;
import booking.repository.UserRepository;

@Controller
public class ApplicationController {

	@Autowired
	HotelRepository hotels;
	
	@Autowired
	UserRepository users;

	@RequestMapping(value="/")
	public String root(Model model) {
		model.addAttribute("hotels", hotels.findAll());
		return "landing-page";
	}
	
	@RequestMapping(value="/signedin")
	public String signedIn(Model model, Authentication authentication) {
		
		CustomUserDetail principal = (authentication != null) ? (CustomUserDetail) authentication.getPrincipal() : null;

		if (principal != null) {
			String a = ((SimpleGrantedAuthority) principal.getAuthorities().iterator().next()).getAuthority();
			if (a.equals(("ROLE_ADMIN")))
				return "redirect:/admin";
			else if (a.equals("ROLE_COMMENT_MODERATOR"))
				return "redirect:/comments/moderation";
			else if (a.equals(("ROLE_USER")))
				return "redirect:/users/me";
			else if (a.equals("ROLE_HOTEL_MANAGER"))
				return "redirect:/bookings";
		}
		
		return "/"; // fallback
	}
	
	@RequestMapping(value="/comments/moderation")
	public String moderateComments(Model model)
	{
		model.addAttribute("hotels", hotels.findAll());
		return "comments/comment-moderating";
	}
	
	@RequestMapping(value="/admin")
	public String manageUsers(Model model)
	{
		model.addAttribute("users", users.findAll());
		model.addAttribute("hotels", hotels.findAll());
		return "admin-dashboard";
	}
}
