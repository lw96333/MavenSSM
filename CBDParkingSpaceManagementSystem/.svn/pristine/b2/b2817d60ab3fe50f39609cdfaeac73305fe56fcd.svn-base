package com.java.service;

import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Log;
import com.baomidou.mybatisplus.service.IService;

/**
 * 日志 服务实现类
 * @author 张冀川
 *
 * 2019年4月1日
 */
public interface LogService extends IService<Log> {
	/**
	 * 查询所有待出租车位
	 * @param pageNum 当前页数
	 * @param permission 查询条件
	 * @param endTime 日期查询：结束时间,没有就填null
	 * @param stateTime 日期查询：开始时间,没有就填null
	 * @return 待出租车位集合
	 */
	PageBean<Log> getAllPageBean(int pageNum, String permission,String endTime, String stateTime);
}
