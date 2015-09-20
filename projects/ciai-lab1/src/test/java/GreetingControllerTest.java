
import hello.GreetingController;

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
public class GreetingControllerTest {
	
	private MockMvc mvcApp;
	
	@Before
	public void setUp() throws Exception {
		mvcApp = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

	@Test
	public void testGreetingPage() throws Exception {
		mvcApp.perform(MockMvcRequestBuilders.get("/greeting")).andExpect(MockMvcResultMatchers.view().name("greeting"));
	} 

}

