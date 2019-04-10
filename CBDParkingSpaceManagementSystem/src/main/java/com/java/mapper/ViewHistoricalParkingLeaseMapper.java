package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.bean.HistoricalRecordBean;

/**
 * 查看历史车位出租的mapper
 * @author 温岱
 *
 * 2019年3月26日
 */
public interface ViewHistoricalParkingLeaseMapper {

	/**
	 *  查询车位编号，地址，开始时间，结束时间，电话，联系人姓名，租赁人ID
	 * @param userId
	 * @param pageNum
	 * @return
	 */
	@Select(value="SELECT d.userid,p.equitiesid,p.area,d.startime,d.endtime,p.privatecarsid,u.phone,u.realname FROM `user` as u LEFT JOIN privatecars as p on u.userid = p.userid LEFT JOIN deal as d on p.privatecarsid = d.privatecarsid "
			+ "WHERE u.userid=${userid} AND d.state='已出租' ORDER BY d.dealid DESC LIMIT ${pageNum},5 ")
	List<HistoricalRecordBean> queryViewHistoricalParkingLease(@Param(value="userid")int userId,@Param(value="pageNum")int pageNum);

	/**
	 * 得到所有的信息不排序
	 * @param uesrId
	 * @return
	 */
	@Select(value="SELECT d.userid FROM `user` as u LEFT JOIN privatecars as p on u.userid = p.userid LEFT JOIN deal as d on p.privatecarsid = d.privatecarsid "
			+ " WHERE u.userid = 1 AND d.state = '已出租'")
	List<HistoricalRecordBean> getAll(@Param(value="userid")int uesrId);
}
