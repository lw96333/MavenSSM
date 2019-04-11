package com.my.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.IViewDao;
import com.my.entity.VoteEntity;

@Service
public class ViewServiceImpl implements IViewService{

	@Autowired
	private IViewDao viewDao;
	
	@Override
	public List<VoteEntity> selectAllPubVote() {
		// TODO Auto-generated method stub
		return viewDao.selectAllPubVote();
	}

	@Override
	public void updateVoteContext(String str) {
		// TODO Auto-generated method stub
		List<Integer> li = new ArrayList<Integer>();
		String[] strs = str.split("\\^");
		for(int index = 0;index < strs.length;index++) {
			li.add(Integer.parseInt(strs[index]));
		}
		viewDao.updateVoteContext(li);
		
	}

}
