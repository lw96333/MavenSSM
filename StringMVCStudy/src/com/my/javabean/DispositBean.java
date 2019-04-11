package com.my.javabean;

import javax.validation.constraints.Pattern;
import javax.websocket.server.PathParam;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.my.validaor.PhoneNo;

/**
 * 存款bean
 * @author 49160
 *
 */
public class DispositBean {

	@NotEmpty(message="账号不能为空")
	private String account;
	
	@Pattern(regexp="\\w{6,25}",message="用户名为6到25个字母或数字")
	private String name;
	
	@Pattern(regexp="\\S{6,25}",message="密码为6到25个字符")
	private String password;
	
	@NotBlank(message="金额不能位空")
	private String amount;
	
	@Pattern(regexp="\\d{18}",message="身份证为18位数字")
	private String id;
	
	@Pattern(regexp="1|2|3|4|5",message="存款年限为1-5年")
	private String duration;
	
	@PhoneNo
	private String phone;
	
	

	public DispositBean() {
		super();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DispositBean [account=" + account + ", name=" + name + ", password=" + password + ", amount=" + amount
				+ ", id=" + id + ", duration=" + duration + ", phone=" + phone + "]";
	}

	
	
	
}
