package comp.cleniduarte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp.cleniduarte.beans.UserType;
import comp.cleniduarte.dao.UserTypeDao;


@Service
public class UserTypeService {

	@Autowired private UserTypeDao userTypeDao;
	
	public void save(UserType userType){
		this.userTypeDao.save(userType);
	}
	
	public Object findAll(){
		return this.userTypeDao.findAll();
	}
	
}
