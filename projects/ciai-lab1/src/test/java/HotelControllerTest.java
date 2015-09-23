
import hello.HotelController;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.Before;
import org.junit.Test;


/**
 * We are using MockServletContext to set up an empty WebApplicationContext 
 * so the GreetingController can be created in the @Before and passed to 
 * MockMvcBuilders.standaloneSetup().
 * @author CIAI team
 *
 */
public class HotelControllerTest {
	
	private MockMvc mvcApp;
	
	@Before
	public void setUp() throws Exception {
		mvcApp = MockMvcBuilders.standaloneSetup(new HotelController()).build();
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

