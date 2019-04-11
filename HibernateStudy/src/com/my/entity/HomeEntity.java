package com.my.entity;

import java.util.Set;

/**
 * 家实体
 * @author 49160
 *
 */
public class HomeEntity {

	private int id;
	
	private String address;
	
	private Set<MemberEntity> members;//家庭成员集合关联引用

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberEntity> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "HomeEntity [id=" + id + ", address=" + address + ", members=" + members + "]";
	}
	
	
}
