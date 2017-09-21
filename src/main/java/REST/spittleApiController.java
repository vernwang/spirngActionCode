package REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class spittleApiController {

	private static final String MAX_LONG="922222";
	private SpittleRepository spittleRepository;
	
	@Autowired
	public spittleApiController(SpittleRepository spittleRepository) {
		this.spittleRepository=spittleRepository;
	}

	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max",defaultValue=MAX_LONG) Long max,
			@RequestParam(value="count",defaultValue="20")int count
			){
		return null;
	}
	
	
}
