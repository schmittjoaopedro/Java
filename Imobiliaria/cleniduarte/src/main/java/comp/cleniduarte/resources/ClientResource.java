package comp.cleniduarte.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import comp.cleniduarte.beans.Client;
import comp.cleniduarte.services.ClientService;


@Controller
@RequestMapping("/client")
public class ClientResource {

	
	@Autowired private ClientService clienteService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list(){
		return this.clienteService.findAll();
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	@ResponseBody
	public Object save(Client client){
		this.clienteService.save(client);
		return client;
	}
	
}
