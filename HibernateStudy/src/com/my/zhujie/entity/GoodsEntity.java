package com.my.zhujie.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 商品实体类
 * @author 49160
 *
 */
//实体类声明
@Entity
//类与表的映射
@Table(name="t_goods")
public class GoodsEntity implements Serializable{

	private int id;
	
	private String name;
	
	private int price;
	
	private String type;
	
	public GoodsEntity() {}
	
	public GoodsEntity(String name, int price, String type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}
	//表示主键id
	@Id
	//设置自增主键策略
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	@Column(name="f_name",length=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//	@Column(name="f_price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	@Column(name="f_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GoodsEntity [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}
	
}
