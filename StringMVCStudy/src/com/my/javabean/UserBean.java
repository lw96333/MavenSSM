package com.my.javabean;

public class UserBean {//属性名要和控件参数名相同

	private String name;
	
	private String password;
	
	private String email;
	

	public UserBean() {
		super();
	}

	public UserBean(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}



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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
