package com.my.zhujie.guanxi.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.LiteralType;

import com.my.entity.HomeEntity;
import com.my.entity.MemberEntity;
import com.my.util.HibernateUtil;
import com.my.zhijie.bean.GoodsInfoBean;
import com.my.zhujie.entity.GoodsEntity;

public class TestHQL {
	
	public void testFrom() {
		Session session = HibernateUtil.getSession();
		
		String hql = "from GoodsEntity";
		
		Query query = session.createQuery(hql);
		
		List<GoodsEntity> li = query.list();
		
		System.out.println(li.size());
		
		for(GoodsEntity goods : li) {
			System.out.println(goods);
		}
		
		HibernateUtil.closeSession(session);
	}
	
	public void testSelect() {
		Session session = HibernateUtil.getSession();
		
		//第一种查询方式，返回值为list集合，集合的元素为实体类对象
		List<GoodsEntity> li = session.createQuery("select good from GoodsEntity as good").list();
		
		System.out.println(li.size());
		
		for(GoodsEntity goods : li) {
			System.out.println(goods);
		}
		
		//第二种查询方式，返回值为list集合，集合元素为实体类属性
		List result = session.createQuery("select good.id,good.name from GoodsEntity as good").list();
		System.out.println(result.size());
		Iterator it = result.iterator();
		while(it.hasNext()) {
			Object[] objs = (Object[]) it.next();
			System.out.println(objs[0]);//id
			System.out.println(objs[1]);//age
		}
		
		//第三种查询方式，返回值为list集合，集合元素为自定义类型（推荐）
		List<GoodsInfoBean> li2 = session.createQuery("select new com.my.zhijie.bean.GoodsInfoBean(good.name,good.price) from GoodsEntity as good").list();
		System.out.println(li2.size());
		
		for(GoodsInfoBean goods : li2) {
			System.out.println(goods);
		}
		HibernateUtil.closeSession(session);
	}
	
	public void testWhere() {
		Session session = HibernateUtil.getSession();
		
		List<GoodsEntity> li = 
				session.createQuery("from GoodsEntity as goods where goods.price >= 100").list();
		System.out.println(li);
		
		//预处理占位符方式一
		List<GoodsEntity> li2 = 
				session.createQuery("from GoodsEntity as goods where goods.name = ?")
				.setString(0, "礼物1")
				.list();
		System.out.println(li2);
		
		//预处理占位符方式二
		List<GoodsEntity> li3 = 
				session.createQuery("from GoodsEntity as goods where goods.name = :liwuming")
				.setString("liwuming", "礼物1")
				.list();
		System.out.println(li3);
		
		HibernateUtil.closeSession(session);
	}
	
	public void testPage() {
		Session session = HibernateUtil.getSession();
		
		List<GoodsEntity> goods =
				session.createQuery("from GoodsEntity")
				.setFirstResult(1)
				.setMaxResults(2)
				.list();
		System.out.println(goods);
		
		HibernateUtil.closeSession(session);
	}
	
	public void testFunction() {
		Session session = HibernateUtil.getSession();
		
		List obj =
				session.createQuery("select count(goods) from GoodsEntity as goods")
				.list();
		System.out.println(obj.get(0));
		
		List obj2 =
				session.createQuery(" from GoodsEntity as goods where goods.price = (select max(good.price) from GoodsEntity as good)")
				.list();
		System.out.println(obj2.get(0));
		
		HibernateUtil.closeSession(session);
	}
	
	//关联连接测试
	public void manyTableTest() {
		Session session = HibernateUtil.getSession();
		//隐士关联连接(返回值为list集合，集合元素为查询对象)
		List<MemberEntity> li = 
				session.createQuery("from MemberEntity as mem where mem.home.address like '百%'")
				.list();
		System.out.println(li);
		
		System.out.println("------------------------------------------");
		
		//显示关联连接（返回值为list集合，集合元素为查询对象和关联对象组成的数组）
		List li2 = 
				session.createQuery("from MemberEntity as mem inner join mem.home as h where h.address like '百%'")
				.list();
		Iterator it = li2.iterator();
		while(it.hasNext()) {
			Object[] obj = (Object[]) it.next();
			System.out.println(obj[0]);
			System.out.println("====================");
			System.out.println(obj[1]);
		}
		
		System.out.println("------------------------------------------");
		
		List<HomeEntity> li3 = 
				session.createQuery("from HomeEntity as home where home.address like '百%'")
				.list();
		System.out.println(li3);
		
		System.out.println("------------------------------------------");
		
		List<MemberEntity> li4 = 
				session.createQuery("from MemberEntity as mem where mem.relation = '父亲'")
				.list();
		for(MemberEntity men : li4) {
			System.out.println(men.getHome().getAddress());
		}
		
		HibernateUtil.closeSession(session);
	}
	
	
	public static void main(String[] args) {
		//new TestHQL().testSelect();
//		new TestHQL().testWhere();
//		new TestHQL().testPage();
//		new TestHQL().testFunction();
		new TestHQL().manyTableTest();
	}

}
