package com.astrofitness.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.util.HibernateUtil;

public class GymDao {
	
	public Integer insertGym(Gym gym) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer tid = null;
		
		try{
			tx = session.beginTransaction();
			tid = (Integer)session.save(gym);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}		
		return tid;
	}	
	
	public List<Trainer> getAllTrainersFromGym(Gym gym) {
		List<Trainer> trainers = new ArrayList<Trainer>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			trainers = session.createQuery("FROM Trainer WHERE TRAINER_HOME = :gymId")
					.setParameter("gymId", gym.getId())
					.list();

			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return trainers;
	}
	
}
