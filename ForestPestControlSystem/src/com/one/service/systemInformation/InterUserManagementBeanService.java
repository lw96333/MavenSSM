package com.one.service.systemInformation;

import java.util.List;
import java.util.Map;

import com.one.bean.PageBean;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;
import com.one.service.systemInformation.Impl.UserManagementBeanServiceImpl;

public interface InterUserManagementBeanService {
/**
 * ���ؽӿ�ʵ����
 * @return
 */
	public static InterUserManagementBeanService getInstance(){
		return new UserManagementBeanServiceImpl();
	}
	
	/**
	 * ����û�
	 * @param user
	 */
	public int addUser_Management_Bean(User_Management_Bean user);
	
	/**
	 * ����Idɾ���û�
	 * @param id
	 * @return
	 */
	public int deleteUser_Management_BeanById(int id);

	/**
	 * �鿴�û�
	 * @param id
	 * @return
	 */
	public User_Management_Bean showUser_Management_BeanInfoById(int id);
	
	/**
	 * �޸��û�
	 * @param id
	 * @return
	 */
	public int updateUser_Management_Bean(Map<String,Object> map);
	
	/**
	 * ��ѯ��ҳ����
	 * @param map
	 * @return
	 */
	public PageBean<List<User_Management_Bean>> getAllUser_Management_Bean(int pageSize,int pageNum,String privilegesName );
	
	/**
	 * ��ȡ�����û�Ȩ��
	 * @return
	 */
	public List<User_Privileges_Bean> getAllgetAllUser_Privileges_Bean();
	/**
	 * ��������ѯ��ѯ�û�
	 * @param pageSize
	 * @param pageNum
	 * @param fid
	 * @return
	 */
	public PageBean<List<User_Management_Bean>> getAllUser_Management_BeanByCondition(int pageSize,int pageNum,int fid);
}
