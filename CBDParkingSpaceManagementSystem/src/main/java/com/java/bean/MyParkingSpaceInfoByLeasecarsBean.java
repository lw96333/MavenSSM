package com.java.bean;

import lombok.Data;

/**
 * 用户出租车位,等待预约信息
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Data
public class MyParkingSpaceInfoByLeasecarsBean {
	
	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 预定车位人ID
	 */
	private int userid;
	/**
	 * 车位出租开始时间
	 */
	private String starttime;
	/**
	 * 车位出租结束时间
	 */
	private String endtime;
	/**
	 * 预定人留言
	 */
	private String message;
	/**
	 * 车位出租状态
	 */
	private String state;
	/**
	 * 车位产权编号
	 */
	private String equitiesid;
	/**
	 * 车位所在小区
	 */
	private String area;
	
	/**
	 * 车位出租用户的真实姓名
	 */
	private String realname;
	
	/**
	 * 车位出租用户的电话号码
	 */
	private String phone;
}
