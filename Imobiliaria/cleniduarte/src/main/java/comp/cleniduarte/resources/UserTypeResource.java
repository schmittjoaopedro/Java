package comp.cleniduarte.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import comp.cleniduarte.beans.UserType;
import comp.cleniduarte.services.UserTypeService;


@Controller
@RequestMapping("/usertype")
public class UserTypeResource {

	
	@Autowired private UserTypeService serviceUserType;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object findAll(){
		return this.serviceUserType.findAll();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	public void save(UserType user){
		this.serviceUserType.save(user);
	}
	
}
