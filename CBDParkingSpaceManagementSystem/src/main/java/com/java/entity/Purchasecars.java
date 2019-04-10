package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 购买车位
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("purchasecars")
public class Purchasecars extends Model<Purchasecars> {

    private static final long serialVersionUID = 1L;

    /**
     * 购买车位ID
     */
	private Integer purchasecarsid;
    /**
     * 用户ID
     */
	private Integer userid;
   
    /**
     * 购买车位价格
     */
	private String price;
    /**
     * 购买时间
     */
	private String startime;
    /**
     * 留言
     */
	private String message;
    /**
     * 状态
     */
	private String state;
	/**
	 * 出售车位ID
	 */
	private int sellcarsid;


	public Integer getPurchasecarsid() {
		return purchasecarsid;
	}

	public void setPurchasecarsid(Integer purchasecarsid) {
		this.purchasecarsid = purchasecarsid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSellcarsid() {
		return sellcarsid;
	}

	public void setSellcarsid(int sellcarsid) {
		this.sellcarsid = sellcarsid;
	}

	@Override
	protected Serializable pkVal() {
		return this.purchasecarsid;
	}

}
