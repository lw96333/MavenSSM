package com.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.my.entity.VoteEntity;

public interface IViewDao {

	
	List<VoteEntity> selectAllPubVote();
	
	void updateVoteContext(List<Integer> list);
}
