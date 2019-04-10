package com.java.bean;

import lombok.Data;

/**
 * 交易记录Bean
 * @author 刘佳秋
 *
 * 2019年3月29日
 */
@Data
public class TransactionRecordBean {

	/**
	 * 当前用户ID
	 */
	private int userId;
	/**
	 * 租赁用户ID
	 */
	private int duserId;
	/**
	 * 车位ID
	 */
	private int privatecarsid;
	/**
	 * 开始时间
	 */
	private String startime;
	/**
	 * 结束时间
	 */
	private String endtime;
	/**
	 * 价格
	 */
	private int price;
}
