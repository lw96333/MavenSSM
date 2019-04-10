package com.one.test;

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
import com.one.dao.ILoginDao;

public class LoginDaoTest {
	
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
	public void testGetUserByUserNameAndPwd() {
		ILoginDao login = session.getMapper(ILoginDao.class);
		System.out.println(login);
		Map<String,String>map = new HashMap<>();
		map.put("userName", "admin");
		map.put("password", "admin");
		User_Management_Bean user = login.getUserByUserNameAndPwd(map);
//		System.out.println(user);
		System.out.println(user.getName());
	}

}
