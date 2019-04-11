package com.my.test;
/**
 * 管理员测试类
 * @author 罗维
 *
 * 2019年3月12日
 */

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.dao.IAdminDao;
import com.my.dao.IViewDao;
import com.my.entity.VoteEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:webContent/WEB-INF/applicationContext.xml" })
public class AdminTest {

	@Autowired
	private IAdminDao adminDao;
	
	@Autowired
	private IViewDao viewDao;
	
	@Test
	public void findVoteById() {
		List<VoteEntity> li = adminDao.findVoteById(4);
		assertNotNull(li);
	}
	@Test
	public void findAllVoteById() {
		List<VoteEntity> li = adminDao.findAllVoteById(4);
		assertNotNull(li);
	}
	@Test
	public void updateVoteContext() {
		List<Integer> li = new ArrayList<Integer>();
		li.add(38);
		li.add(37);
		viewDao.updateVoteContext(li);
		
	}
}
