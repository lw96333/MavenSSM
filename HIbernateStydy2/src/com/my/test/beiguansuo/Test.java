package com.my.test.beiguansuo;

import org.hibernate.LockMode;
import org.hibernate.Session;

import com.my.entity.beiguansuo.InventoryPessimistic;
import com.my.util.HibernateUtil;
/**
 * 悲观锁测试
 * @author 49160
 *
 */
public class Test {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		//采用悲观锁机制
		
		InventoryPessimistic invent = (InventoryPessimistic) session.load(InventoryPessimistic.class, 1,LockMode.UPGRADE);
		invent.setCount(Integer.valueOf(invent.getCount())-200+"");
		HibernateUtil.closeSession(session);
	}

}
