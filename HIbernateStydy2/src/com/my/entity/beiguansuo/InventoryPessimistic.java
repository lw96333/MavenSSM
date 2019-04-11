package com.my.entity.beiguansuo;
/**
 * 库存类
 * @author 49160
 *
 */
public class InventoryPessimistic {

	private int id;
	
	private String name;//姓名
	
	private String count;//数量

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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "InventoryPessimistic [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
	
}
