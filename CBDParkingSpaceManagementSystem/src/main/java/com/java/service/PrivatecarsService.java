package com.java.service;

import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Privatecars;


import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 私人车位 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Component
public interface PrivatecarsService extends IService<Privatecars> {

	/**
	 * 查询所有待出租车位
	 * @param pageNum 当前页数
	 * @param endTime 日期查询：结束时间,没有就填null
	 * @param stateTime 日期查询：开始时间,没有就填null
	 * @return 待出租车位集合
	 */
	PageBean<ParkingAreaHomePageBean> getAllPageBean(int pageNum, String endTime, String stateTime);
	
	/**
	 * 根据ID查询车位信息
	 * @param id 车位ID
	 * @return 车位信息
	 */
	ParkingAreaHomePageBean getParkingInfoById(int id);
}
