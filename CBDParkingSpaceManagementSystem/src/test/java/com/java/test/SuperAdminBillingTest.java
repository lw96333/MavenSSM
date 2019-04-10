package com.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.entity.Adminbilling;
import com.java.mapper.AdminbillingMapper;

/**
 * 超级管理员计费测试类
 * @author 温家强
 *
 * 2019年3月24日
 */
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SuperAdminBillingTest {
	
	@Autowired
	private AdminbillingMapper adminbillingMapper;
	
	Adminbilling adminbilling = new Adminbilling();
	
	/**
	 * 交易总笔数
	 */
	@Test
	public void getDealSumTest() {
		int num = adminbillingMapper.countDealSum(adminbilling);
		System.out.println(num);
	}
	
	/**
	 * 交易收入总额
	 */
	@Test
	public void getIncomeSumTest() {
		double price = adminbillingMapper.countIncomeSum(adminbilling);
		System.out.println(price);
	}
	
	/**
	 * 交易支出总额
	 */
	@Test
	public void getExpendSumTest() {
		double price = adminbillingMapper.countExpendSum(adminbilling);
		System.out.println(price);
	}
	
}
