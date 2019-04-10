package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 企业合约
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("enterprisecontract")
public class Enterprisecontract extends Model<Enterprisecontract> {

    private static final long serialVersionUID = 1L;

    /**
     * 企业合约id
     */
	private Integer enterprisecontractid;
    /**
     * 企业ID
     */
	private Integer enterpriseid;
    
    /**
     * 合同编号
     */
	private String contractnumber;
    /**
     * 生效日期
     */
	private String fromdate;
    /**
     * 截止日期
     */
	private String deadline;
    /**
     * 成交价格
     */
	private String price;
    /**
     * 合同复印件
     */
	private String contract;
    /**
     * 原合同编号
     */
	private String oldcontractid;


	public Integer getEnterprisecontractid() {
		return enterprisecontractid;
	}

	public void setEnterprisecontractid(Integer enterprisecontractid) {
		this.enterprisecontractid = enterprisecontractid;
	}

	public Integer getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	
	public String getContractnumber() {
		return contractnumber;
	}

	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getOldcontractid() {
		return oldcontractid;
	}

	public void setOldcontractid(String oldcontractid) {
		this.oldcontractid = oldcontractid;
	}

	@Override
	protected Serializable pkVal() {
		return this.enterprisecontractid;
	}
	
}
