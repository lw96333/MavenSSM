package com.my.test;

import org.hibernate.Session;

import com.my.entity.HomeEntity;
import com.my.entity.MemberEntity;
import com.my.util.HibernateUtil;

public class HibernateTestOneToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		HomeEntity homeEntity = new HomeEntity();
		homeEntity.setAddress("百草路100号");
		session.persist(homeEntity);
		
		MemberEntity memberEntity1 = new MemberEntity();
		memberEntity1.setRelation("父亲");
		memberEntity1.setHome(homeEntity);
		session.persist(memberEntity1);
		
		MemberEntity memberEntity2 = new MemberEntity();
		memberEntity2.setRelation("母亲");
		memberEntity2.setHome(homeEntity);
		session.persist(memberEntity2);
		
		HibernateUtil.closeSession(session);
	}
}
