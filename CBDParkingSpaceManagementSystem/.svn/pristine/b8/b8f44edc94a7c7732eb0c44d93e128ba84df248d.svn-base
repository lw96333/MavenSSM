package com.java.service;

import com.baomidou.mybatisplus.service.IService;
import com.java.bean.LessorInfoBean;
import com.java.bean.MyParkingSpaceInfoByDealBean;
import com.java.bean.PageBean;
import com.java.entity.Deal;

/**
 * <p>
 * 租赁 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface DealService extends IService<Deal> {
	/**
	 * 查询登陆用户已发布出租车辆的分页信息
	 * @param userId 用户ID
	 * @param pageNum 当前页数
	 * @return 分页数据
	 */
	PageBean<MyParkingSpaceInfoByDealBean> getMyParkingSpaceInfo(int userId, int pageNum);

	/**
	 * 查询预定人信息,根据车位ID 
	 * @param privatecarsid 车位ID
	 * @return 预定人信息
	 */
	LessorInfoBean getLessorByPrivatecarsid(int privatecarsid);
	
	/**
	 * 确认出租车位
	 * @param userId 用户id
	 * @param duserId 租赁人用户id
	 * @param privatecarsid 车位id
	 * @return
	 */
	boolean confirmRentalByUserIdAndPrivatecarsid(int userId, int duserId, int privatecarsid);
	
	/**
	 * 取消出租
	 * @param userId 用户id
	 * @param privatecarsid 车位id
	 * @return
	 */
	boolean cancellationOfRentalByUserIdAndPrivatecarsid(int userId, int privatecarsid);
}
