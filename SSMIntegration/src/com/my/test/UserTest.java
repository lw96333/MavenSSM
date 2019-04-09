package com.my.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.IUserDao;
import com.my.entity.UserEntity;

import junit.framework.Assert;


/**
 * 用户测试用例
 * @author 罗维
 *
 * 2019年3月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:webContent/WEB-INF/applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class UserTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private IUserDao userDao;
	
	@Test
	public void findUserTest() {
		UserEntity userEntity = userDao.findUser("my", "12345");
		
		//断言
		assertNotNull(userEntity);
	}
	
	@Test
	public void insertUserTest() {
		int row = userDao.insertUser("张三", "123123");
		
		Assert.assertEquals(1, row);
	}
	
}
