package com.my.zhujie.guanxi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 黑板实体类
 * @author 49160
 *
 */
@Entity
@Table(name="t_blackboard")
public class HeiBanEntity {
	private int id;
	
	private int size;
	
	private HuiYiShiEntity boardroom;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@OneToOne(cascade=CascadeType.ALL)//级联操作
	@JoinColumn(name="fk_boardroom_id",unique=true)//设置关联外键以及唯一约束
	public HuiYiShiEntity getBoardroom() {
		return boardroom;
	}

	public void setBoardroom(HuiYiShiEntity boardroom) {
		this.boardroom = boardroom;
	}
	
	

}
