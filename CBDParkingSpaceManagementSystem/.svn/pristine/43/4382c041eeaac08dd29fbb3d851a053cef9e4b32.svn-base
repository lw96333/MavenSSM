package com.java.bean;

import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * 添加出售发布时间Bean
 * @author 温岱
 *
 * 2019年3月24日
 */
@Data
public class AddSellTimeBean {

	
	/**
	 * 价格
	 */
	@Pattern(regexp="^\\d{0,6}$",message="只能输入百万内")
	private String price;
	
	/**
	 * 车位id
	 */
	private String privatecarsid;
}
