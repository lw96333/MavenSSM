package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.bean.ViewTheRentalPageBean;


/**
 * 查看历史车位租赁的mapper
 * @author 温岱
 *
 * 2019年3月25日
 */
public interface ViewHistoricalParkingRentalMapper {

	/**
	 * 查询车位编号，地址，开始时间，结束时间，电话，联系人姓名
	 * @param userId
	 * @param pageNum
	 * @return
	 */
		@Select(value="SELECT  u.userid,p.equitiesid,p.area,d.startime,d.endtime,p.privatecarsid,u.phone,u.realname  FROM deal as d LEFT JOIN privatecars as p on d.privatecarsid = p.privatecarsid LEFT JOIN `user` as u on u.userid = p.userid " + 
				"WHERE d.userid = ${userid} AND d.state = '已出租' ORDER BY d.dealid DESC LIMIT ${pageNum},5")
	List<ViewTheRentalPageBean> queryViewHistoricalParkingRental(@Param(value="userid")int userId, @Param("pageNum") int pageNum);
	
	/**
	 * 查询此人所有的车位
	 * @param userId
	 * @return
	 */
	@Select(value = "SELECT  u.userid,p.equitiesid,p.area,d.startime,d.endtime,p.privatecarsid,u.phone,u.realname  FROM deal as d LEFT JOIN privatecars as p on d.privatecarsid = p.privatecarsid LEFT JOIN `user` as u on u.userid = p.userid " + 
			"WHERE d.userid = ${userid} AND d.state = '已出租' ")
	List<ViewTheRentalPageBean> getAll(@Param(value="userid")int userId);
}
