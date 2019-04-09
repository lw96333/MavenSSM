package com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.IUserDao;
import com.my.entity.UserEntity;
/**
 * 用户业务逻辑实现
 * @author 罗维
 *
 * 2019年3月11日
 */
@Service
@Transactional//声明式事务
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findUser(name, password);
		
		if(userEntity == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean register(String name, String password) {
		// TODO Auto-generated method stub
		int row = userDao.insertUser(name, password);
		if(row == 0) {
			
			return false;			
		}
		return true;
	}
	
	

}
