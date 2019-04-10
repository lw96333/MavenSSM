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
import com.java.bean.CbdBean;
import com.java.entity.Enterprise;
import com.java.mapper.CbdMapper;

/**
 * 查询企业车位测试类
 * @author 温家强
 *
 * 2019年3月27日
 */
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CbdCarportTest {
	
	@Autowired
	private CbdMapper cbdMapper;
	
	/**
	 * 企业已租赁车位
	 */
	@Test
	public void getEnterpriseLeaseCarport(){
		
		Map<String, Object> map = new HashMap<String, Object>(5);
		map.put("newcurPage",0);
		map.put("pageSize",5);
		map.put("enterpriseId", 121);
		List<CbdBean> list = cbdMapper.getEnterpriseLeaseCarport(map);
		for(CbdBean lists : list) {
			System.out.println(lists);
		}
		
	}
	
	
}
