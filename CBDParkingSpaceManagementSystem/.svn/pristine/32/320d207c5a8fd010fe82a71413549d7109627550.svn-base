package com.java.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.mapper.AdminMapper;
import com.java.mapper.AdminpowerMapper;
import com.java.service.AdminpowerService;


/**
 * 用户测试类
 * @author 罗维
 *
 * 2019年3月23日
 */
@SpringBootTest(classes = App.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AdminTest {

	@Autowired
	private AdminpowerMapper adminMapper;
	
	@Test
	public void getAdminPowerTest() {
		Set<String> strs = adminMapper.getAdminPower("99");
		for(String str : strs) {
			System.out.println(str);
		}
	}
}
