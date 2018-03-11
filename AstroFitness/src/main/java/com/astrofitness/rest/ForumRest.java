package com.astrofitness.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.astrofitness.bean.Forum;
import com.astrofitness.dao.ForumDao;
@Path("/forum")
public class ForumRest {
//please merge
		
		public ForumRest(){}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/get/all")
		public List<Forum> getAllForum(){
			ForumDao dao = new ForumDao();
			return dao.getAllForum();
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/post/newForum")
		public String insertTrainer(Forum forum){
			System.out.println(forum);		
			ForumDao dao = new ForumDao();
			dao.insertForum(forum);
			return "Success";
		}
}
