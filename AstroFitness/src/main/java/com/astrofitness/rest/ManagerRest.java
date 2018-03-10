package com.astrofitness.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Manager;
import com.astrofitness.dao.ManagerDao;

@Path("/manager")
public class ManagerRest {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authenticate")
	public Manager getManagerAccount(Manager manager ) {
		System.out.println(manager);
		ManagerDao dao = new ManagerDao();
		return dao.authenticate(manager.getEmail(), manager.getPassword());
				
	}

}
