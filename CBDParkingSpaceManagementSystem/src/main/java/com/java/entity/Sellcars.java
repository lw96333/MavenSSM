package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 出售车位
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("sellcars")
public class Sellcars extends Model<Sellcars> {

    private static final long serialVersionUID = 1L;

    /**
     * 出售车位id
     */
	private Integer sellcarsid;
    /**
     * 车位ID
     */
	private Integer privatecarsid;
    /**
     * 出售车位价格
     */
	private String price;
    /**
     * 出售车位发布时间
     */
	private String issuetime;
    /**
     * 出售车位状态
     */
	private String state;
    /**
     * 留言
     */
	private String message;
	/**
	 * 购买人id
	 */
	private int buyuserid;


	public Integer getSellcarsid() {
		return sellcarsid;
	}

	public void setSellcarsid(Integer sellcarsid) {
		this.sellcarsid = sellcarsid;
	}

	public Integer getPrivatecarsid() {
		return privatecarsid;
	}

	public void setPrivatecarsid(Integer privatecarsid) {
		this.privatecarsid = privatecarsid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public int getBuyuserid() {
		return buyuserid;
	}

	public void setBuyuserid(int buyuserid) {
		this.buyuserid = buyuserid;
	}

	@Override
	protected Serializable pkVal() {
		return this.sellcarsid;
	}

}
