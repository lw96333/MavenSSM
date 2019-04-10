package com.one.dao.systemInformation;

import java.util.List;
import java.util.Map;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;

public interface InterSystemInformation {

	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int addUser_Management_Bean(User_Management_Bean user);
	
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public int deleteUser_Management_BeanById(int id);
	
	/**
	 * �鿴�û���Ϣ
	 * @param id
	 * @return
	 */
	public User_Management_Bean showUser_Management_BeanInfoById(int id);
	
	/**
	 *�޸��û���Ϣ 
	 * @param id
	 * @return
	 */
	public int updateUser_Management_BeanById(Map<String,Object> map);
	
	/**
	 * ��ѯ�����û�
	 * @param map
	 * @return
	 */
	public List<User_Management_Bean> getAllUser_Management_Bean(Map<String,Object> map);
	
	/**
	 * ��������ѯ�����û�
	 * @param condition
	 * @return
	 */
	public List<User_Management_Bean> getAllUser_Management_BeanByCondition(int fid);
	
	/**
	 * ��ѯ�����û�Ȩ��
	 * @return
	 */
	public List<User_Privileges_Bean> getAllUser_Privileges_Bean();
	
	/**
	 * ��ѯ�����û�������
	 * @return
	 */
	public int getUser_Management_BeanNumber(Map<String,Object> condition);
}
