package com.my.javabean;

import java.util.Date;

public class GoodsBean {

	private String name;
	
	private double price;
	
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GoodsBean [name=" + name + ", price=" + price + ", date=" + date + "]";
	}
	
	
}
