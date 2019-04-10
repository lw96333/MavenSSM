package com.java.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * 企业用户Bean类
 * @author 温岱
 *
 * 2019年3月21日
 */
@Data
public class EnterpriseUserBean {

	/**
	 * id
	 */
	private int enterpriseid;
	
	/**
	 * 企业用户登录名
	 */
	@Pattern(regexp="\\w{2,8}",message="密码为2-8位数字或字母")
	private String name;
	
	/**
	 * 密码
	 */
	@Pattern(regexp="\\w{6,25}",message="密码为6-12位数字或字母")
	private String password;
	
	/**
	 * 企业名称
	 */
	@Pattern(regexp="^[\\u4E00-\\u9FA5A-Za-z]+$",message="只能输入中文或数字")
	private String enterpriename;
	
	/**
	 * 企业联系人
	 */
	@Pattern(regexp="^[\\u4E00-\\u9FA5A-Za-z]+$",message="只能输入中文或数字")
	private String contactperson;
	
	/**
	 * 企业楼层
	 */
	@Pattern(regexp="^\\d{0,3}$",message="只能输入三位以内数字")
	private String floor;
	
	/**
	 * 企业电话
	 */
	@Pattern(regexp="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$",message="电话格式不正确")
	private String phone;
	
	
}
