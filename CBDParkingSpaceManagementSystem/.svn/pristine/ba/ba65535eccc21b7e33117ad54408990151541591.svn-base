package com.java.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Deal;
import com.java.entity.Privatecars;
import com.java.entity.User;
import com.java.mapper.UserMapper;
import com.java.mapper.ViewHistoricalParkingRentalMapper;
import com.java.service.ViewHistoricalParkingRentalService;
import com.sun.org.apache.bcel.internal.generic.DADD;
/**
 * 查看历史租赁车位的服务层实现类
 * @author 温岱
 *
 * 2019年3月26日
 */
@Service
public class ViewHistoricalParkingRentalServiceImpl implements ViewHistoricalParkingRentalService{

	@Autowired
	private ViewHistoricalParkingRentalMapper viewHistoricalParkingRentalMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public PageBean<ViewTheRentalPageBean> getAllNeedData(int userId, int pageNum) {

		PageBean<ViewTheRentalPageBean> pageBean = new PageBean<ViewTheRentalPageBean>();
		
		List<ViewTheRentalPageBean> list = viewHistoricalParkingRentalMapper.queryViewHistoricalParkingRental(userId, (pageNum - 1) * 5);
		
		for (int index = 0; index < list.size(); index++) {
			String userNameString = userMapper.getUserNameById(list.get(index).getUserid());
			list.get(index).setRealname(userNameString);
		}
		
		pageBean.setPageData(list);
		pageBean.setTotalData(viewHistoricalParkingRentalMapper.getAll(userId).size());
		
		pageBean.setPageNum(pageNum);
		
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		
		return pageBean;
		
	}

}
