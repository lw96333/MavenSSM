package com.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.entity.Enterprisebilling;
import com.java.mapper.EnterprisebillingMapper;

/**
 * 企业计费测试类
 * @author 汪雨晴
 *
 * 2019年3月26日
 */
@SpringBootTest(classes = App.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EnterpriseBillingTest {

	@Autowired
	private EnterprisebillingMapper mapper;
	
	Enterprisebilling enterprisebilling  = new Enterprisebilling();
	/**
	 * 根据企业id计算总笔数
	 */
	@Test
	public void countNumByEnterpriseId(){
		
		int num = mapper.countNumById(enterprisebilling);
		System.out.println(num);
	}
	
	/**
	 * 根据企业id计算总收入
	 */
	@Test
	public void countIncomeByEnterpriseId(){
		double num = mapper.countNumByIncome(enterprisebilling);
		System.out.println(num);
	}
	
	/**
	 * 根据企业id计算总收入
	 */
	@Test
	public void countEpxend(){
		double num = mapper.countNumByExpend(enterprisebilling);
		System.out.println(num);
	}
}
