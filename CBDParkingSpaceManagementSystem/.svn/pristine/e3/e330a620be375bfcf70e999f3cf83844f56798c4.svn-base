package com.java.service.impl;

import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Log;
import com.java.mapper.LogMapper;
import com.java.service.LogService;
import com.java.util.logType;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日志 服务实现类
 * @author 张冀川
 *
 * 2019年4月1日
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
	@Autowired
	private LogMapper logMapper;
	/**
	 * 得到日志分页
	 */
	@Override
	public PageBean<Log> getAllPageBean(int pageNum, String permission, String endTime, String stateTime) {
		// TODO Auto-generated method stub
		PageBean<Log> pageBean = new PageBean<Log>();
		Map<String, Object> map = new HashMap<String, Object>(10);
		map.put("pageNum", (pageNum - 1) * 5);
		String permissionTest= "0";
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
		pageBean.setPageData(logMapper.getAllParkingInfo(map));
		pageBean.setTotalData(logMapper.getAll(map));
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		return pageBean;
	}
	
}
