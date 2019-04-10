package com.one.bean.disasterPreventionAndControl;

import java.io.Serializable;
import java.util.Date;

import com.one.bean.LandClassBean;
/**
 * С�����
 * @author 16968
 *
 */
public class SmallClassManagementBean implements Serializable {
	
	private Integer id;
	/**
	 * ����
	 */
	private LandClassBean land;
	/**
	 * С������
	 */
	private String name;
	/**
	 * ������
	 */
	private String personName;
	/**
	 * �����˵绰
	 */
	private String personPhone;
	/**
	 * ��Ա����
	 */
	private String personNum;
	/**
	 * ����ʱ��
	 */
	private String creationTime;
	/**
	 * ����ͨ��С��id��ѯ����
	 */
	private AreaInBean areaIn;
	/**
	 * ����
	 */
	private int tolNum;
	
	
	public AreaInBean getAreaIn() {
		return areaIn;
	}

	public void setAreaIn(AreaInBean areaIn) {
		this.areaIn = areaIn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LandClassBean getLand() {
		return land;
	}

	public void setLand(LandClassBean land) {
		this.land = land;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	
	public int getTolNum() {
		return tolNum;
	}

	public void setTolNum(int tolNum) {
		this.tolNum = tolNum;
	}

	@Override
	public String toString() {
		return "SmallClassManagementBean [id=" + id + ", land=" + land + ", name=" + name
				+ ", personName=" + personName + ", personPhone=" + personPhone + ", personNum=" + personNum
				+ ", creationTime=" + creationTime + ", areaIn=" + areaIn + "]";
	}
	
	
	

}
