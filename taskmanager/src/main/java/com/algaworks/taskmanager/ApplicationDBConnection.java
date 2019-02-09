package com.algaworks.taskmanager;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * This class was created to instantiate hibernate SessionFactory
 * class. Such instance is used to save java objects in the relational
 * database.
 * */

public class ApplicationDBConnection {

	private static final SessionFactory sessionFactory;
	
	static {
		Configuration conf = new Configuration();
		conf.configure();
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
