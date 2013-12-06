package comp.cleniduarte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp.cleniduarte.beans.Client;
import comp.cleniduarte.dao.ClientDao;

@Service
public class ClientService {

	@Autowired private ClientDao clientDao;
	
	public Object list(){
		return this.clientDao.findAll();
	}
	
	public void save(Client client){
		this.clientDao.save(client);
	}
	
}
