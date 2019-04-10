package com.one.test.systemInformation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;
import com.one.dao.dataManagement.InterDataManagement;
import com.one.dao.systemInformation.InterSystemInformation;

public class TestUser {
	private SqlSession session;
	@Before
	public void init() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config/mybatis_config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testaddUser_Management_Bean(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		User_Management_Bean u = new User_Management_Bean();
		User_Privileges_Bean p = new User_Privileges_Bean();
		p.setPrivilegesId(1);
		p.setPrivilegesName("资料2管理员");
		u.setPrivileges(p);
		u.setName("xin jia de ");
		u.setPassword("12345");
		u.setUserName("wwwwww");
		in.addUser_Management_Bean(u);
		session.commit();
	}
	@Test
	public void testdeleteUser_Management_BeanById(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		in.deleteUser_Management_BeanById(6);
		session.commit();
	}
	
	@Test
	public void testdupdateUser_Management_BeanById(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		Map<String,Object> map = new HashMap();
		map.put("npwd", "123456");
		map.put("privilegesId", 2);
		map.put("userId", 7);
		in.updateUser_Management_BeanById(map);
		session.commit();
	}
	@Test
	public void testgetUser_Management_BeanNumber(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		Map<String,Object> map = new HashMap();
		map.put("privilegesName", null);
		System.out.println(in.getUser_Management_BeanNumber(map));
		session.commit();
	}
	@Test
	public void testgetAllUser_Privileges_Bean(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		System.out.println(in.getAllUser_Privileges_Bean());
		session.commit();
	}
	
	@Test
	public void testshowUser_Management_BeanInfoById(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		System.out.println(in.showUser_Management_BeanInfoById(2));
		session.commit();
	}
	@Test
	public void testgetAllUser_Management_Bean(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		Map<String,Object> map = new HashMap();
		map.put("privilegesName", null);
		map.put("pageSize", 5);
		map.put("pageNum",1);
		//System.out.println(in.getAllUser_Management_Bean(map)+"/*/*/*");
		session.commit();
	}
	@Test
	public void testgetAllUser_Management_BeanByCondition(){
		InterSystemInformation in = session.getMapper(InterSystemInformation.class);
		System.out.println(in.getAllUser_Management_BeanByCondition(2));
		session.commit();
	}
	
}
