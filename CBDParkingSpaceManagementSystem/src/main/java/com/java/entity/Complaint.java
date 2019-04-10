package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 投诉表
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("complaint")
public class Complaint extends Model<Complaint> {

    private static final long serialVersionUID = 1L;

    /**
     * 投诉id
     */
	private Integer complaintid;
    /**
     * 投诉内容
     */
	private String content;
    /**
     * 投诉状态
     */
	private String state;
    /**
     * 投诉人id
     */
	private Integer bid;
    /**
     * 被投诉人id
     */
	private Integer btid;
    /**
     * 投诉时间
     */
	private String complaintime;


	public Integer getComplaintid() {
		return complaintid;
	}

	public void setComplaintid(Integer complaintid) {
		this.complaintid = complaintid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getBtid() {
		return btid;
	}

	public void setBtid(Integer btid) {
		this.btid = btid;
	}

	public String getComplaintime() {
		return complaintime;
	}

	public void setComplaintime(String complaintime) {
		this.complaintime = complaintime;
	}

	@Override
	protected Serializable pkVal() {
		return this.complaintid;
	}

	@Override
	public String toString() {
		return "Complaint [complaintid=" + complaintid + ", content=" + content + ", state=" + state + ", bid=" + bid
				+ ", btid=" + btid + ", complaintime=" + complaintime + "]";
	}
	
	

}
