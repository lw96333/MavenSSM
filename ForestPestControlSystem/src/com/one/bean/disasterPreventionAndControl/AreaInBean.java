package com.one.bean.disasterPreventionAndControl;

import java.io.Serializable;

import com.one.bean.LandClassBean;
/**
 * ����һ��
 * @author 16968
 *
 */

public class AreaInBean implements Serializable {

	private Integer areaId;
	/**
	 * ����
	 */
	private LandClassBean linDi;
	/**
	 * С��
	 */
	private SmallClassManagementBean small;
	/**
	 * ����
	 */
	private String forest;
	/**
	 * ��������
	 */
	private String advantage;
	/**
	 * ��������
	 */
	private String name;
	
	private int tolNum;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public LandClassBean getLinDi() {
		return linDi;
	}

	public void setLinDi(LandClassBean linDi) {
		this.linDi = linDi;
	}

	public String getForest() {
		return forest;
	}

	public void setForest(String forest) {
		this.forest = forest;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public SmallClassManagementBean getSmall() {
		return small;
	}

	public void setSmall(SmallClassManagementBean small) {
		this.small = small;
	}

	public int getTolNum() {
		return tolNum;
	}

	public void setTolNum(int tolNum) {
		this.tolNum = tolNum;
	}

	@Override
	public String toString() {
		return "AreaInBean [areaId=" + areaId + ", smallClass=" + ", linDi=" + linDi + ", forest=" + forest
				+ ", advantage=" + advantage + ", name=" + name + "]";
	}
	
	
}
