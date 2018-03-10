package com.astrofitness.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Gym;
import com.astrofitness.dao.GymDao;




@Path("/gym")
public class GymRest {
	
	public GymRest(){}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/all")
	public List<Gym> getAllGym(){
		GymDao dao = new GymDao();
		return dao.getAllGym();
//		
	}

}
