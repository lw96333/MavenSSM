package com.java.bean;

import lombok.Data;

/**
 * 用户出售车位信息
 * @author 罗维
 *
 * 2019年3月25日
 */
@Data
public class ShellCarParkingBean {

	/**
	 * 出售车位id
	 */
	private int sellcarsid;
	
	/**
	 * 出售价格
	 */
	private String price;
	
	/**
	 * 出售车位发布时间
	 */
	private String issuetime;
	
	/**
	 * 出售车位状态
	 */
	private String sellState;
	
	/**
	 * 出售留言
	 */
	private String sellMessage;
	
	/**
	 * 车位id
	 */
	private int privatecarsid;
	
	/**
	 * 车位编号
	 */
	private String equitiesid;
	
	/**
	 * 所在小区
	 */
	private String area;
	
	/**
	 * 小区id
	 */
	private String areaid;
	
	/**
	 * 产权复印件
	 */
	private String propertyright;
	
	/**
	 * 车位状态
	 */
	private String carState;
	
	/**
	 * 购买车位用户id
	 */
	private String userid;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 真实姓名
	 */
	private String realname;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * 省份证
	 */
	private String identitynumber;
	
	/**
	 * 工作
	 */
	private String job;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 投诉次数
	 */
	private int complaintnumber;
	
	/**
	 * 交易次数
	 */
	private int dealnumber;
	
	
	
}
