package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("admin")
public class Admin extends Model<Admin> implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
	private Integer adminid;
    /**
     * 真实姓名
     */
	private String name;
    /**
     * 密码
     */
	private String password;
    /**
     * 工号
     */
	private String jobnumber;
    /**
     * 电话
     */
	private String phone;


	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
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

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	protected Serializable pkVal() {
		return this.adminid;
	}

}
