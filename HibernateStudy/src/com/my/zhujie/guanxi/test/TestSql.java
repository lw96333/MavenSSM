package com.my.zhujie.guanxi.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.my.util.HibernateUtil;
import com.my.zhujie.entity.GoodsEntity;

/**
 * 原生sql语句查询
 * @author 49160
 *
 */
public class TestSql {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		//查询数据库表字段
		
		//获取sqlQuery对象
		
		SQLQuery sqlQuery = session.createSQLQuery("select name,price from t_goods where name= ?");
		//设置字段类型
		sqlQuery.addScalar("name",StandardBasicTypes.STRING);
		//设置参数
		sqlQuery.setString(0, "礼物1");
		//执行查询操作
		List result = sqlQuery.list();
		
		System.out.println(result);
		//查询数据库表记录
		List<GoodsEntity> goodsEntities = 
				session.createSQLQuery("select * from t_goods where name= ?")
				.addEntity(GoodsEntity.class)
				.setString(0, "礼物1")
				.list();
		System.out.println(goodsEntities);
		
		
		
		HibernateUtil.closeSession(session);
	}

}
