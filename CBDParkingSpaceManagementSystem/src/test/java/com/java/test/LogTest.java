package com.java.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.app.App;
import com.java.bean.PageBean;
import com.java.entity.Log;
import com.java.mapper.AdminMapper;
import com.java.mapper.AdminpowerMapper;
import com.java.mapper.LogMapper;
import com.java.service.AdminpowerService;


/**
 * 日志测试
 * @author 张冀川
 *
 * 2019年3月28日
 */
@SpringBootTest(classes = App.class, 
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LogTest {

	@Autowired
	private LogMapper logMapper;
	/**
	 * 得到所有日志分页测试
	 */
	@Test
	public void getAdminPowerTest() {
		PageBean<Log> pageBean = new PageBean<Log>();
		int  pageNum = 1;
		String permission = "前台";
		String stateTime="2019-03-28";
		String endTime="";
				
		Map<String, Object> map = new HashMap<String, Object>(10);
		String permissionTest= "0";
		map.put("pageNum", (pageNum - 1) * 5);
		if(permissionTest.equals(permission)) {
			map.put("permission", null);
		} else {
			map.put("permission", permission);
		}
		if("".equals(stateTime)) {
			map.put("stateTime", null);
		} else {
			map.put("stateTime", stateTime);
		}
		if("".equals(endTime)) {
			map.put("endTime", null);
		} else {
			map.put("endTime", endTime);
		}
		System.out.println(map.size()+"testchuanchaun");
		pageBean.setPageData(logMapper.getAllParkingInfo(map));
		pageBean.setTotalData(logMapper.getAll(map));
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		System.out.println(pageBean);
	}
}
