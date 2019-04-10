package com.java.mapper;

import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Privatecars;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 私人车位 Mapper 接口
 *
 * @author 刘佳秋
 * @since 2019-03-21
 */
public interface PrivatecarsMapper extends BaseMapper<Privatecars> {

	/**
	 * 查询所有待出租车位信息
	 * @param map 条件查询条件
	 * @return 所有车位集合
	 */
	@Select(value = "<script> "+
			"SELECT p.privatecarsid FROM leasecars as l LEFT JOIN privatecars as p on l.privatecarsid = p.privatecarsid LEFT JOIN `user` as u on p.userid = u.userid "
			+ "WHERE l.state = '等待出租'"
			+ "<if test=\"map.stateTime != null \">" 
			+ " and l.issuetime &gt;= #{map.stateTime} " 
			+ "</if>"
			+ "<if test=\"map.endTime != null \">" 
			+ " and l.issuetime &lt;= #{map.endTime} " 
			+ "</if>"
			+ " </script>")
	List<ParkingAreaHomePageBean> getAll(@Param(value="map")Map<String, Object> map);

	/**
	 * 查询所有待出租车位信息(条件分页)
	 * @param map 条件查询条件
	 * @return 所有车位集合
	 */
	@Select(value ="<script> "+
			"SELECT"
			+ " p.privatecarsid,p.area,p.areaid,l.issuetime,u.name,u.job,u.phone,u.complaintnumber,u.dealnumber,p.propertyright FROM leasecars as l LEFT JOIN privatecars as p on l.privatecarsid = p.privatecarsid LEFT JOIN `user` as u on p.userid = u.userid WHERE l.state = '等待出租'  "
			+ "<if test=\"map.stateTime != null \">" 
			+ " and l.issuetime &gt;= #{map.stateTime} " 
			+ "</if>"
			+ "<if test=\"map.endTime != null \">" 
			+ " and l.issuetime &lt;= #{map.endTime} " 
			+ "</if>"
			+ " LIMIT ${map.pageNum},4"
			+ " </script>")
	List<ParkingAreaHomePageBean> getAllParkingInfo(@Param(value="map")Map<String, Object> map);

	/**
	 * 根据ID查询车位信息
	 * 
	 * @param id 车位ID
	 * @return 车位信息
	 */
	@Select(value = "SELECT p.privatecarsid,p.area,p.areaid,l.issuetime,u.name,u.job,u.phone,u.complaintnumber,u.dealnumber,p.propertyright,l.endtime,l.starttime,l.price,u.userid FROM leasecars as l LEFT JOIN privatecars as p on l.privatecarsid = p.privatecarsid LEFT JOIN `user` as u on p.userid = u.userid WHERE p.privatecarsid = ${id}")
	ParkingAreaHomePageBean getParkingById(@Param(value = "id") int id);

}