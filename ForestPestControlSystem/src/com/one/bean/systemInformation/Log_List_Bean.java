package com.one.bean.systemInformation;

import java.io.Serializable;
import java.util.Date;

/**
 * ��־����
 * 
 * @author 49160
 *
 */
public class Log_List_Bean implements Serializable {

	private Integer id;// ��־���

	private String content;// ��־����

	private String date;// ����

	public Log_List_Bean() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Log_List_bean [iogid=" + id + ", content=" + content + ", date=" + date + "]";
	}

}