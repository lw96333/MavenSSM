package com.my.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.bean.AdminBean;
import com.my.bean.VoteContextBean;
import com.my.dao.IAdminDao;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;

/**
 * 管理员服务层
 * 
 * @author 罗维
 *
 *         2019年3月11日
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao adminDao;

	@Override
	public AdminEntity findAdminByNameAndPassword(AdminBean adminBean) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = adminDao.findAdminByNameAndPassword(adminBean);

		return adminEntity;
	}

	@Override
	public void updateLoginTimeById(int id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adminDao.updateLoginTimeById(sdf.format(new Date()), id);

	}

	@Override
	public List<VoteEntity> findVoteById(int id) {
		// TODO Auto-generated method stub
		return adminDao.findVoteById(id);
	}

	@Override
	public List<VoteEntity> findAllVoteById(int id) {
		// TODO Auto-generated method stub
		return adminDao.findAllVoteById(id);
	}

	@Override
	public List<VoteContextEntity> findOneVoteContext(int id) {
		// TODO Auto-generated method stub
		return adminDao.findOneVoteContext(id);
	}

	@Override
	public void updateVoteContext(VoteContextBean voteContextBean) {
		// TODO Auto-generated method stub

		if (voteContextBean.isFalg()) {
			adminDao.updateVote(
					voteContextBean.getSin(),
					voteContextBean.getPub(),
					voteContextBean.getId());
		}
		String str = voteContextBean.getRemoveId();

		if (!"".equals(str)) {
			str = str.replaceAll("\"", "");
			str = str.replace("[", "");
			str = str.replace("]", "");
			String[] strs = str.split(",");
			int[] ints = new int[strs.length];
		    for(int i=0;i<strs.length;i++){
		        ints[i] = Integer.parseInt(strs[i]);
		    }
			adminDao.batchDelete(ints);
		}
		System.out.println(voteContextBean.getContexts());
		if (voteContextBean.getContexts() != "") {
			String[] contexts = voteContextBean.getContexts().split("\\^");
			List<VoteContextEntity> li = new ArrayList<VoteContextEntity>();
			for(int index = 0;index < contexts.length; index++) {
				VoteContextEntity voteContextEntity = new VoteContextEntity();
				voteContextEntity.setContext(contexts[index]);
				voteContextEntity.setCount(0);
				voteContextEntity.setVote_id(voteContextBean.getId());
				li.add(voteContextEntity);
			}
			adminDao.batchInsert(li);
		}

	}

	@Override
	public void addVoteAndContext(VoteContextBean voteContextBean,int adminId) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		VoteEntity voteEntity = new VoteEntity();
		voteEntity.setTitle(voteContextBean.getTitle());
		voteEntity.setType(voteContextBean.getSin());
		voteEntity.setCreatedate(date);
		voteEntity.setPublish(voteContextBean.getPub());
		voteEntity.setAdminId(adminId);
		adminDao.insertVote(voteEntity);
		int id = adminDao.selectVoteIDByDate(date);
		String[] contexts = voteContextBean.getContexts().split("\\^");
		List<VoteContextEntity> li = new ArrayList<VoteContextEntity>();
		for(int index = 0;index < contexts.length; index++) {
			VoteContextEntity voteContextEntity = new VoteContextEntity();
			voteContextEntity.setContext(contexts[index]);
			voteContextEntity.setCount(0);
			voteContextEntity.setVote_id(id);
			li.add(voteContextEntity);
		}
		adminDao.batchInsert(li);
		
	}

	@Override
	public List<VoteEntity> findAllVoteByIdAndCondition(int id, String condition) {
		// TODO Auto-generated method stub
		
		return adminDao.findAllVoteByIdAndCondition(id, condition);
	}

	@Override
	public int updateAccountPwd(int id, String pwd) {
		// TODO Auto-generated method stub
		return adminDao.updateAccountPwd(id, pwd);
	}

	@Override
	public int insertAccount(String account, String pwd) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setName(account);
		adminEntity.setPassword(pwd);
		adminEntity.setLogintime(date);
		return adminDao.insertAccount(adminEntity);
	}

	
	
	

}
