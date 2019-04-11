package com.my.service;

import java.util.List;

import com.my.entity.VoteEntity;

public interface IViewService {

	List<VoteEntity> selectAllPubVote();
	
	void updateVoteContext(String str);
}
