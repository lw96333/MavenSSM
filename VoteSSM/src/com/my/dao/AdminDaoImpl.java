package com.my.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.bean.AdminBean;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;
import com.my.mapper.AdminMapper;


@Repository
public class AdminDaoImpl implements IAdminDao{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public AdminEntity findAdminByNameAndPassword(AdminBean adminBean) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminByNameAndPassword(adminBean);
	}

	@Override
	public int updateLoginTimeById(String date, int id) {
		// TODO Auto-generated method stub
		return adminMapper.updateLoginTimeById(date, id);
	}

	@Override
	public List<VoteEntity> findVoteById(int id) {
		// TODO Auto-generated method stub
		return adminMapper.findVoteById(id);
	}

	@Override
	public List<VoteEntity> findAllVoteById(int id) {
		// TODO Auto-generated method stub
		return adminMapper.findAllVoteById(id);
	}

	@Override
	public List<VoteContextEntity> findOneVoteContext(int id) {
		// TODO Auto-generated method stub
		return adminMapper.findOneVoteContext(id);
	}

	@Override
	public int updateVote(int type, int publish, int id) {
		// TODO Auto-generated method stub
		return adminMapper.updateVote(type, publish, id);
	}

	@Override
	public int batchInsert(List<VoteContextEntity> menus) {
		// TODO Auto-generated method stub
		return adminMapper.batchInsert(menus);
	}

	@Override
	public int batchDelete(int[] array) {
		// TODO Auto-generated method stub
		return adminMapper.batchDelete(array);
	}

	@Override
	public int insertVote(VoteEntity voteEntity) {
		// TODO Auto-generated method stub
		return adminMapper.insertVote(voteEntity);
	}

	@Override
	public int selectVoteIDByDate(String date) {
		// TODO Auto-generated method stub
		return adminMapper.selectVoteIDByDate(date);
	}

	@Override
	public List<VoteEntity> findAllVoteByIdAndCondition(int id, String condition) {
		// TODO Auto-generated method stub
		return adminMapper.findAllVoteByIdAndCondition(id, condition);
	}

	@Override
	public int updateAccountPwd(int id, String pwd) {
		// TODO Auto-generated method stub
		return adminMapper.updateAccountPwd(id, pwd);
	}

	@Override
	public int insertAccount(AdminEntity adminEntity) {
		// TODO Auto-generated method stub
		return adminMapper.insertAccount(adminEntity);
	}
	
	
	
	

}
