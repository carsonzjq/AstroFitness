package com.astrofitness.testng;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.TrainerDao;

public class TestTrainer {
	//insert Trainer
	  @Test(groups={"trainerDao"}, enabled = false,priority=2)
	  public void insertTrainer() {
		  TrainerDao tDao = new TrainerDao();
		  Integer t1 = tDao.insertTrainer(new Trainer("fname1", "lname1", "1 address", "email address1","password1",new Gym(50)));
		  Integer t2 = tDao.insertTrainer(new Trainer("fname2", "lname2", "2 address", "email address2","password2",new Gym(50)));
		  AssertJUnit.assertNotNull(t1 > 0);
		  AssertJUnit.assertNotNull(t2 > 0);

	  }
	  
}
