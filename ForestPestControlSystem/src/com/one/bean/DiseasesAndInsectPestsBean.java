package com.one.bean;

import java.io.Serializable;

/**
 *  ���ò��溦
 * @author 
 *
 */
public class DiseasesAndInsectPestsBean implements Serializable{

	private Integer diseasesId; // ���溦ID
	
	private String diseasesType; // ���溦����

	public DiseasesAndInsectPestsBean() {
		
	}
	
	public DiseasesAndInsectPestsBean(Integer diseasesId, String diseasesType) {
		super();
		this.diseasesId = diseasesId;
		this.diseasesType = diseasesType;
	}

	public Integer getDiseasesId() {
		return diseasesId;
	}

	public void setDiseasesId(Integer diseasesId) {
		this.diseasesId = diseasesId;
	}

	public String getDiseasesType() {
		return diseasesType;
	}

	public void setDiseasesType(String diseasesType) {
		this.diseasesType = diseasesType;
	}

	@Override
	public String toString() {
		return "DiseasesAndInsectPestsBean [diseasesId=" + diseasesId + ", diseasesType=" + diseasesType + "]";
	}
	
	
}
