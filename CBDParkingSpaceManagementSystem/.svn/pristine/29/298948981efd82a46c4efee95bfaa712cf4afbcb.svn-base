package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 网上合同签约表
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("examine")
public class Examine extends Model<Examine> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer examineid;
    /**
     * 出售车位id
     */
	private Integer sellcarsid;
    /**
     * 合同编号
     */
	private String contractnumber;
    /**
     * 交易价格
     */
	private String price;
    /**
     * 合同生效日期
     */
	private String fromdate;
	/**
	 * 购买车位id
	 */
	private String purchasecarsid;


	public Integer getExamineid() {
		return examineid;
	}

	public void setExamineid(Integer examineid) {
		this.examineid = examineid;
	}

	public Integer getSellcarsid() {
		return sellcarsid;
	}

	public void setSellcarsid(Integer sellcarsid) {
		this.sellcarsid = sellcarsid;
	}

	public String getContractnumber() {
		return contractnumber;
	}

	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	

	public String getPurchasecarsid() {
		return purchasecarsid;
	}

	public void setPurchasecarsid(String purchasecarsid) {
		this.purchasecarsid = purchasecarsid;
	}

	@Override
	protected Serializable pkVal() {
		return this.examineid;
	}

}
