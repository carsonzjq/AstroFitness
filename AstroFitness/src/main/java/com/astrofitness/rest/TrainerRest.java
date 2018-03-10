package com.astrofitness.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Client;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.ClientDao;
import com.astrofitness.dao.TrainerDao;


@Path("/trainer")
public class TrainerRest {
	
	
	public TrainerRest(){}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/newTrainer")
	public String insertTrainer(Trainer trainer){
		System.out.println(trainer);		
		TrainerDao dao = new TrainerDao();
		dao.insertTrainer(trainer);
		return "Success";
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/authenticate")
	public Trainer getTrainerAccount(Trainer trainer) {
		System.out.println(trainer);
		TrainerDao dao = new TrainerDao();
		return dao.authenticate(trainer.getEmail(), trainer.getPassword());
				
	}

}