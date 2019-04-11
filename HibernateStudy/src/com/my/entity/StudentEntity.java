package com.my.entity;

import java.io.Serializable;

/**
 * 学生实体类
 * @author 49160
 *
 */
public class StudentEntity implements Serializable{

	private int id;
	
	private String name;
	
	private int age ;
	
	public StudentEntity() {}

	public StudentEntity(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
