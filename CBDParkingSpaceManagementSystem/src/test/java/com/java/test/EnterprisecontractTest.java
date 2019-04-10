package com.java.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.bean.EnterprisecontractBean;
import com.java.entity.Enterprisecontract;
import com.java.mapper.EnterprisecontractMapper;

/**
 * 企业合约测试类
 * @author 肖中华
 *
 * 2019年3月27日
 */
@SpringBootTest(classes = App.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EnterprisecontractTest {
	@Autowired
	private EnterprisecontractMapper enterprisecontractMapper;
	
	/**
	 * 测试根据分页显示企业合约
	 * 
	 */
	@Test
	public void findAllContract() {
		Map<String, Integer> map = new HashMap<String, Integer>(20);
		map.put("newcurPage", 0);
		map.put("pageSize", 9);
		List<EnterprisecontractBean> list = enterprisecontractMapper.findAllContract(map);
		for (EnterprisecontractBean enterprisecontractBean : list) {
			System.out.println(enterprisecontractBean);
		}
	}
	/**
	 * 测试添加合约测试
	 */
	@Test
	public void addEnterprisecontract() {
		Enterprisecontract enterprisecontract = new Enterprisecontract();
		enterprisecontract.setEnterpriseid(88);
		enterprisecontract.setContractnumber("KF-201903271403345");
		enterprisecontract.setFromdate("2019-02-02");
		enterprisecontract.setDeadline("2019-3-27");
		enterprisecontract.setPrice("10000");
		int num = enterprisecontractMapper.addEnterprisecontract(enterprisecontract);
		System.out.println(num);
	}
	/**
	 *测试 得到企业合约的总条数
	 */
	@Test
	public void getSize() {
		EnterprisecontractBean eBean = enterprisecontractMapper.getsize();
		System.out.println(eBean.getEnterprisecontractid());
	}
	
}
