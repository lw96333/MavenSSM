package com.one.bean;

import java.io.Serializable;

/**
 *  类型
 * @author 
 *
 */
public class TypeBean implements Serializable{

	private Integer typeId; //类型ID
	
	private String typeName; //类型名字

	public TypeBean() {
		
	}
	
	public TypeBean(Integer typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
