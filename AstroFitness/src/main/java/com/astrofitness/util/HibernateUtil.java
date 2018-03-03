package com.astrofitness.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//SessionFactory is configured as a singleton.
	//We call the configure method of the Configuration component which
	//by default will use the "configure.cfg.xml" file to configure our factory.
	//If named differently, you will have to supply the custom name as a parameter for the
	//configure method.
//	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private static Configuration cf = new Configuration();
	
	public static Session getSession(){
		String props[] = System.getenv("AstroDB").split(";");
		
		cf.setProperty("hibernate.dialect", props[0]);
		cf.setProperty("hibernate.connection.url", props[1]);
		cf.setProperty("hibernate.connection.username", props[2]);
		cf.setProperty("hibernate.connection.password", props[3]);
		cf.setProperty("hibernate.connection.pool_size", "2");
		
		
		return cf.configure().buildSessionFactory().openSession();
		
	}
}
