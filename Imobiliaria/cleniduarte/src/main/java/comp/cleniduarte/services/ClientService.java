package comp.cleniduarte.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp.cleniduarte.beans.Client;
import comp.cleniduarte.commons.JsonBeanEncapsule;
import comp.cleniduarte.dao.ClientDao;

@Service
public class ClientService implements IGenericService {

	@Autowired private ClientDao clientDao;
	
	public JsonBeanEncapsule save(Object record) {
		JsonBeanEncapsule jsonBean = new JsonBeanEncapsule();
		try {
			this.clientDao.save(record);
			jsonBean.setSuccess(true);
			jsonBean.setRecords(record);
			jsonBean.setCount(1);
		}catch(Exception e){
			jsonBean.setSuccess(false);
		}
		return jsonBean;
	}

	public JsonBeanEncapsule delete(Long id) {
		JsonBeanEncapsule jsonBean = new JsonBeanEncapsule();
		try{
			jsonBean.setRecords(this.clientDao.getSingle(id));
			this.clientDao.delete(id);
			jsonBean.setSuccess(true);
			jsonBean.setCount(1);
		}catch(Exception e){
			jsonBean.setSuccess(false);
		}
		return jsonBean;
	}

	public JsonBeanEncapsule update(Object record) {
		JsonBeanEncapsule jsonBean = new JsonBeanEncapsule();
		try{
			Client c = (Client) record;
			jsonBean.setRecords(this.clientDao.getSingle(c.getId()));
			this.clientDao.update(record);
			jsonBean.setSuccess(true);
			jsonBean.setCount(1);
		}catch(Exception e){
			jsonBean.setSuccess(false);
		}
		return jsonBean;
	}

	public JsonBeanEncapsule findAll() {
		JsonBeanEncapsule jsonBean = new JsonBeanEncapsule();
		try{
			List<Client> clients = this.clientDao.findAll();
			jsonBean.setRecords(clients);
			jsonBean.setSuccess(true);
			jsonBean.setCount(clients.size());
		}catch(Exception e){
			jsonBean.setSuccess(false);
		}
		return jsonBean;
	}

	public JsonBeanEncapsule findPaginate(int start, int limit) {
		JsonBeanEncapsule jsonBean = new JsonBeanEncapsule();
		try{
			List<Client> clients = this.clientDao.getPaginationData(start, limit);
			jsonBean.setRecords(clients);
			jsonBean.setSuccess(true);
			jsonBean.setCount(clients.size());
		}catch(Exception e){
			jsonBean.setSuccess(false);
		}
		return jsonBean;
	}
	
}
