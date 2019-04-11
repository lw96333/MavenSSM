package com.student.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName
public class StudentEntity implements Serializable {

	private Integer id;

	private String name;

	private Integer age;

	private String phone;

	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address="
				+ address + "]";
	}

}