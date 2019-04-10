package com.java.bean;

import lombok.Data;

/**
 * 用户租赁信息Bean
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Data
public class ViewTheRentalPageBean {

	/**
	 * 出租人ID
	 */
	private int userid;
	/**
	 * 车位ID
	 */
	private int  privatecarsid;
	/**
	 * 车位产权编号
	 */
	private String equitiesid;
	/**
	 * 车位小区地址
	 */
	private String area;
	/**
	 * 租借开始时间
	 */
	private String startime;
	/**
	 * 租借结束时间
	 */
	private String endtime;
	/**
	 * 出租人
	 */
	private String name;
	/**
	 * 出租人真名
	 */
	private String realname;
	/**
	 * 租赁状态
	 */
	private String state;
	/**
	 * 用户电话
	 */
	private String phone;
}
