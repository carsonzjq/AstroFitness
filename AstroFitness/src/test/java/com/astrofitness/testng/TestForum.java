package com.astrofitness.testng;

import static com.astrofitness.service.FormatForumDateTime.getDayAndTime;

import java.sql.Timestamp;
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
		  String[] dateTime = getDayAndTime(LocalDateTime.now());
		  
		  Forum record1 = new Forum("Interesting comment",dateTime[0],dateTime[1]);
		  Integer result = fDao.insertForum(record1);
		  AssertJUnit.assertTrue(result > 0);
	  }
	  
	  @Test(groups= {"forumDao"}, enabled=true)
	  public void getAllForum() {
		  ForumDao fDao = new ForumDao();
		  List<Forum> records = fDao.getAllForum();
		  AssertJUnit.assertTrue(records.size() > 0);
		  for(Forum record : records) {
			  System.out.println(record);
		  }
	  }	  
	  
}
