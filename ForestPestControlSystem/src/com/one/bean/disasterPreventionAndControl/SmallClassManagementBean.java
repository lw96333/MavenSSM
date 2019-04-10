package com.one.bean.disasterPreventionAndControl;

import java.io.Serializable;
import java.util.Date;

import com.one.bean.LandClassBean;
/**
 * 小班管理
 * @author 16968
 *
 */
public class SmallClassManagementBean implements Serializable {
	
	private Integer id;
	/**
	 * 地类
	 */
	private LandClassBean land;
	/**
	 * 小班名称
	 */
	private String name;
	/**
	 * 负责人
	 */
	private String personName;
	/**
	 * 负责人电话
	 */
	private String personPhone;
	/**
	 * 人员数量
	 */
	private String personNum;
	/**
	 * 创建时间
	 */
	private String creationTime;
	/**
	 * 连表通过小班id查询林种
	 */
	private AreaInBean areaIn;
	/**
	 * 总数
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
