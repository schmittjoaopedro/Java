package comp.cleniduarte.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comp.cleniduarte.beans.Account;

@Repository
public class AccountDao extends GenericDao<Long, Account>{ 
	
	@Transactional
	public Account getByNameAndPassowrd(String login, String password){
		Query query = super.getSession().getCurrentSession().createQuery("from Account where name=:name and password=:password");
		query.setParameter("name", login);
		query.setParameter("password", password);
		return (Account) query.uniqueResult();
	}
	
}
