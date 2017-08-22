package spittr.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;


public class SpitterControllerTest {

	
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		
		SpitterController controller=new SpitterController(null);
		
		MockMvc mockMvc=standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
		
		
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpittleRepository spittleRepository=mock(SpittleRepository.class);
		
		Spitter unsaved=new Spitter("jbausr","24hours","jack","Bauer","123");
		
		Spitter saved=new Spitter("jbausr","24hours","jack","Bauer","123");
		
		when(spittleRepository.saved(unsaved)).thenReturn(saved);
		when(spittleRepository.findByUsername("jbauer")).thenReturn(saved);	
		
		SpitterController spitterController=new SpitterController(spittleRepository);
		MockMvc mockMvc=standaloneSetup(spitterController).build();
		
		mockMvc.perform(post("/spitter/register")
				.param("firstName", "Jack")
				.param("lastName", "Bauer")
				.param("userName", "jbausr")
				.param("password", "24hours")
				.param("email", "123")).andExpect(redirectedUrl("/spitter/jbauer"));
		
	
		verify(spittleRepository,atLeastOnce()).saved(unsaved);
		
		
		
		
	}
	
	
	
	
}
