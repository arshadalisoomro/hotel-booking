package booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booking.repository.HotelRepository;

@Controller
public class ApplicationController {
	
	@Autowired
	HotelRepository hotels;
	
	
	@RequestMapping(value="/")
	public String root(Model model)
	{
		model.addAttribute("hotels", hotels.findAll());
		return "landing-page";
	}
}
