package com.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.entity.Userbilling;

/**
 * 个人用户计费测试类
 * @author 温家强
 *
 * 2019年3月24日
 */
import com.java.mapper.UserbillingMapper;
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PersonBillingTest {
	
	@Autowired
	private UserbillingMapper userbillingMapper;
	
	Userbilling userbilling = new Userbilling();
	
	/**
	 * 交易总笔数
	 */
	@Test
	public void getDealSumTest() {
		int num = userbillingMapper.countDealSum(userbilling);
		System.out.println(num);
	}
	
	/**
	 * 交易收入总额
	 */
	@Test
	public void getIncomeSumTest() {
		double price = userbillingMapper.countIncomeSum(userbilling);
		System.out.println(price);
	}
	
	/**
	 * 交易支出总额
	 */
	@Test
	public void getExpendSumTest() {
		double price = userbillingMapper.countExpendSum(userbilling);
		System.out.println(price);
	}
	
}
