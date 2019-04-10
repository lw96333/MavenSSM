package com.java.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@TableName("log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private Integer logid;
    /**
     * 用户名
     */
	private String name;
    /**
     * 操作时间
     */
	private String operatetime;
    /**
     * ip地址
     */
	private String ip;
    /**
     * 操作内容
     */
	private String operatecontent;
    /**
     * 日志级别
     */
	private String rank;
    /**
     * 日志操作
     */
	private String operation;


	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperatecontent() {
		return operatecontent;
	}

	public void setOperatecontent(String operatecontent) {
		this.operatecontent = operatecontent;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	protected Serializable pkVal() {
		return this.logid;
	}

	@Override
	public String toString() {
		return "Log [logid=" + logid + ", name=" + name + ", operatetime=" + operatetime + ", ip=" + ip
				+ ", operatecontent=" + operatecontent + ", rank=" + rank + ", operation=" + operation + "]";
	}
	

}
