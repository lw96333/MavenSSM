package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 管理员权限关系表
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("adminpower")
public class Adminpower extends Model<Adminpower> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer adminpowerid;
    /**
     * 权限id
     */
	private Integer jurisdictionid;
    /**
     * 管理员id
     */
	private Integer adminid;


	public Integer getAdminpowerid() {
		return adminpowerid;
	}

	public void setAdminpowerid(Integer adminpowerid) {
		this.adminpowerid = adminpowerid;
	}

	public Integer getJurisdictionid() {
		return jurisdictionid;
	}

	public void setJurisdictionid(Integer jurisdictionid) {
		this.jurisdictionid = jurisdictionid;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	@Override
	protected Serializable pkVal() {
		return this.adminpowerid;
	}

}
