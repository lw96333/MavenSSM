package com.java.bean;

import lombok.Data;

/**
 * 合同查询
 * 
 * @author 罗维
 *
 *         2019年3月26日
 */
@Data
public class SelectContractBean {

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
	private int sUserid;

	/**
	 * 出售用户名
	 */
	private String sUserName;

	/**
	 * 出售用户真实姓名
	 */
	private String sUserRealname;

	/**
	 * 出售用户地址
	 */
	private String sUserAddress;

	/**
	 * 出售用户电话
	 */
	private String sUserPhone;

	/**
	 * 出售用户身份证
	 */
	private String sUserIdentitynumber;

	/**
	 * 出售用户工作
	 */
	private String sUserJob;

	/**
	 * 出售用户邮箱
	 */
	private String sUserEmail;

	/**
	 * 出售用户投诉次数
	 */
	private int sUsersComplaintnumber;
	/**
	 * 出售用户交易次数
	 */
	private int sUserDealnumber;

	/**
	 * 购买用户id
	 */
	private int bUserid;

	/**
	 * 购买用户名
	 */
	private String bUserName;

	/**
	 * 购买用户真实姓名
	 */
	private String bUserRealname;

	/**
	 * 购买用户地址
	 */
	private String bUserAddress;

	/**
	 * 购买用户电话
	 */
	private String bUserPhone;

	/**
	 * 购买用户身份证
	 */
	private String bUserIdentitynumber;

	/**
	 * 购买用户工作
	 */
	private String bUserJob;

	/**
	 * 购买用户邮箱
	 */
	private String bUserEmail;

	/**
	 * 购买用户投诉次数
	 */
	private int bUsersComplaintnumber;
	/**
	 * 购买用户交易次数
	 */
	private int bUserDealnumber;

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
	
	/**
	 * 合同id
	 */
	private String examineid;
	
	/**
	 *伙同编号
	 */
	private String contractnumber;
	
	/**
	 * 车位价格
	 */
	private String price;
	
	/**
	 * 签约时间
	 */
	private String fromdate;
}
