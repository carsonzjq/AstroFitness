package tester;

import java.util.List;

import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.GymDao;
import com.astrofitness.dao.TrainerDao;

//Using this class to test hibernate
public class test {
	public static void main(String[] args) {
		GymDao gDao = new GymDao();
		Gym testGym = new Gym();
		testGym.setId(50);
		List<Trainer> trainers = gDao.getAllTrainersFromGym(testGym);
		String buffer = new String();
		buffer.substring(1);
		/*		Gym gym1 = new Gym("Planet Gym");
		Gym gym2 = new Gym("LA AstroGym");
		
		GymDao gDao = new GymDao();
		Integer result = gDao.insertGym(gym1);
		Integer result2 = gDao.insertGym(gym2);
		
		TrainerDao tDao = new TrainerDao();
		Integer t1 = tDao.insertTrainer(new Trainer("newName", "newEmail","passwordHere",gym1));
		Integer t2 = tDao.insertTrainer(new Trainer("newName2", "newEmail2","passwordHere2",gym1));
*/		
	}
}
