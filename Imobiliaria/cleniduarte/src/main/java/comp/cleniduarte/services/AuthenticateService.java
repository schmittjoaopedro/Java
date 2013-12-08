package comp.cleniduarte.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp.cleniduarte.beans.Account;
import comp.cleniduarte.dao.AccountDao;

@Service
public class AuthenticateService {
	
	@Autowired private AccountDao accountDao;
	
	public Account authenticateUser(String login, String password){
		Account account = this.accountDao.getByNameAndPassowrd(login, password);
		return account;
	}
	
	
	public boolean validateUser(HttpSession session){
		if(session.getAttribute("user") !=null){
			return true;
		}else{
			return false;
		}
	}
	
}
