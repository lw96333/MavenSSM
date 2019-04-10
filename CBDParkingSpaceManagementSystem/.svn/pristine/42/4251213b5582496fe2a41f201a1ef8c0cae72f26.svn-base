package com.java.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("jurisdiction")
public class Jurisdiction extends Model<Jurisdiction> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
	@TableId(value="jurisdictionid", type= IdType.AUTO)
	private Integer jurisdictionid;
    /**
     * 权限
     */
	private String jurisdiction;


	public Integer getJurisdictionid() {
		return jurisdictionid;
	}

	public void setJurisdictionid(Integer jurisdictionid) {
		this.jurisdictionid = jurisdictionid;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	@Override
	protected Serializable pkVal() {
		return this.jurisdictionid;
	}

}
