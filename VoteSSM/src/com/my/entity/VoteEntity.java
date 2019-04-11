package com.my.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 投票信息实体
 * @author 罗维
 *
 * 2019年3月12日
 */
@Getter
@Setter
@ToString
public class VoteEntity {
	
	private int vote_id;
	
	private String title;
	
	private String createdate;
	
	private int type;
	
	private int publish;
	
	private int typeNum;
	
	private String adminName;
	
	private int adminId;
}
