package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.astrofitness.bean.Client;
import com.astrofitness.bean.Trainer;
import com.astrofitness.util.HibernateUtil;

public class ClientDao {

	public Integer insertClient(Client client) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer cid = null;
		
		try{
			tx = session.beginTransaction();
			cid = (Integer)session.save(client);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return cid;
		
	}
	
	public boolean logIn(String email, String password) {
		Client client = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			client = (Client) session.createCriteria(Client.class)
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
		
		if(client != null) {
			if(client.getEmail().equals(email) && client.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
