
import hello.Application;
import hello.Hotel;
import hello.HotelController;
import hello.HotelRepository;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * We are using MockServletContext to set up an empty WebApplicationContext 
 * so the GreetingController can be created in the @Before and passed to 
 * MockMvcBuilders.standaloneSetup().
 * @author CIAI team
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HotelControllerTest {
	
	private MockMvc mvcApp;

	@Autowired
	HotelRepository hotels;
		
	@Before
	public void setUp() throws Exception {
		mvcApp = MockMvcBuilders.standaloneSetup(new HotelController()).build();
		hotels.save(new Hotel(1,"Estoril Sol"));
		hotels.save(new Hotel(2,"Villa Italia"));		
	}

	@Test
	public void testIndex() throws Exception {
		mvcApp.perform(MockMvcRequestBuilders.get("/hotels")).
			andExpect(MockMvcResultMatchers.view().name("hotels/index")).
			andExpect(MockMvcResultMatchers.model().attributeExists("hotels"));
	} 

	@Test
	public void testShow() throws Exception {
		mvcApp.perform(MockMvcRequestBuilders.get("/hotels/1")).
			andExpect(MockMvcResultMatchers.view().name("hotels/show")).
			andExpect(MockMvcResultMatchers.model().attributeExists("hotel"));
	} 
}

