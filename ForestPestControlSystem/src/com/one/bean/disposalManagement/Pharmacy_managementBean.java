package com.one.bean.disposalManagement;

import java.io.Serializable;

import com.one.bean.DiseasesAndInsectPestsBean;
import com.one.bean.PestTypesBean;

/**
 *  Ìí¼ÓÒ©¼Á
 * @author Ö£
 *
 */
public class Pharmacy_managementBean implements Serializable{

	private Integer id; //Ò©¼ÁID
	
	private DiseasesAndInsectPestsBean diseases; // ²¡³æº¦ID
	
	private PestTypesBean insect;// ³æº¦ID
	
	private String name; // Ãû³Æ
	
	private String tree; // ÊÊÓÃÊ÷ÖÖ
	
	

	public Pharmacy_managementBean() {
		
	}
	
	public Pharmacy_managementBean(Integer id, DiseasesAndInsectPestsBean diseases, PestTypesBean insect, String name,
			String tree) {
		super();
		this.id = id;
		this.diseases = diseases;
		this.insect = insect;
		this.name = name;
		this.tree = tree;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DiseasesAndInsectPestsBean getDiseases() {
		return diseases;
	}

	public void setDiseases(DiseasesAndInsectPestsBean diseases) {
		this.diseases = diseases;
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

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}

	@Override
	public String toString() {
		return "Pharmacy_managementBean [id=" + id + ", diseases=" + diseases + ", insect=" + insect + ", name=" + name
				+ ", tree=" + tree + "]";
	}

	
	
}
