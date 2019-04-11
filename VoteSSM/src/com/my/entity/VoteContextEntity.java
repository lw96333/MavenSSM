package com.my.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteContextEntity {

	private int votecontext_id;
	
	private String context;
	
	private int count;
	
	private String voteName;
	
	private int voteType;
	
	private int votePublish;
	
	private int vote_id;
	
}
