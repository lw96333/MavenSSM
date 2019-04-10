package com.one.bean.disposalManagement;

import java.io.Serializable;

import com.one.bean.PestTypesBean;

/**
 *  ��еһ��
 * @author ֣
 *
 */
public class Consultation_managementBean implements Serializable{

	private Integer id; // ��еID
	
	private PestTypesBean insect; // �溦ID
	
	private String name; // ����
	
	private String purpose; // ��Ҫ��;

	public Consultation_managementBean() {
		
	}
	
	public Consultation_managementBean(Integer id, PestTypesBean insect, String name, String purpose) {
		super();
		this.id = id;
		this.insect = insect;
		this.name = name;
		this.purpose = purpose;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PestTypesBean getInsect() {
		return insect;
	}

	public void setInsect(PestTypesBean insect) {
		this.insect = insect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return "Consultation_managementBean [id=" + id + ", insect=" + insect + ", name=" + name + ", purpose="
				+ purpose + "]";
	}
	
	
}
