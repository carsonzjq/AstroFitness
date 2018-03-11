package com.astrofitness.testng;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.astrofitness.bean.Client;
import com.astrofitness.dao.ClientDao;

public class TestClient {
	  @Test(groups= {"clientDao"}, enabled=true)
	  public void login() {
		  ClientDao cDao = new ClientDao();
		  boolean result = cDao.logIn("yolo@yahoo.com", "yolo");
		  AssertJUnit.assertTrue(result);
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
}
