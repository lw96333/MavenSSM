package com.java.bean;

import lombok.Data;
/**
 * 审批个人添加车位所需数据Bean
 * @author 刘佳秋
 *
 * 2019年3月21日
 */
@Data
public class PersonalAddedParkingBean {

	/**
	 * 用户Id
	 */
	private int userid;
	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 车位产权证编号
	 */
	private String equitiesid;
	/**
	 * 车位所在小区
	 */
	private String area;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 身份证号码
	 */
	private String identitynumber;
	/**
	 * 电话号码
	 */
	private String phone;
}
