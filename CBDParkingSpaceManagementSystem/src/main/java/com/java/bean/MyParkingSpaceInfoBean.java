package com.java.bean;

import lombok.Data;

/**
 * 查看我的车位出租信息Bean
 * @author 刘佳秋
 *
 * 2019年3月24日
 */
@Data
public class MyParkingSpaceInfoBean {

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
	private String startime;
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
}
