package com.java.bean;

import lombok.Data;

/**
 * 出售合同信息查询
 * 
 * @author 罗维
 *
 *         2019年3月26日
 */
@Data
public class SelectContractShellBean {

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
	 * 出售用户id
	 */
	private int userid;

	/**
	 * 出售用户名
	 */
	private String name;

	/**
	 * 出售用户真实姓名
	 */
	private String realname;

	/**
	 * 出售用户地址
	 */
	private String address;

	/**
	 * 出售用户电话
	 */
	private String phone;

	/**
	 * 出售用户身份证
	 */
	private String identitynumber;

	/**
	 * 出售用户工作
	 */
	private String job;

	/**
	 * 出售用户邮箱
	 */
	private String email;

	/**
	 * 出售用户投诉次数
	 */
	private int complaintnumber;
	/**
	 * 出售用户交易次数
	 */
	private int dealnumber;

	
	/**
	 * 出售id
	 */
	private int sellcarsid;
	
	/**
	 * 出售时间
	 */
	private String issuetime;
	
	/**
	 * 出售车位状态
	 */
	private String sellState;
	
	/**
	 * 购买车位人留言
	 */
	private String sellMessage;
	
	/**
	 * 价格
	 */
	private String price;
	
}
