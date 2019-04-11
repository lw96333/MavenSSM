package com.my.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
public class AdminEntity {

	private int admin_id;
	
	private String name;
	
	private String password;
	
	private String logintime;
}
