package com.java.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
/**
 * 添加外部合约
 * @author 张冀川
 *
 * 2019年3月26日
 */
@Data
public class ExternalcontractBean {
    /**
     * 合同编号
     */
	@NotEmpty(message="合同编号不能为空")
	private String contractnumber;
    /**
     * 合同单位
     */
	@NotEmpty(message="合同单位不能为空")
	private String contractcompany;
    /**
     * 对方联系人
     */
	@NotEmpty(message="对方联系人不能为空")
	private String contactperson;
    /**
     * 联系人电话
     */
	@NotEmpty(message="联系人电话不能为空")
	private String phone;
    /**
     * 车位所属单位地址
     */
	@NotEmpty(message="车位所属单位地址不能为空")
	private String address;
    /**
     * 
     * 合同生效日期(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})\\/(((0[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)\\/(0[1-9]|[12][0-9]|30))|(02\\/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))\\/02\\/29)
     */
	@NotEmpty(message="合同生效日期不能为空")
	private String starttime;
    /**
     * 合同截止日期
     */
	@NotEmpty(message="合同截止日期不能为空")
	private String endtime;
    /**
     * 成交价格
     */
	@NotEmpty(message="成交价格不能为空")
	private String price;
    /**
     * 车位地址
     */
	@NotEmpty(message="车位地址不能为空")
	private String stalladdress;
    /**
     * 车位起始编号
     */
	@NotEmpty(message="编号不能为空")
	private String stallnumber;
	  /**
     * 车位数量
     */
	private int number;
	  /**
     * 车位起始位置
     */
	private int startnumber;
    /**
     * 原合同编号
     */
}
