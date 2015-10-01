package hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.containsString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


import hello.Application;
import hello.Hotel;
import hello.HotelController;
import hello.HotelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class HotelControllerTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Autowired
	HotelRepository hotels;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	
	@Test
	public void testIndex() throws Exception {
		mvc.perform(get("/hotels")).andExpect(status().isOk())
				.andExpect(view().name("hotels/index"));
	}


	@Test
	public void testAddHotel() throws Exception {
		String hotelName = "new hotel 1"; 
		mvc.perform(post("/hotels")
				.param("id", Integer.toString(0))
                .param("name", hotelName))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/hotels"));;
				
		Hotel hotel = hotels.findOne(hotels.count());
		
		Assert.assertTrue(hotel != null);
		Assert.assertTrue(hotel.getName().equals(hotelName));
	}
	
	@Test
	public void testGetOne() throws Exception {
		String hotelName = "new hotel 1"; 
		mvc.perform(get("/hotels/1"))
				.andExpect(view().name("hotels/show"))
				.andExpect(content().string(containsString(hotelName)));
	}
	
	@Test
	public void testModel() throws Exception {
		mvc.perform(get("/hotels"))
				.andExpect(model().attributeExists("hotels"));
	}
}
