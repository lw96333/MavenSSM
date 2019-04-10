package com.java.bean;

import lombok.Data;

/**
 * 审批个人买卖车位后台数据页面显示Bean
 * @author 刘佳秋
 *
 * 2019年3月21日
 */
@Data
public class UnauditedParkingSpaceInfoBean {

	/**
	 * 购买车位ID
	 */
	private int purchasecarsid;
	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 出售人ID
	 */
	private int sellUserid;
	/**
	 * 购买人ID
	 */
	private int purchaseUserid;
	/**
	 * 车位产权证编号
	 */
	private String equitiesid;
	/**
	 * 所在小区
	 */
	private String area;
	/**
	 * 出售人姓名
	 */
	private String realname;
	/**
	 * 购买人姓名
	 */
	private String purchaseRealname;
	/**
	 * 出售人电话
	 */
	private String phone;
	/**
	 * 购买人电话
	 */
	private String purchasePhone;
	/**
	 * 出售人身份证号码
	 */
	private String identitynumber;
}
