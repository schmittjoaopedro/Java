package comp.cleniduarte.resources;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import comp.cleniduarte.beans.Account;
import comp.cleniduarte.services.AccountService;
import comp.cleniduarte.services.AuthenticateService;

@Controller
@RequestMapping("/admin")
public class AuthenticateResource {

	@Autowired private AuthenticateService authenticateService;
	@Autowired private AccountService accountService;
	
	@RequestMapping(value = "/authenticate", method=RequestMethod.POST)
	public String authenticate(@RequestParam String login, @RequestParam String password, HttpSession session){
		Account account = this.authenticateService.authenticateUser(login, password);
		if(account != null){
			session.setAttribute("user", account);
			return "/login/main";
		}else{
			return "/login/index";
		}
	}
	
	@RequestMapping("/account/list")
	@ResponseBody
	public Object findAll(HttpSession session){
		if(this.authenticateService.validateUser(session)){
			return this.accountService.findAll();
		}else{
			return "/login/index";
		}
		
	}
	
}
