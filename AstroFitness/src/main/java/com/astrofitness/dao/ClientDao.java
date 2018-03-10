package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.astrofitness.bean.Client;
import com.astrofitness.util.HibernateUtil;

public class ClientDao {
	private Session session;
	private Transaction tx;
	public Integer insertClient(Client client) {
			session = HibernateUtil.getSession();
		tx = null;
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
	public Client authenticate(String email,String password) {
		session =null;
		tx=null;
		Client client=null;
		try {
			tx=session.beginTransaction();
			client =(Client)session.createCriteria(Client.class)
					.add(Restrictions.sqlRestriction("email="+email+"and password="
			          +password)).uniqueResult();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();}
		finally {
			session.close();
		}
		return client;
	}

}
