package tester;

import java.sql.Date;
import java.time.LocalDate;

import com.astrofitness.bean.Forum;
import com.astrofitness.dao.ForumDao;

//Using this class to test hibernate
public class test {
	public static void main(String[] args) {
	/*	GymDao gDao = new GymDao();
		Gym testGym = new Gym();
		testGym.setId(50);
		List<Trainer> trainers = gDao.getAllTrainersFromGym(testGym);
		String buffer = new String();
		buffer.substring(1);
		Gym gym1 = new Gym("Planet Gym");
		Gym gym2 = new Gym("LA AstroGym");
		
		GymDao gDao = new GymDao();
		Integer result = gDao.insertGym(gym1);
		Integer result2 = gDao.insertGym(gym2);
		
		TrainerDao tDao = new TrainerDao();
		Integer t1 = tDao.insertTrainer(new Trainer("newName", "newEmail","passwordHere",gym1));
		Integer t2 = tDao.insertTrainer(new Trainer("newName2", "newEmail2","passwordHere2",gym1));*/
		ForumDao fDao = new ForumDao();
		Date date1 = Date.valueOf(LocalDate.now());
		Date date2 = Date.valueOf(LocalDate.now().plusDays(1));	
		Date date3 = Date.valueOf(LocalDate.now().plusWeeks(1));		  
		
		Forum record1 = new Forum("comment 1");
		Forum record2 = new Forum("comment 2");
		Forum record3 = new Forum("comment 3");
		fDao.insertForum(record1);
		fDao.insertForum(record2);
		fDao.insertForum(record3);	
		
	}
}
