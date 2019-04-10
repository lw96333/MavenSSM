package com.java.mapper;

import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Log;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 日志 Mapper 接口
 * @author 张冀川
 *
 * 2019年4月1日
 */
public interface LogMapper extends BaseMapper<Log> {
	/**
	 * 查询所有待出租车位信息
	 * @param map 条件查询条件
	 * @return 所有车位集合
	 */
	@Select(value = "<script> "+
			"SELECT count(logid) FROM log  "
			+ "<where>  "
			+ "<if test=\"map.permission != null \">" 
			+ " and rank like '%${map.permission}%' " 
			+ "</if>"
			+ "<if test=\"map.stateTime != null \">" 
			+ " and operatetime &gt;= #{map.stateTime} " 
			+ "</if>"
			+ "<if test=\"map.endTime != null \">" 
			+ " and operatetime &lt;= #{map.endTime} " 
			+ "</if></where>"
			+ " </script>")
	int getAll(@Param(value="map")Map<String, Object> map);
	/**
	 * 查询所有待出租车位信息
	 * @param map 条件查询条件
	 * @return 所有车位集合
	 */
	@Select(value = "<script> "+
			"SELECT * FROM log  "
			+ "<where>  "
			+ "<if test=\"map.permission != null \">" 
			+ " and rank like '%${map.permission}%' " 
			+ "</if>"
			+ "<if test=\"map.stateTime != null \">" 
			+ " and operatetime &gt;= #{map.stateTime} " 
			+ "</if>"
			+ "<if test=\"map.endTime != null \">" 
			+ " and operatetime &lt;= #{map.endTime} " 
			+ "</if></where>"
			+ " LIMIT ${map.pageNum},5"
			+ " </script>")
	List<Log> getAllParkingInfo(@Param(value="map")Map<String, Object> map);
}