package booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
	public String root(Model model, Authentication authentication) {
		if(authentication != null){
			@SuppressWarnings("unused")
			CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();
		}

		model.addAttribute("hotels", hotels.findAll());
		return "landing-page";
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
