package com.my.zhujie.test;

import org.hibernate.Session;

import com.my.util.HibernateUtil;
import com.my.zhujie.entity.GoodsEntity;
/**
 * 单表注解测试
 * @author 49160
 *
 */
public class TestZhujie {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
//		GoodsEntity goodsEntity = new GoodsEntity("礼物", 100, "礼物");
//		session.save(goodsEntity);
		
		
		
		HibernateUtil.closeSession(session);
		
	}

}
