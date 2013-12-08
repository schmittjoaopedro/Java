package comp.cleniduarte.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HomeResources {
	
	//Implementations...
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "/client", method=RequestMethod.GET)
	public String indexClient(){
		return "/client/index";
	}


	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String admin(){
		return "/login/index";
	}
}
