package com.one.bean;

import java.io.Serializable;

/**
 *  ����λ��
 * @author 
 *
 */
public class LocationBean implements Serializable{

	private Integer locationId; // λ��ID
	
	private String path; // λ��

	public LocationBean() {
		
	}
	
	public LocationBean(Integer locationId, String path) {
		super();
		this.locationId = locationId;
		this.path = path;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
