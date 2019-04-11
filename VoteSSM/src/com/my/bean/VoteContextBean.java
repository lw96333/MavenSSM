package com.my.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VoteContextBean {
	
	private int id;
	
	private String title;

	private String contexts;
	
	private String removeId;
	
	private int sin;
	
	private int pub;
	
	private boolean falg;
}
