package com.java.bean;

import java.util.List;

import lombok.Data;

/**
 * 企业合约Bean
 * @author 肖中华
 *
 * 2019年3月21日
 */
@Data
public class EnterprisecontractBean {
	
	/**
	 * 企业合约id
	 */
	private int enterprisecontractid;
	
	/**
	 * 企业id
	 */
	private int enterpriseid;
	/**
	 * 企业名称
	 */
	private String enterpriname	;
	
	/**
	 * 企业联系人
	 */
	private String  contactperson;
	
	/**
	 * 企业联系人电话
	 */
	private String  phone;
	/**
	 * 合同编号
	 */
	private String contractnumber;
	
	/**
	 * 新合同编号
	 */
	private String newcontractnumber;
	/**
	 * 合同生效日期
	 */
	private String fromdate;
	/**
	 * 合同失效日期
	 */
	private String deadline;
	
	/**
	 * 合同复印件
	 */
	private String 	contracts;
	
	/**
	 * 成交价格
	 */
	private String price;
	/**
	 * 车位地址
	 */
	private String address;
	/**
	 * 车位编号
	 */
	private String areanumber;
	
	/**
	 * 车位编号
	 */
	private List<Integer> cbdids;
}
