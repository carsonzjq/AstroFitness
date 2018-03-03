package tester;

import com.astrofitness.bean.Trainer;
import com.astrofitness.dao.TrainerDao;

//Using this class to test hibernate
public class test {
	public static void main(String[] args) {
		TrainerDao tDao = new TrainerDao();
		Integer result = tDao.insertTrainer(new Trainer("newName", "newEmail","passwordHere"));
		System.out.println(result);
	}
}
