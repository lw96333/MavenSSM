package com.one.bean;

import java.io.Serializable;

/**
 *  虫害类型
 * @author 
 *
 */
public class PestTypesBean implements Serializable{

	private Integer insectId; // 虫害ID
	
	private String type; // 类型

	public PestTypesBean() {
		
	}
	
	public PestTypesBean(Integer insectId, String type) {
		super();
		this.insectId = insectId;
		this.type = type;
	}

	public Integer getInsectId() {
		return insectId;
	}

	public void setInsectId(Integer insectId) {
		this.insectId = insectId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PestTypesBean [insectId=" + insectId + ", type=" + type + "]";
	}
	
	
}
