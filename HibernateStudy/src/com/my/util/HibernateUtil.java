package com.my.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private static Transaction transaction;
	
	
	static {

		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public static void closeSession(Session session) {
		
		if(session != null) {
			
			transaction.commit();
			session.close();
		}
	}
}
