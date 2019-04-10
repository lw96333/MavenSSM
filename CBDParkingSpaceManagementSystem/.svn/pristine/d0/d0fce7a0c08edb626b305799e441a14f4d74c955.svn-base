package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.java.bean.LessorInfoBean;
import com.java.bean.MyParkingSpaceInfoByDealBean;
import com.java.bean.MyParkingSpaceInfoByLeasecarsBean;
import com.java.entity.Deal;

/**
 * 租赁 Mapper 接口
 *
 * @author 刘佳秋
 * @since 2019-03-21
 */
public interface DealMapper extends BaseMapper<Deal> {
	/**
	 * 根据用户登陆ID查询属于登陆用户审核通过的发布出租的车位分页数据
	 * 
	 * @param userId  用户ID
	 * @param pageNum 当前页数
	 * @return 属于该用户已经发布的出租车位信息
	 */
	@Select(value = "SELECT d.privatecarsid," + "d.userid," + "d.startime," + "d.endtime," + "d.message," + "d.state,"
			+ "p.equitiesid,p.area" + " FROM deal as d LEFT JOIN " + "privatecars as p "
			+ "on p.privatecarsid = d.privatecarsid "
			+ "WHERE p.userid = ${userid} AND d.state = '已预定' ORDER BY d.dealid DESC LIMIT ${pageNum},5")
	List<MyParkingSpaceInfoByDealBean> getMyParkingSpaceInfo(@Param(value = "userid") int userId,
			@Param(value = "pageNum") int pageNum);

	/**
	 * 根据用户登陆ID查询属于登陆用户审核通过的发布出租的车位分页数据
	 * 
	 * @param userId
	 * @param pageNum
	 * @return
	 */
	@Select(value = "SELECT l.privatecarsid,l.starttime,l.endtime,l.message,l.state," + "p.equitiesid,p.area "
			+ "FROM leasecars as l LEFT JOIN privatecars as p " + "on l.privatecarsid = p.privatecarsid "
			+ "WHERE p.userid = ${userid} AND l.state = '等待出租'  ORDER BY l.id DESC LIMIT ${pageNum},5")
	List<MyParkingSpaceInfoByLeasecarsBean> getMyParkingSpaceInfoByLeasecars(@Param(value = "userid") int userId,
			@Param(value = "pageNum") int pageNum);

	/**
	 * 查询所有属于用户发布的出租车位
	 * @param userId
	 * @return
	 */
	@Select(value = "SELECT d.privatecarsid FROM deal as d LEFT JOIN privatecars as p on p.privatecarsid = d.privatecarsid WHERE p.userid = ${userId}  AND d.state = '已预定'")
	List<MyParkingSpaceInfoByDealBean> getAll(@Param(value = "userId") int userId);

	/**
	 * 根据用户ID查询用户发布出租车位信息
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	@Select(value = "SELECT l.privatecarsid,l.starttime,l.endtime,l.message,l.state," + "p.equitiesid,p.area "
			+ "FROM leasecars as l LEFT JOIN privatecars as p " + "on l.privatecarsid = p.privatecarsid"
			+ " WHERE p.userid = ${userId} AND l.state = '等待出租'")
	List<MyParkingSpaceInfoByLeasecarsBean> getAlLeasecarsBeans(@Param(value = "userId") int userId);

	/**
	 * 查看预定用户信息,通过车位ID
	 * 
	 * @param privatecarsid
	 * @return 预定人信息
	 */
	@Select(value = "SELECT d.privatecarsid,d.userid,d.price,d.startime,d.endtime,d.message,"
			+ "u.`name`,u.job,u.phone,u.complaintnumber,u.dealnumber " + "FROM  deal as d LEFT JOIN  `user` as u "
			+ "on d.userid = u.userid " + "WHERE d.privatecarsid = ${privatecarsid}")
	LessorInfoBean getLessorInfoByPrivatecarsid(@Param(value = "privatecarsid") int privatecarsid);


	/**
	 * 修改出租车位为已出租(租赁)
	 * @param privatecarsid
	 * @return
	 */
	@Update(value="UPDATE deal SET state = '已出租' WHERE privatecarsid = ${privatecarsid}")
	int updateRentalStatusByPrivatecarsid(@Param(value = "privatecarsid") int privatecarsid);
	/**
	 * 修改出租车位为已出租(私人车位)
	 * @param privatecarsid
	 * @return
	 */
	@Update(value="UPDATE privatecars SET state = '已出租' WHERE privatecarsid = ${privatecarsid}")
	int updateRentalStatusByPrivatecars(@Param(value = "privatecarsid") int privatecarsid);
	
	/**
	 * 修改出租车位为等待出租
	 * @param privatecarsid 车位ID
	 * @return
	 */
	@Update(value="UPDATE leasecars SET state = '等待出租' WHERE privatecarsid = ${privatecarsid}")
	int updateLessorByPrivatecarsid(@Param(value = "privatecarsid") int privatecarsid);
	
	/**
	 * 修改出租车位为已出租(出租车位)
	 * @param privatecarsid 车位ID
	 * @return
	 */
	@Update(value="UPDATE leasecars SET state = '已出租' WHERE privatecarsid = ${privatecarsid}")
	int updateLeasecarsByPrivatecarsid(@Param(value = "privatecarsid") int privatecarsid);

	/**
	 * 交易成功,增加用户交易次数+1
	 * @param userId
	 * @return
	 */
	@Update(value="UPDATE `user` SET dealnumber = dealnumber + 1 WHERE userid = ${userId}")
	int updateTransactionNumberByUserId(@Param(value="userId")int userId);

	/**
	 * 修改出租车位为对方已取消
	 * @param privatecarsid 车位ID
	 * @return
	 */
	@Delete(value="DELETE FROM deal WHERE privatecarsid = ${privatecarsid}")
	int updateCancelTransactionByPrivatecarsid(@Param(value = "privatecarsid") int privatecarsid);

}
