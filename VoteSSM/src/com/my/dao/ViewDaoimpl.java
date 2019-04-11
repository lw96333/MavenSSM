package com.my.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.entity.VoteEntity;
import com.my.mapper.ViewMapper;

@Repository
public class ViewDaoimpl implements IViewDao{

	@Autowired
	private ViewMapper viewMapper;

	@Override
	public List<VoteEntity> selectAllPubVote() {
		// TODO Auto-generated method stub
		return viewMapper.selectAllPubVote();
	}

	@Override
	public void updateVoteContext(List<Integer> list) {
		// TODO Auto-generated method stub
		for(int index = 0;index < list.size();index++) {
			viewMapper.updateVoteContext(list.get(index));
		}
		
	}
	
	
}
