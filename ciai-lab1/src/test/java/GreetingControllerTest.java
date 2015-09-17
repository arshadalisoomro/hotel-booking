
import hello.GreetingController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; 
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;


public class GreetingControllerTest {

	@Test
	public void testGreetingPage() throws Exception {
		GreetingController controller = new GreetingController();
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/greeting")).andExpect(view().name("greeting"));
	} 

}
