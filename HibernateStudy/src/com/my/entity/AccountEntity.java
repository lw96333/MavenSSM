package com.my.entity;
/**
 * 	银行账户
 * @author 49160
 *
 */
public class AccountEntity {
	
	private int id;
	
	private String name;//賬戶名
	
	private CreditcardEntity creditcard;//信用卡关联

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

	public CreditcardEntity getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(CreditcardEntity creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", name=" + name + "]";
	}
	
	

}
