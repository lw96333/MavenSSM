package com.my.entity;
/**
 *	 家庭成员
 * @author 49160
 *
 */
public class MemberEntity {

	private int id;
	
	private String relation;	//家庭关系
	
	private HomeEntity home; //家关联引用

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public HomeEntity getHome() {
		return home;
	}

	public void setHome(HomeEntity home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", relation=" + relation + "]";
	}
	
	
}
