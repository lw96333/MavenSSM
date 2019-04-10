package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 出租车位
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("leasecars")
public class Leasecars extends Model<Leasecars> {

    private static final long serialVersionUID = 1L;

    /**
     * 出租车位ID
     */
	private Integer id;
    /**
     * 车位ID
     */
	private Integer privatecarsid;
    /**
     * 出租车位开始时间
     */
	private String starttime;
    /**
     * 出租车位结束时间
     */
	private String endtime;
    /**
     * 出租车位发布时间
     */
	private String issuetime;
    /**
     * 出租车位状态
     */
	private String state;
    /**
     * 出租价格
     */
	private String price;
    /**
     * 留言
     */
	private String message;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrivatecarsid() {
		return privatecarsid;
	}

	public void setPrivatecarsid(Integer privatecarsid) {
		this.privatecarsid = privatecarsid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Leasecars [id=" + id + ", privatecarsid=" + privatecarsid + ", starttime=" + starttime + ", endtime="
				+ endtime + ", issuetime=" + issuetime + ", state=" + state + ", price=" + price + ", message="
				+ message + "]";
	}

}
