package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 个人用户
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("user")
public class User extends Model<User> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 权限id
     */
	private Integer jurisdictionid;
    /**
     * 用户名
     */
	private String name;
    /**
     * 用户密码
     */
	private String password;
    /**
     * 真实姓名
     */
	private String realname;
    /**
     * 地址
     */
	private String address;
    /**
     * 电话
     */
	private String phone;
    /**
     * 身份证
     */
	private String identitynumber;
    /**
     * 工作
     */
	private String job;
    /**
     * 电子邮箱
     */
	private String email;
    /**
     * 投诉次数
     */
	private Integer complaintnumber;
    /**
     * 交易次数
     */
	private Integer dealnumber;


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getJurisdictionid() {
		return jurisdictionid;
	}

	public void setJurisdictionid(Integer jurisdictionid) {
		this.jurisdictionid = jurisdictionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentitynumber() {
		return identitynumber;
	}

	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getComplaintnumber() {
		return complaintnumber;
	}

	public void setComplaintnumber(Integer complaintnumber) {
		this.complaintnumber = complaintnumber;
	}

	public Integer getDealnumber() {
		return dealnumber;
	}

	public void setDealnumber(Integer dealnumber) {
		this.dealnumber = dealnumber;
	}

	@Override
	protected Serializable pkVal() {
		return this.userid;
	}

}
