package com.my.zhujie.guanxi.test;

import org.hibernate.Session;

import com.my.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		HibernateUtil.closeSession(session);
	}
}
