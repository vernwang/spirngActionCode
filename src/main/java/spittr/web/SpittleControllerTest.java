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


public class SpittleControllerTest {

	
	@Test
	public void shouldShowPageSpittles() throws Exception {
		List<Spittle> exceptedSpittles=createSpittleList(50);
		SpittleRepository mockRepository=mock(SpittleRepository.class);
		when(mockRepository.findSpittles(238900, 50)).thenReturn(exceptedSpittles);
		
		SpittleController controller=new SpittleController(mockRepository);
		MockMvc mockMvc=standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/"
				+ "views/spittles.jsp")).build();
		
		
		mockMvc.perform(get("/spittles?max=238900&count=50")).andExpect(view().name("spittles"))
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
	
	
	@Test
	public void testSpittles() throws Exception {
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		
		SpittleRepository mockRepository=mock(SpittleRepository.class);
		when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
		
		SpittleController spittleController=new SpittleController(mockRepository);
		
		MockMvc mockMvc=standaloneSetup(spittleController).build();
		
		mockMvc.perform(get("/spittles/12345")).andExpect(view().name("spittle"))
		.andExpect(model().attributeExists("spittle"))
		.andExpect(model().attribute("spittle", expectedSpittle));
		
		
		
	}
	
	
}
