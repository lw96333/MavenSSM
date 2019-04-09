package com.my.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.controller.UserController;
import com.my.entity.UserEntity;
import com.my.mapper.UserMapper;

/**
 * 用户Dao实现类
 * @author 罗维
 *
 * 2019年3月11日
 */
@Repository
public class UserDaoImpl implements IUserDao{
	
	/**
	 * 获取日志记录器
	 */
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserEntity findUser(String name, String password) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userMapper.getUserByNameAndPassword(name, password);
		logger.log(Priority.DEBUG, userEntity);
		return userEntity;
	}

	@Override
	public int insertUser(String name, String password) {
		// TODO Auto-generated method stub
		
		return userMapper.insertUser(name, password);
	}
	
	

}
