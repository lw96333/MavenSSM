package com.java.service;

import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;

/**
 * 查看历史租赁车位的服务层
 * @author 温岱
 *
 * 2019年3月26日
 */
public interface ViewHistoricalParkingRentalService{

	/**
	 * 得到历史出租车位页面所有需要的数据
	 * @param userId
	 * @param pageNum
	 * @return
	 */
	PageBean<ViewTheRentalPageBean> getAllNeedData(int userId,int pageNum);
}
