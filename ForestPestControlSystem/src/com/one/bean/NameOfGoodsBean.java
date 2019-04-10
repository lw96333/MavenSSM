package com.one.bean;

import java.io.Serializable;

/**
 *  物品名称
 * @author 
 *
 */
public class NameOfGoodsBean implements Serializable{

	private Integer goodsId; //物品Id
	
	private String goodsName; //物品名称

	public NameOfGoodsBean() {
		
	}
	
	public NameOfGoodsBean(Integer goodsId, String goodsName) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
}
