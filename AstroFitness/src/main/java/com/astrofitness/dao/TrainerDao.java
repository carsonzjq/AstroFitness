package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.astrofitness.bean.Trainer;
import com.astrofitness.util.HibernateUtil;

public class TrainerDao {

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
	
}
