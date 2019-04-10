package com.one.dao.systemInformation;

import java.util.List;
import java.util.Map;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;

public interface InterSystemInformation {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser_Management_Bean(User_Management_Bean user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser_Management_BeanById(int id);
	
	/**
	 * 查看用户信息
	 * @param id
	 * @return
	 */
	public User_Management_Bean showUser_Management_BeanInfoById(int id);
	
	/**
	 *修改用户信息 
	 * @param id
	 * @return
	 */
	public int updateUser_Management_BeanById(Map<String,Object> map);
	
	/**
	 * 查询所有用户
	 * @param map
	 * @return
	 */
	public List<User_Management_Bean> getAllUser_Management_Bean(Map<String,Object> map);
	
	/**
	 * 按条件查询所有用户
	 * @param condition
	 * @return
	 */
	public List<User_Management_Bean> getAllUser_Management_BeanByCondition(int fid);
	
	/**
	 * 查询所有用户权限
	 * @return
	 */
	public List<User_Privileges_Bean> getAllUser_Privileges_Bean();
	
	/**
	 * 查询所有用户的条数
	 * @return
	 */
	public int getUser_Management_BeanNumber(Map<String,Object> condition);
}
