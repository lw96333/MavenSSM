package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 管理员计费
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("adminbilling")
public class Adminbilling extends Model<Adminbilling> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员计费id
     */
	private Integer adminbillingid;
    /**
             * 管理员id
     */
	private Integer adminid;
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


	public Integer getAdminbillingid() {
		return adminbillingid;
	}

	public void setAdminbillingid(Integer adminbillingid) {
		this.adminbillingid = adminbillingid;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
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
		return this.adminbillingid;
	}

}
