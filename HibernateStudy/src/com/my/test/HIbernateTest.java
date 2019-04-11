package com.my.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.my.entity.StudentEntity;

/**
 * hibernate测试类
 * @author 49160
 *
 */
public class HIbernateTest {

	public static void main(String[] args) {
		/* 插入
		//加载hibernate配置文件
		Configuration configuration = new Configuration().configure();
		
		//获取SessionFactory(工厂设计模式)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//获取session
		Session session = sessionFactory.openSession();
		
		//获取事务
		Transaction transaction = session.beginTransaction();
		
		//插入记录（持久化对象）
		StudentEntity studentEntity = new StudentEntity("张三", 29);//瞬态对象（瞬态）
		
		//sava返回主键值，persist没有返回值
		session.save(studentEntity);//持久化对象（持久化状态和session关联）
		
		//持久化状态
		studentEntity.setAge(12);
		
		//提交事务
		transaction.commit();
		
		//释放Session
		session.close();
		
		//释放SessionFactory
		sessionFactory.close();
		
		//托管对象（托管状态，曾经和session关联，现在没有关联）
		studentEntity.setAge(32);
		*/
		
		
		/* 查询
		//加载hibernate配置文件
		Configuration configuration = new Configuration().configure();
		
		//获取SessionFactory(工厂设计模式)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//获取session
		Session session = sessionFactory.openSession();
		
		//查询记录 get和load区别，1.没有查到数据get返回null，load抛异常  2.load采用的延时加载 3.gei效率比load高
		StudentEntity studentEntity2 = (StudentEntity) session.load(StudentEntity.class,1);
		
		
		session.close();
		
		sessionFactory.close();
		
		//采用load session关闭后采用延时加载就报错  org.hibernate.LazyInitializationException: could not initialize proxy - no Session
//		System.out.println(studentEntity2);
 * 
 */
		
		
		//托管状态转换为持久化状态
		//加载hibernate配置文件
		Configuration configuration = new Configuration().configure();
		
		//获取SessionFactory(工厂设计模式)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//获取session
		Session session = sessionFactory.openSession();
		
		
		
		//查询记录 get和load区别，1.没有查到数据get返回null，load抛异常  2.load采用的延时加载 3.gei效率比load高
		StudentEntity studentEntity3 = (StudentEntity) session.load(StudentEntity.class,2);
		
		session.close();
		
		
		session = sessionFactory.openSession();
		
		//托管状态转换为持久化状态
		session.update(studentEntity3);
		
		//获取事务
		Transaction transaction = session.beginTransaction();
		
		studentEntity3.setAge(11);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
	
	}
}
