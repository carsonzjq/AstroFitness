package com.astrofitness.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Client;
import com.astrofitness.dao.ClientDao;


@Path("/client")
public class ClientRest {
	
	
	public ClientRest(){}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/newClient")
	public String insertClient(Client client){
		System.out.println(client);
		
		ClientDao dao = new ClientDao();
		dao.insertClient(client);
		return "Success";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authenticate")
	public Client getClientAccount(Client client ) {
		System.out.println(client);
		ClientDao dao = new ClientDao();
		return dao.authenticate(client.getEmail(), client.getPassword());
	}

}
