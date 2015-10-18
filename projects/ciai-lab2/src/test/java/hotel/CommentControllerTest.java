
package hotel;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import booking.Application;
import booking.model.Comment;
import booking.model.Hotel;
import booking.model.User;
import booking.repository.CommentRepository;
import booking.repository.HotelRepository;
import booking.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class CommentControllerTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Autowired
	HotelRepository hotels;
	
	@Autowired
	UserRepository users;
	
	@Autowired
	CommentRepository comments;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
		
	@Test
	public void testIndex() throws Exception
	{
		String hotelName = "Intercontinental"; 
		Hotel hotel = hotels.findByName(hotelName);
		mvc.perform(get("/hotels/" + hotel.getId() + "/comments/")).andExpect(status().isOk())
				.andExpect(view().name("comments/hotel-comments"));
	}
	
	@Test
	public void testGetOne() throws Exception
	{
		String hotelName = "Intercontinental"; 
		Hotel hotel = hotels.findByName(hotelName);
		mvc.perform(get("/hotels/"+ hotel.getId() + "/comments/1"))
				.andExpect(view().name("comments/show"));
	}
	
	@Test
	public void testModel() throws Exception
	{
		String hotelName = "Intercontinental"; 
		Hotel hotel = hotels.findByName(hotelName);
		mvc.perform(get("/hotels/" + hotel.getId() + "/comments/")).andExpect(status().isOk())
				.andExpect(model().attributeExists("hotel"));
	}
	
//	@Test
//	public void testAddComment() throws Exception
//	{
//		String hotelName = "Intercontinental";
//		Hotel hotel = hotels.findByName(hotelName);
//		
//		String userName = "Pedro";
//		User u = users.findByName(userName);
//				
//		mvc.perform(post("/hotels/" + hotel.getId() + "/comments/")
//				.param("id", Integer.toString(0))
//                .param("text", "Comentario"))
//				.andExpect(status().is3xxRedirection())
//				.andExpect(redirectedUrl("/hotels/" + hotel.getId()));;
//				
//		Comment c = comments.findOne((long) 0);		
//		Assert.assertTrue(c != null);
//	}
}
