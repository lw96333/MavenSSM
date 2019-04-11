package com.my.zhujie.guanxi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 参加会议的人
 * @author 49160
 *
 */
@Entity
@Table(name="t_conventioneer")
public class CanHuiRenEntity {
	
	private int id;
	
	private String name;
	
	private HuiYiShiEntity boardroom;

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

	@ManyToOne(cascade=CascadeType.ALL,optional=true)
	@JoinColumn(name="fk_boardroom_id")
	public HuiYiShiEntity getBoardroom() {
		return boardroom;
	}

	public void setBoardroom(HuiYiShiEntity boardroom) {
		this.boardroom = boardroom;
	}
	
	

}
