package com.my.service;
/**
 * 用户业务逻辑接口
 * @author 罗维
 *
 * 2019年3月11日
 */
public interface IUserService {

	/**
	 * 用户登录判断
	 * @param name 用户名
	 * @param password 密码
	 * @return true为登录成功
	 */
	boolean login(String name,String password);
	/**
	 * 注册
	 * @param name 用户名
	 * @param password 密码
	 * @return 是否注册成功
	 */
	boolean register(String name,String password);
}
