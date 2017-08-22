package spittr.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;


public class HomeControllerTest {

	@Test
	public void testHomePage() {
		HomeController controller=new HomeController();
		assertEquals("home", controller.home());
	}
	
	@Test
	public void testHomePage2() throws Exception {
		HomeController controller=new HomeController();
		
		MockMvc mockMvc=standaloneSetup(controller).build();
		
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	
	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> exceptedSpittles=createSpittleList(20);
		SpittleRepository mockRepository=mock(SpittleRepository.class);
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(exceptedSpittles);
		
		SpittleController controller=new SpittleController(mockRepository);
		MockMvc mockMvc=standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/"
				+ "views/spittles.jsp")).build();
		
//		MockMvc mockMvc=standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spittles")).andExpect(view().name("spittles1"))
			.andExpect(model().attributeExists("spittleList"))
			.andExpect(model().attribute("spittleList", hasItems(exceptedSpittles.toArray())));
		
		
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles=new ArrayList<Spittle>();
		
		for(int i=0;i<count;i++) {
			spittles.add(new Spittle("Spittle "+i, new Date()));
		}
		
		return spittles;
	}
	
	
}
