package com.java.bean;

import lombok.Data;

/**
 * 显示所有待出租车位信息
 * @author 刘佳秋
 *
 * 2019年3月26日
 */
@Data
public class ParkingAreaHomePageBean {

	/**
	 * 车位用户ID
	 */
	private int userid;
	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 车位所在小区
	 */
	private String area;
	/**
	 * 车位编号
	 */
	private String areaid;
	/**
	 * 车位发布时间
	 */
	private String issuetime;
	/**
	 * 发布车位用户名
	 */
	private String name;
	/**
	 * 发布车位用户工作
	 */
	private String job;
	/**
	 * 发布车位用户电话
	 */
	private String phone;
	/**
	 * 发布车位用户被投诉次数
	 */
	private String complaintnumber;
	/**
	 * 发布车位用户交易次数
	 */
	private String dealnumber;
	/**
	 * 车位照片
	 */
	private String propertyright;
	/**
	 * 车位出租开始时间
	 */
	private String endtime;
	/**
	 * 车位出租结束时间
	 */
	private String starttime;
	/**
	 * 车位出租价格
	 */
	private String price;
	
	
	
	
	
}
