package spittr.web;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.bcel.internal.generic.NEW;

import spittr.Spitter;
import spittr.data.SpittleRepository;
@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpitterController(SpittleRepository spittleRepository) {
		this.spittleRepository=spittleRepository;
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";  //假如只返回String，那么就是view的逻辑名
	}
	
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String processRegister(@Valid Spitter spitter,Errors errors) {
		
		if (errors.hasErrors()) {
			return "registerForm";
		}
		
		spittleRepository.saved(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
	
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String processRegister2( Spitter spitter, Model model) {
		
		spittleRepository.saved(spitter);
		
		model.addAttribute("username", spitter.getUsername());
		
		
		 
		return "redirect:/spitter/{username}";
	}
	
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable String username,Model model) {
		
		Spitter spitter=spittleRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(
			@RequestPart("profilePicture") MultipartFile profilePitcure,
			@RequestPart("profilePicture") Part profile,
			@Valid Spitter spitter,
			Errors errors
			) throws IllegalStateException, IOException {
		profilePitcure.transferTo(new File("/data/spittr/"+profilePitcure.getOriginalFilename()));
		profile.write("/data/spittr/"+profilePitcure.getOriginalFilename());
		return "register";
		
	}
	
	
	
	private void saveImage(MultipartFile image) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
