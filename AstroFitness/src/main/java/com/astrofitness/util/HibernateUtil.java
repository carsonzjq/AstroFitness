package com.astrofitness.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//If named differently, you will have to supply the custom name as a parameter for the
	//configure method.
//	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private static String props[] = System.getenv("AstroDB").split(";");
	

	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new Configuration()

			.setProperty("hibernate.connection.driver_class", props[0])
			.setProperty("hibernate.dialect", props[1])
			.setProperty("hibernate.connection.url", props[2])
			.setProperty("hibernate.connection.username", props[3])
			.setProperty("hibernate.connection.password", props[4])
			.setProperty("hibernate.connection.pool_size", "2")
			.configure().buildSessionFactory();
	
	public static Session getSession(){
		return sessionFactory.openSession();
		
	}
}
