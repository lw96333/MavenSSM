package com.one.bean;

import java.io.Serializable;

/**
 *  ��������
 * @author 
 *
 */
public class RegionBean implements Serializable{
	
	private Integer regionId; //����ID
	
	private String name; // ��������

	public RegionBean() {
		
	}
	
	public RegionBean(Integer regionId, String name) {
		super();
		this.regionId = regionId;
		this.name = name;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
