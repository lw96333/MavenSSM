package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * <p>
 * 私人车位
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("privatecars")
@Component
public class Privatecars extends Model<Privatecars> {

    private static final long serialVersionUID = 1L;

    /**
     * 车位ID
     */
	private Integer privatecarsid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 车位产全证编号
     */
	private String equitiesid;
    /**
     * 车位所在小区
     */
	private String area;
    /**
     * 车位所在小区编号
     */
	private String areaid;
    /**
     * 产权复印件
     */
	private String propertyright;
    /**
     * 审核状态
     */
	private String state;


	public Integer getPrivatecarsid() {
		return privatecarsid;
	}

	public void setPrivatecarsid(Integer privatecarsid) {
		this.privatecarsid = privatecarsid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getEquitiesid() {
		return equitiesid;
	}

	public void setEquitiesid(String equitiesid) {
		this.equitiesid = equitiesid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getPropertyright() {
		return propertyright;
	}

	public void setPropertyright(String propertyright) {
		this.propertyright = propertyright;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	protected Serializable pkVal() {
		return this.privatecarsid;
	}

}
