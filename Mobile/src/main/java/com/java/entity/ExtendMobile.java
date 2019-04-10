package com.java.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 手机号码归属地
 * </p>
 *
 * @author J164
 * @since 2019-04-10
 */
@TableName("extend_mobile")
public class ExtendMobile extends Model<ExtendMobile> {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号码前7位
     */
	private Integer pre;
    /**
     * 所在省
     */
	private String provice;
    /**
     * 所在市
     */
	private String city;
    /**
     * 地区编号
     */
	private Integer code;
    /**
     * 邮编
     */
	private Integer postcode;
    /**
     * 所属运营商
     */
	private String operators;


	public Integer getPre() {
		return pre;
	}

	public void setPre(Integer pre) {
		this.pre = pre;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getOperators() {
		return operators;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	@Override
	protected Serializable pkVal() {
		return this.pre;
	}

}
