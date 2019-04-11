package com.my.entity.leguansuo;
/**
 * 库存类乐观锁
 * @author 49160
 *
 */
public class InventoryOptimistic {

	private int id;
	
	private String name;
	
	private int count;
	
	private int version1;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getVersion1() {
		return version1;
	}

	public void setVersion1(int version1) {
		this.version1 = version1;
	}

	@Override
	public String toString() {
		return "InventoryOptimistic [id=" + id + ", name=" + name + ", count=" + count + ", version1=" + version1 + "]";
	}

	
	
	
}
