package spittr.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";  //假如只返回String，那么就是view的逻辑名
	}
	
}
