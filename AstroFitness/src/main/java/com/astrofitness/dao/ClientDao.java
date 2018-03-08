package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.astrofitness.bean.Client;
import com.astrofitness.util.HibernateUtil;

public class ClientDao {
	public Integer insertClient(Client client) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer tid = null;
		
		try{
			tx = session.beginTransaction();
			tid = (Integer)session.save(client);
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
