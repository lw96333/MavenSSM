package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
   * 个人用户计费
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("userbilling")
public class Userbilling extends Model<Userbilling> {

    private static final long serialVersionUID = 1L;

    /**
     * 个人用户计费id
     */
	private Integer userbillingid;
    /**
     * 用户ID
     */
	private Integer userid;
    /**
     * 开始时间
     */
	private String starttime;
    /**
     * 结束时间
     */
	private String endtime;
    /**
     * 收入
     */
	private double income;
    /**
     * 支出
     */
	private double expend;
    /**
     * 交易备注
     */
	private String comment;


	public Integer getUserbillingid() {
		return userbillingid;
	}

	public void setUserbillingid(Integer userbillingid) {
		this.userbillingid = userbillingid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpend() {
		return expend;
	}

	public void setExpend(double expend) {
		this.expend = expend;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	protected Serializable pkVal() {
		return this.userbillingid;
	}

}
