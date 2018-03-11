package com.astrofitness.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.astrofitness.bean.Client;
import com.astrofitness.bean.Gym;
import com.astrofitness.bean.Trainer;
import com.astrofitness.util.HibernateUtil;

public class TrainerDao {
	
	
	
	public Gym getHomeGym(Integer inte) {
		Gym gym = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			gym = (Gym) session.createCriteria(Gym.class)
					.add(Restrictions.idEq(inte));
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return gym;
	}
	
	public Trainer getTrainerByName(String trainer_name) {
		Trainer trainer = new Trainer();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			trainer = (Trainer) session.get(Trainer.class, trainer_name);
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return trainer;		
	}

	public Integer insertTrainer(Trainer trainer){

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer tid = null;
		
		try{
			tx = session.beginTransaction();
			tid = (Integer)session.save(trainer);
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
	
	public boolean logIn(String email, String password) {
		Trainer trainer = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			trainer = (Trainer) session.createCriteria(Trainer.class)
					.add(Restrictions.ilike("email", email))
					.add(Restrictions.ilike("password", password))
					.uniqueResult();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		if(trainer != null) {
			if(trainer.getEmail().equals(email) && trainer.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
}
