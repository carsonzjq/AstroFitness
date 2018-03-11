package com.astrofitness.testng;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.GymDao;

public class TestGym {
	
	  @Test(groups= {"gymDao"},enabled=false, priority=1)
	  public void insertGym() {
		  
		  Gym gym1 = new Gym("Planet Gym","100 Main st");
		  Gym gym2 = new Gym("LA AstroGym", "100 Broadway Ave");
		  Gym gym3 = new Gym("Astro Gym", "100 Gym St");
		  GymDao gDao = new GymDao();
		  AssertJUnit.assertTrue(gDao.insertGym(gym1) > 0);
//		  AssertJUnit.assertTrue(gDao.insertGym(gym2) > 0);
//		  AssertJUnit.assertTrue(gDao.insertGym(gym3) > 0);
		  
	  }
	  
	  @Test(dependsOnMethods = {"existsGetAllTrainersFromGym"}, groups= {"gymDao"}, enabled = false)
	  public void foundTrainerInGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertTrue(trainers.size() > 0);
	  }
	
	  @Test(groups={"gymDao"}, enabled = false)
	  public void existsGetAllTrainersFromGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertNotNull(trainers);
	  }
	  

}
