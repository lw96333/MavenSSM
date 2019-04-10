package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.HistoricalRecordBean;
import com.java.bean.MyParkingSpaceInfoByLeasecarsBean;
import com.java.bean.PageBean;
import com.java.entity.User;
import com.java.mapper.UserMapper;
import com.java.mapper.ViewHistoricalParkingLeaseMapper;
import com.java.service.ViewHistoricalParkingLeaseService;

/**
 * 查看历史出租车位的服务层实现类
 * @author 温岱
 *
 * 2019年3月26日
 */
@Service
public class ViewHistoricalParkingLeaseServiceImpl implements ViewHistoricalParkingLeaseService{

	@Autowired
	private ViewHistoricalParkingLeaseMapper viewHistoricalParkingLeaseMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public PageBean<HistoricalRecordBean> getAllNeedData(int userId, int pageNum) {
		
		PageBean<HistoricalRecordBean> pageBean = new PageBean<HistoricalRecordBean>();
		
		List<HistoricalRecordBean> list = viewHistoricalParkingLeaseMapper.queryViewHistoricalParkingLease(userId, (pageNum - 1) * 5);
		
		for (int index = 0; index < list.size(); index++) {
			String userNameString = userMapper.getUserNameById(list.get(index).getUserid());
			list.get(index).setRealname(userNameString);
		}
		pageBean.setPageData(list);
		
		pageBean.setTotalData(viewHistoricalParkingLeaseMapper.getAll(userId).size());
		
		pageBean.setPageNum(pageNum);
		
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		
		return pageBean;
	}

}
