package com.java.bean;

import lombok.Data;

/**
 * 购买合同信息查询
 * 
 * @author 罗维
 *
 *         2019年3月26日
 */
@Data
public class SelectContractBuyBean {

	/**
	 * 车位id
	 */
	private int privatecarsid;

	/**
	 * 车位产全证编号
	 */
	private String equitiesid;

	/**
	 * 所在小区
	 */
	private String area;

	/**
	 * 小区编号
	 */
	private String areaid;

	/**
	 * 产权复印件
	 */
	private String propertyright;

	/**
	 * 车位状态
	 */
	private String privState;

	

	/**
	 * 购买用户id
	 */
	private int userid;

	/**
	 * 购买用户名
	 */
	private String name;

	/**
	 * 购买用户真实姓名
	 */
	private String realname;

	/**
	 * 购买用户地址
	 */
	private String address;

	/**
	 * 购买用户电话
	 */
	private String phone;

	/**
	 * 购买用户身份证
	 */
	private String identitynumber;

	/**
	 * 购买用户工作
	 */
	private String job;

	/**
	 * 购买用户邮箱
	 */
	private String email;

	/**
	 * 购买用户投诉次数
	 */
	private int complaintnumber;
	/**
	 * 购买用户交易次数
	 */
	private int dealnumber;

	/**
	 * 购买车位id
	 */
	private int purchasecarsid;
	
	/**
	 * 购买车位时间
	 */
	private String startime;
	
	/**
	 * 出售车位留言
	 */
	private String purMessage;
	
	/**
	 * 购买车位状态
	 */
	private String purState;
	
	
}
