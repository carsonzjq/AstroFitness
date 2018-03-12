package com.astrofitness.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.astrofitness.bean.Manager;
import com.astrofitness.util.HibernateUtil;

public class ManagerDao {

	public Manager authenticate(String email, String password) {
		Session session = HibernateUtil.getSession();

		Transaction tx = null;
		Manager manager = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Manager where email='" + email
					+ "' and password ='" + password + "'";
//			System.out.println(hql);
			manager = (Manager) session.createQuery(hql).uniqueResult();
			if (manager == null)
				return null;
			manager.setGym(null);
			manager.setPassword(null);
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return manager;
	}

	public Manager getManagerByEmail(String email) {
		Session session = HibernateUtil.getSession();

		Transaction tx = null;
		Manager manager = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Manager where email='" + email + "'";
			manager = (Manager) session.createQuery(hql).uniqueResult();
			if (manager == null)
				return null;
			manager.setGym(null);
			manager.setPassword(null);
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return manager;
	}
}
