package com.java.service;

import com.java.bean.HistoricalRecordBean;
import com.java.bean.PageBean;

/**
 * 查看历史出租车位的服务层
 * @author 温岱
 *
 * 2019年3月26日
 */
public interface ViewHistoricalParkingLeaseService {

	/**
	 * 得到历史出租车位页面所有需要的数据
	 * @param userId
	 * @param pageNum
	 * @return
	 */
	PageBean<HistoricalRecordBean> getAllNeedData(int userId,int pageNum);
}
