package com.astrofitness.testng;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.astrofitness.bean.Forum;
import com.astrofitness.dao.ForumDao;

public class TestForum {
	  @Test(groups= {"forumDao"}, enabled=false)
	  public void insertForumRecord() {
		  ForumDao fDao = new ForumDao();
//		  Timestamp t1 = Timestamp.valueOf(LocalDateTime.now());
//		  Timestamp t2 = Timestamp.valueOf(LocalDateTime.now().plusDays(1));
//		  Timestamp t3 = Timestamp.valueOf(LocalDateTime.now().plusDays(2));
		  Date date1 = Date.valueOf(LocalDate.now());
		  Date date2 = Date.valueOf(LocalDate.now().plusDays(1));	
		  Date date3 = Date.valueOf(LocalDate.now().plusWeeks(1));		  
		  Timestamp t1 = Timestamp.valueOf(LocalDateTime.now());
		  
		  Forum record1 = new Forum("comment 1",t1);
		  Integer result = fDao.insertForum(record1);
		  AssertJUnit.assertTrue(result > 0);
	  }
	  
	  @Test(groups= {"forumDao"}, enabled=true)
	  public void getAllForum() {
		  ForumDao fDao = new ForumDao();
		  List<Forum> records = fDao.getAllForum();
		  AssertJUnit.assertTrue(records.size() > 0);
	  }	  
	  
}
