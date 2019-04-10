package com.one.service.imp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.one.bean.systemInformation.Log_List_Bean;
import com.one.bean.systemInformation.User_Management_Bean;
import com.one.dao.ILoginDao;
import com.one.service.ILoginService;

public class LoginServiceImp implements ILoginService{
	
	private SqlSession init() {
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream("config/mybatis_config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			return factory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User_Management_Bean getUserByUserNameAndPwd(String userName,String password) {
		// TODO Auto-generated method stub
		SqlSession session = this.init();
		Map<String,String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("password", password);
		ILoginDao login = session.getMapper(ILoginDao.class);
		User_Management_Bean umb = login.getUserByUserNameAndPwd(map);

		session.close();
		return umb;
	}

	@Override
	public int addLog(Log_List_Bean log) {
		// TODO Auto-generated method stub
		SqlSession session = this.init();
		ILoginDao login = session.getMapper(ILoginDao.class);	
		int num = login.addLog(log);
		session.commit();
		session.close();
		return num;
	}
	
	
}
