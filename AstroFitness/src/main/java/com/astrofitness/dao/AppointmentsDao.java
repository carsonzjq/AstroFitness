package com.astrofitness.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.astrofitness.bean.Appointments;
import com.astrofitness.util.HibernateUtil;

public class AppointmentsDao {

	public Integer insertAppointment(Appointments appointment) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer cid = null;
		
		try{
			tx = session.beginTransaction();
			cid = (Integer)session.save(appointment);
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
	
	public List<Appointments> getAllForum(){
		List<Appointments> appointments = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();

			appointments = session.createQuery("FROM APPOINTMENTS").list();

			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return appointments;
	}
	
	public static void main(String[] args) {
		AppointmentsDao dao = new AppointmentsDao();
		dao.insertAppointment(new Appointments(123, 234, 5));	
	}

}