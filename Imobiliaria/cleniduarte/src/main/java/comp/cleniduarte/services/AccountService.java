package comp.cleniduarte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp.cleniduarte.dao.AccountDao;

@Service
public class AccountService {

	@Autowired private AccountDao accountDao;
	
	public Object findAll(){
		return accountDao.findAll();
	}
	
}
