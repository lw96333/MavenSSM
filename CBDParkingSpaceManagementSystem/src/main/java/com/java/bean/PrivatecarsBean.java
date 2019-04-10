package com.java.bean;

import lombok.Data;

/**
 * 查看个人添加车位信息Bean
 * @author 郑升亮
 *
 *2019年3月22日
 */
@Data
public class PrivatecarsBean {

	/**
     * 车位产全证编号
     */
	private String equitiesid;
	/**
     * 车位所在小区
     */
	private String area;
	/**
     * 审核状态
     */
	private String state;
}
