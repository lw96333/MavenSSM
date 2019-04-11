package com.my.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.my.entity.StudentEntity;

/**
 * hibernate������
 * @author 49160
 *
 */
public class HIbernateTest {

	public static void main(String[] args) {
		/* ����
		//����hibernate�����ļ�
		Configuration configuration = new Configuration().configure();
		
		//��ȡSessionFactory(�������ģʽ)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//��ȡsession
		Session session = sessionFactory.openSession();
		
		//��ȡ����
		Transaction transaction = session.beginTransaction();
		
		//�����¼���־û�����
		StudentEntity studentEntity = new StudentEntity("����", 29);//˲̬����˲̬��
		
		//sava��������ֵ��persistû�з���ֵ
		session.save(studentEntity);//�־û����󣨳־û�״̬��session������
		
		//�־û�״̬
		studentEntity.setAge(12);
		
		//�ύ����
		transaction.commit();
		
		//�ͷ�Session
		session.close();
		
		//�ͷ�SessionFactory
		sessionFactory.close();
		
		//�йܶ����й�״̬��������session����������û�й�����
		studentEntity.setAge(32);
		*/
		
		
		/* ��ѯ
		//����hibernate�����ļ�
		Configuration configuration = new Configuration().configure();
		
		//��ȡSessionFactory(�������ģʽ)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//��ȡsession
		Session session = sessionFactory.openSession();
		
		//��ѯ��¼ get��load����1.û�в鵽����get����null��load���쳣  2.load���õ���ʱ���� 3.geiЧ�ʱ�load��
		StudentEntity studentEntity2 = (StudentEntity) session.load(StudentEntity.class,1);
		
		
		session.close();
		
		sessionFactory.close();
		
		//����load session�رպ������ʱ���ؾͱ���  org.hibernate.LazyInitializationException: could not initialize proxy - no Session
//		System.out.println(studentEntity2);
 * 
 */
		
		
		//�й�״̬ת��Ϊ�־û�״̬
		//����hibernate�����ļ�
		Configuration configuration = new Configuration().configure();
		
		//��ȡSessionFactory(�������ģʽ)
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//��ȡsession
		Session session = sessionFactory.openSession();
		
		
		
		//��ѯ��¼ get��load����1.û�в鵽����get����null��load���쳣  2.load���õ���ʱ���� 3.geiЧ�ʱ�load��
		StudentEntity studentEntity3 = (StudentEntity) session.load(StudentEntity.class,2);
		
		session.close();
		
		
		session = sessionFactory.openSession();
		
		//�й�״̬ת��Ϊ�־û�״̬
		session.update(studentEntity3);
		
		//��ȡ����
		Transaction transaction = session.beginTransaction();
		
		studentEntity3.setAge(11);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
	
	}
}
