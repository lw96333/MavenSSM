package com.my.test.leguansuo;

import org.hibernate.LockMode;
import org.hibernate.Session;


import com.my.entity.leguansuo.InventoryOptimistic;
import com.my.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		InventoryOptimistic invent = (InventoryOptimistic) session.get(InventoryOptimistic.class, 1);
		
		invent.setCount(invent.getCount()-200);
		
		
		HibernateUtil.closeSession(session);
	}

}
