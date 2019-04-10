package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 企业
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Component
@TableName("enterprise")
public class Enterprise extends Model<Enterprise> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 企业ID
     */
	private Integer enterpriseid;
    /**
     * 权限id
     */
	private Integer jurisdictionid;
    /**
     * 企业登录名
     */
	private String name;
    /**
     * 企业登录密码
     */
	private String password;
    /**
     * 企业名称
     */
	private String enterpriename;
    /**
     * 企业楼层
     */
	private Integer floor;
    /**
     * 企业联系人
     */
	private String contactperson;
    /**
     * 企业联系电话
     */
	private String phone;
    /**
     * 企业登录权限
     */
	private Integer powerid;


	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
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

	public String getEnterpriename() {
		return enterpriename;
	}

	public void setEnterpriename(String enterpriename) {
		this.enterpriename = enterpriename;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPowerid() {
		return powerid;
	}

	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}

	@Override
	protected Serializable pkVal() {
		return this.enterpriseid;
	}

}
