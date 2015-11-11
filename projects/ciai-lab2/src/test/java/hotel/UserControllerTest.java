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
import booking.model.User;
import booking.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Autowired
	UserRepository users;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	
	@Test
	public void testIndex() throws Exception
	{
		mvc.perform(get("/users")).andExpect(status().isOk())
				.andExpect(view().name("users/index"));
	}

	@Test
	public void testAddUser() throws Exception {
		
		String userName = "Ruben"; 
		mvc.perform(post("/users")
				.param("id", Integer.toString(0))
                .param("name", userName)
                .param("email", "a@a.pt")
                .param("username", "rb")
                .param("password", "abcabc"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/users"));;
				
		User u = users.findByUsername(userName);
		
		Assert.assertTrue(u != null);
	}
	
	@Test
	public void testGetOne() throws Exception
	{
		String userName = "Pedro"; 
		User u = users.findByUsername(userName);
		mvc.perform(get("/users/"+ u.getId()))
				.andExpect(view().name("users/show"));
	}
	
	@Test
	public void testModel() throws Exception {
		mvc.perform(get("/users"))
				.andExpect(model().attributeExists("users"));
	}
}
