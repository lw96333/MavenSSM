package com.one.service.systemInformation;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;
import com.one.service.systemInformation.Impl.UserManagementBeanServiceImpl;

public interface InterUserManagementBeanService {
/**
 * 返回接口实现类
 * @return
 */
	public static InterUserManagementBeanService getInstance(){
		return new UserManagementBeanServiceImpl();
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public int addUser_Management_Bean(User_Management_Bean user);
	
	/**
	 * 根据Id删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser_Management_BeanById(int id);

	/**
	 * 查看用户
	 * @param id
	 * @return
	 */
	public User_Management_Bean showUser_Management_BeanInfoById(int id);
	
	/**
	 * 修改用户
	 * @param id
	 * @return
	 */
	public int updateUser_Management_Bean(Map<String,Object> map);
	
	/**
	 * 查询分页对象
	 * @param map
	 * @return
	 */
	public PageBean<List<User_Management_Bean>> getAllUser_Management_Bean(int pageSize,int pageNum,String privilegesName );
	
	/**
	 * 获取所有用户权限
	 * @return
	 */
	public List<User_Privileges_Bean> getAllgetAllUser_Privileges_Bean();
	/**
	 * 按条件查询查询用户
	 * @param pageSize
	 * @param pageNum
	 * @param fid
	 * @return
	 */
	public PageBean<List<User_Management_Bean>> getAllUser_Management_BeanByCondition(int pageSize,int pageNum,int fid);
}
