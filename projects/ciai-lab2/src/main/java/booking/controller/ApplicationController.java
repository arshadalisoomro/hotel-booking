package booking.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import booking.model.CustomUserDetail;

@Controller
public class ApplicationController {
	
	@RequestMapping(value="/")
	public String root(Model model, Authentication authentication) {
		if(authentication != null){
			CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();
		}
		
		return "index";
	}
}
