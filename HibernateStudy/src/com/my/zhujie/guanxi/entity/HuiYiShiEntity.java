package com.my.zhujie.guanxi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 会议室实体类
 * @author 49160
 *
 */
@Entity
@Table(name="t_boardroom")
public class HuiYiShiEntity {

	private int id;
	
	private String name;
	
	private String address;
	
	private Set<CanHuiRenEntity> conventioneers;
	
	private HeiBanEntity blackboard;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	//fetch=FetchType.LAZY延时加载，不会马上从数据库加载数据，fetch=FetchType.EAGER急加载，立刻马上冲数据库加载数据
	@OneToMany(mappedBy="boardroom",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<CanHuiRenEntity> getConventioneers() {
		return conventioneers;
	}

	public void setConventioneers(Set<CanHuiRenEntity> conventioneers) {
		this.conventioneers = conventioneers;
	}
	
	@OneToOne(mappedBy="boardroom",cascade=CascadeType.ALL)//设置对方挂念引用名
	public HeiBanEntity getBlackboard() {
		return blackboard;
	}

	public void setBlackboard(HeiBanEntity blackboard) {
		this.blackboard = blackboard;
	}
	
	
}
