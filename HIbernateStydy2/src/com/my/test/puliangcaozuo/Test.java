package com.my.test.puliangcaozuo;

import org.hibernate.Session;

import com.my.entity.leguansuo.InventoryOptimistic;
import com.my.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		int resulet = session.createQuery("Update InventoryOptimistic as i set i.count = 1000").executeUpdate();
		System.out.println(resulet);
		HibernateUtil.closeSession(session);
	}
}
