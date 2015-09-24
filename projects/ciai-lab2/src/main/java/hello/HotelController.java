package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * Mapping
 * GET  /hotels 			- the list of hotels
 * GET  /hotels/new			- the form to fill the data for a new hotel 
 * POST /hotels         	- creates a new hotel
 * GET  /hotels/{id} 		- the hotel with identifier {id}
 * GET  /hotels/{id}/edit 	- the form to edit the hotel with identifier {id}
 * POST /hotels/{id} 	 	- update the hotel with identifier {id}
 */

@Controller
@RequestMapping(value="/hotels")
public class HotelController {

    @Autowired
    HotelRepository hotels;

	// GET  /hotels 			- the list of hotels
    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("hotels", hotels.findAll());
        return "hotels/index";
    }

    // GET  /hotels/new			- the form to fill the data for a new hotel 
}
