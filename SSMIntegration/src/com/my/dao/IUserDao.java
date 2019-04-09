package com.my.dao;

import com.my.entity.UserEntity;

/**
 * 用户Dao接口
 * @author 罗维
 *
 * 2019年3月11日
 */
public interface IUserDao {

	/**
	 * 通过账号密码查询用户
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户实体
	 */
	UserEntity findUser(String name,String password);
	
	int insertUser(String name,String password);
}
