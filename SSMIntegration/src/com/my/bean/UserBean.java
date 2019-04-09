package com.my.bean;
/**
 * 用户Bean
 * @author 罗维
 *
 * 2019年3月11日
 */
public class UserBean {

	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", password=" + password + "]";
	}
	
	
}
