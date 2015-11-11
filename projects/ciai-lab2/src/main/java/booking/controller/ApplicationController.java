package booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booking.model.CustomUserDetail;
import booking.repository.HotelRepository;

@Controller
public class ApplicationController {

	@Autowired
	HotelRepository hotels;


	@RequestMapping(value="/")
	public String root(Model model, Authentication authentication) {
		if(authentication != null){
			CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();
		}

		model.addAttribute("hotels", hotels.findAll());
		return "landing-page";
	}
	
}
