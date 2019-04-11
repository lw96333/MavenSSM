package com.my.zhujie.guanxi.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.my.entity.HomeEntity;
import com.my.util.HibernateUtil;
import com.my.zhujie.entity.GoodsEntity;

public class TestTiaoJianChaXun {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		//获取条件查询对象（Criteria）
		
		Criteria criteria = session.createCriteria(GoodsEntity.class);
		
		//添加查询条件
		criteria.add(Restrictions.eq("name", "礼物1"))
		.setFirstResult(0)
		.setMaxResults(1);
		//执行查询操作
		List<GoodsEntity> li = criteria.list();
		System.out.println(li);
		
		System.out.println("---------------------------------------------");

		//关联条件查询
		List<HomeEntity> homeEntities = 
				session.createCriteria(HomeEntity.class)
				.add(Restrictions.like("address", "百%"))
				.createCriteria("members")
				.add(Restrictions.eq("relation", "父亲"))
				.list();
		
		System.out.println(homeEntities.size());
		
		
		HibernateUtil.closeSession(session);
	}
	

}
