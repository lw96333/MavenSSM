package com.java.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
/**
 * 页面传入外部合约续约的文件
 * @author 张冀川
 *
 * 2019年3月26日
 */
@Data
public class UpdataExternalcontractBean {
	/**
     * id
     */
	@NotEmpty(message="id不能为空")
	private String id;
    /**
     * 原合同编号
     */
	@Pattern(regexp="\\S{6,25}",message="合同编号为6个到25个数字")
	@NotEmpty(message="原合同编号不能为空")
	private String oldcontractnumber;
    /**
     * 合同编号
     */
	@Pattern(regexp="\\S{6,25}",message="合同编号为6个到25个数字")
	@NotEmpty(message="合同编号不能为空")
	private String contractnumber;
    /**
     * 对方联系人
     */
	@Pattern(regexp="\\S{1,}",message="请输入联系人")
	@NotEmpty(message="对方联系人不能为空")
	private String contactperson;
    /**
     * 联系人电话
     */
	@Pattern(regexp="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$",message="请输入中国再用手机号")
	@NotEmpty(message="联系人电话不能为空")
	private String phone;
    /**
     * 
     * 合同生效日期(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})\\/(((0[13578]|1[02])\\/(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)\\/(0[1-9]|[12][0-9]|30))|(02\\/(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))\\/02\\/29)
     */
	@Pattern(regexp="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",message="请输入正确开始日期")
	@NotEmpty(message="合同生效日期不能为空")
	private String starttime;
    /**
     * 合同截止日期
     */
	@Pattern(regexp="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",message="请输入正确截止日期")
	@NotEmpty(message="合同截止日期不能为空")
	private String endtime;
    /**
     * 成交价格
     */
	@Pattern(regexp="\\d{0,12}",message="金额为阿拉伯数字")
	@NotEmpty(message="成交价格不能为空")
	private String price;
    /**
     * 
     */
	@Pattern(regexp="\\S{1,}",message="请输入正确单位")
	@NotEmpty(message="合同单位不能为空")
	private String contractcompany;
}
