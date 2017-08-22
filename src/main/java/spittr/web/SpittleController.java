package spittr.web;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAccumulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private static final String MAX_LONG_1AS_STRING=Long.toString(Long.MAX_VALUE);

	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository=spittleRepository;
	}
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String spittle(Model model) {
//		// model自动推断key未 spittleList
//		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20)); 
//		return "spittles";
//		
//		//显式声明
////		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		
//	}
	
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String spittle2(Map model) {
//		// model自动推断key未 spittleList
//		model.put("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20)); 
//		return "spittles1";
//		
//	}
	
	

//	@RequestMapping(method=RequestMethod.GET)
//	public List<Spittle> spittle3(Map model) {
//		//这种操作方式，会将值放到模型汇总，模型的key会根据其类型推断而出。
//		//而逻辑视图的名称将会根据请求路径推断出。 这个请求是“／spittles”,因此视图名将会是spittles
//		return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//		
//	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittle(
		@RequestParam(value="max",defaultValue="123456")Long max,
		@RequestParam(value="count",defaultValue="20") int count) {
		
		return spittleRepository.findSpittles(max, count);
	}

	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
	public String spittle2(
			@PathVariable("spittleId") int spittleId,
			Model model 
			){
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittle1(
		@RequestParam(value="max",defaultValue="123456")Long max,
		@RequestParam(value="count",defaultValue="20") int count) {
		
		if(1==1) {
			throw new SpittlesNotFoundException();
		}
		return spittleRepository.findSpittles(max, count);
	}
	
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle(){
		return "error/duplicate";
	}
	
	
}
