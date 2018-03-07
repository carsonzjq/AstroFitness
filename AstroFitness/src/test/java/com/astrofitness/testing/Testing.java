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

import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.GymDao;

public class Testing {
	
	  @Test(groups={"gymDao"})
	  public void existsGetAllTrainersFromGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertNotNull(trainers);
	  }
	  
	  @Test(dependsOnMethods = {"existsGetAllTrainersFromGym"}, groups= {"gymDao"})
	  public void foundTrainerInGym() {
		  GymDao gDao = new GymDao();
		  Gym gym = new Gym();
		  gym.setId(50);
		  List<Trainer> trainers = gDao.getAllTrainersFromGym(gym);
		  AssertJUnit.assertTrue(trainers.size() > 0);//should move this to a second test
	  }
	  
	  @Test(groups={"gymDao"})
	  public void test2() {
		  GymDao gDao = new GymDao();
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
