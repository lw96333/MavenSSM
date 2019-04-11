package com.my.zhijie.bean;

import java.io.Serializable;

public class GoodsInfoBean implements Serializable{

	private String name;
	
	private int price;

	public GoodsInfoBean() {
		super();
	}
	
	

	public GoodsInfoBean(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GoodsInfoBean [name=" + name + ", price=" + price + "]";
	}
	
	
}
