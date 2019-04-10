package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 租赁
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("deal")
public class Deal extends Model<Deal> {

    private static final long serialVersionUID = 1L;

    /**
     * 租借交易id
     */
	private Integer dealid;
    /**
     * 车位ID
     */
	private Integer privatecarsid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 租借开始时间
     */
	private String startime;
    /**
     * 租借结束时间
     */
	private String endtime;
    /**
     * 留言
     */
	private String message;
    /**
     * 租借状态
     */
	private String state;
    /**
     * 租借价格
     */
	private String price;


	public Integer getDealid() {
		return dealid;
	}

	public void setDealid(Integer dealid) {
		this.dealid = dealid;
	}

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

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	protected Serializable pkVal() {
		return this.dealid;
	}

	@Override
	public String toString() {
		return "Deal [dealid=" + dealid + ", privatecarsid=" + privatecarsid + ", userid=" + userid + ", startime="
				+ startime + ", endtime=" + endtime + ", message=" + message + ", state=" + state + ", price=" + price
				+ "]";
	}

	
}
