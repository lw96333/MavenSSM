package com.one.bean;

import java.io.Serializable;

/**
 *  发生位置
 * @author 
 *
 */
public class LocationBean implements Serializable{

	private Integer locationId; // 位置ID
	
	private String path; // 位置

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
