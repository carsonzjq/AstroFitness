package com.astrofitness.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Appointments;
import com.astrofitness.dao.AppointmentsDao;


@Path("/appointment")
public class AppointmentsRest {
	
	
	public AppointmentsRest(){}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/post/appointment")
	public String insertAppointment(Appointments appointment){
		System.out.println(appointment);		
		AppointmentsDao dao = new AppointmentsDao();
		dao.insertAppointment(appointment);
		return "Success";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/all")
	public List<Appointments> getAllAppointments(){
		AppointmentsDao dao = new AppointmentsDao();
		return dao.getAllAppointments();
	}

}