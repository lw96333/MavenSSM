package com.one.test.systemInformation;

import org.junit.Test;

import com.one.service.systemInformation.InterUserManagementBeanService;

public class TestUserService {

	
	@Test
	public void testgetAllUser_Management_Bean(){
		InterUserManagementBeanService in = InterUserManagementBeanService.getInstance();
	System.out.println(in.getAllUser_Management_Bean(5, 1,null).getPageData().size()+"---88888");
	}
	
	
	@Test
	public void testdeleteUser_Management_BeanById(){
		InterUserManagementBeanService in = InterUserManagementBeanService.getInstance();
		System.out.println(in.deleteUser_Management_BeanById(7));
	}
}
