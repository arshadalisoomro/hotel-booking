package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class GreetingController {

    @Autowired
    GreetingRepository greetings;
	
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingForm(@ModelAttribute Greeting greeting, Model model) {
        greetings.save(greeting);
        model.addAttribute("greeting", greeting);
        return "result";
    }

    @RequestMapping(value="/listgreetings", method=RequestMethod.GET)
    public String getData(Model model) {
        model.addAttribute("listgreetings", greetings.findAll());
        return "listgreetings";
    }

}
