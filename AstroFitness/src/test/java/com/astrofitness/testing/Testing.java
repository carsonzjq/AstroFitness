package com.astrofitness.testing;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.astrofitness.bean.Client;
import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.ClientDao;
import com.astrofitness.dao.GymDao;
import com.astrofitness.dao.TrainerDao;

public class Testing {
	
	  @Test(groups= {"gymDao"},enabled=false, priority=1)
	  public void insertGym() {
		  
		  Gym gym1 = new Gym("Planet Gym","100 Main st");
		  Gym gym2 = new Gym("LA AstroGym", "100 Broadway Ave");
		  Gym gym3 = new Gym("Astro Gym", "100 Gym St");
		  GymDao gDao = new GymDao();
		  AssertJUnit.assertTrue(gDao.insertGym(gym1) > 0);
		  AssertJUnit.assertTrue(gDao.insertGym(gym2) > 0);
		  AssertJUnit.assertTrue(gDao.insertGym(gym3) > 0);
		  
	  }
	
	  @Test(groups={"trainerDao"}, enabled = false,priority=2)
	  public void insertTrainer() {
		  TrainerDao tDao = new TrainerDao();
		  Integer t1 = tDao.insertTrainer(new Trainer("fname1", "lname1", "1 address", "email address1","password1",new Gym(50)));
		  Integer t2 = tDao.insertTrainer(new Trainer("fname2", "lname2", "2 address", "email address2","password2",new Gym(50)));
		  AssertJUnit.assertNotNull(t1 > 0);
		  AssertJUnit.assertNotNull(t2 > 0);

	  }
	
	  @Test(groups={"gymDao"}, enabled = false)
	  public void existsGetAllTrainersFromGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertNotNull(trainers);
	  }
	  
	  @Test(dependsOnMethods = {"existsGetAllTrainersFromGym"}, groups= {"gymDao"}, enabled = false)
	  public void foundTrainerInGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertTrue(trainers.size() > 0);
	  }
	  
	  
	  @Test(groups= {"clientDao"},enabled = false)
	  public void insertClient() {
		  ClientDao cDao = new ClientDao();
		  Client c1 = new Client();
		  c1.setEmail("yolo@yahoo.com");
		  c1.setFname("Andy");
		  c1.setLname("Beans");
		  c1.setPassword("yolo");
		  Integer result = cDao.insertClient(c1);
		  AssertJUnit.assertTrue(result > 0);
	  }

	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("BEFORE METHOD");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("AFTER METHOD");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("BEFORE CLASS");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("AFTER CLASS");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("BEFORE TEST");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("AFTER TEST");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("BEFORE SUITE");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("AFTER SUITE");
	  }

}
