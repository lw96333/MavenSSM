package com.my.entity;
/**
 * 	信用卡实体类
 * @author 49160
 *
 */
public class CreditcardEntity {

	private int id;
	
	private String carId;//信用卡ID
	
	private String bank;//银行名
	
	private AccountEntity account;//账户关联引用

	public CreditcardEntity() {
		super();
	}

	public CreditcardEntity(int id, String carId, String bank, AccountEntity account) {
		super();
		this.carId = carId;
		this.bank = bank;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CreditcardEntity [id=" + id + ", carId=" + carId + ", bank=" + bank + "]";
	}
	
	
	
	
}
