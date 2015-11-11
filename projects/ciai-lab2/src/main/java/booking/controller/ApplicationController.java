package booking.controller;

<<<<<<< HEAD
import org.springframework.security.core.Authentication;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> c4fd1309149a1b477005cfcfbf173bbdbe7b9747
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import booking.model.CustomUserDetail;
=======
import booking.repository.HotelRepository;
>>>>>>> c4fd1309149a1b477005cfcfbf173bbdbe7b9747

@Controller
public class ApplicationController {
	
	@Autowired
	HotelRepository hotels;
	
	
	@RequestMapping(value="/")
<<<<<<< HEAD
	public String root(Model model, Authentication authentication) {
		if(authentication != null){
			CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();
		}
		
		return "index";
=======
	public String root(Model model)
	{
		model.addAttribute("hotels", hotels.findAll());
		return "landing-page";
>>>>>>> c4fd1309149a1b477005cfcfbf173bbdbe7b9747
	}
}
