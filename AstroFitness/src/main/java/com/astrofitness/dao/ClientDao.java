package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.astrofitness.bean.Client;
import com.astrofitness.util.HibernateUtil;

public class ClientDao {

	public Integer insertClient(Client client) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer cid = null;

		try {
			tx = session.beginTransaction();
			cid = (Integer) session.save(client);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return cid;

	}
	
	//authentication that returns a boolean
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
	
	//same as login but returns a Client object
	public Client authenticate(String email, String password) {
		Session session = HibernateUtil.getSession();

		Transaction tx = null;
		Client client = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Client where email='" + email
					+ "' and password ='" + password + "'";
			client = (Client) session.createQuery(hql).uniqueResult();
			if (client == null)
				return null;
			client.setClient_gym(null);
			client.setPassword(null);
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return client;
	}

	public Client getClientByEmail(String email) {
		Session session = HibernateUtil.getSession();

		Transaction tx = null;
		Client client = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Client where email='" + email + "'";
			client = (Client) session.createQuery(hql).uniqueResult();
			if (client == null)
				return null;
			client.setClient_gym(null);
//			client.getClient_gym().setClients(null);
			client.setPassword(null);
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return client;
	}
}
