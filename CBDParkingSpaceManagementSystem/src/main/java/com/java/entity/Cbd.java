package com.java.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * cbd车位表
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("cbd")
public class Cbd extends Model<Cbd> {

    private static final long serialVersionUID = 1L;

    /**
     * cbd车位id
     */
	@TableId(value="cbdid", type= IdType.AUTO)
	private Integer cbdid;
    /**
     * 车位地址
     */
	private String address;
    /**
     * 车位区域编号
     */
	private String areanumber;
    /**
     * 最长可租日期
     */
	private String sizetime;
    /**
     * 车位状态
     */
	private String state;
    /**
     * 外部合约id
     */
	private String externalid;


	/**
     * 企业合约id
     */
	private Integer enterprisecontractid;


	public Integer getCbdid() {
		return cbdid;
	}

	public void setCbdid(Integer cbdid) {
		this.cbdid = cbdid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreanumber() {
		return areanumber;
	}

	public void setAreanumber(String areanumber) {
		this.areanumber = areanumber;
	}

	public String getSizetime() {
		return sizetime;
	}

	public void setSizetime(String sizetime) {
		this.sizetime = sizetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getEnterprisecontractid() {
		return enterprisecontractid;
	}

	public void setEnterprisecontractid(Integer enterprisecontractid) {
		this.enterprisecontractid = enterprisecontractid;
	}
    public String getExternalid() {
		return externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	@Override
	protected Serializable pkVal() {
		return this.cbdid;
	}

}
