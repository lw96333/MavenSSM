package com.my.service;

import java.util.List;

import com.my.bean.AdminBean;
import com.my.bean.VoteContextBean;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;
/**
 * 用户service
 * @author 罗维
 *
 * 2019年3月12日
 */
public interface IAdminService {
	/**
	 * 登录判断
	 * @param adminBean 输入内容
	 * @return 查询数据
	 */
	AdminEntity findAdminByNameAndPassword(AdminBean adminBean);
	
	/**
	 * 更新用户最后登录时间
	 * @param id 用户id
	 */
	void updateLoginTimeById(int id);
	
	/**
	 * 通过用户id查询投票信息
	 * @param id 用户id
	 * @return 投票统计
	 */
	List<VoteEntity> findVoteById(int id);
	
	/**
	 * 根据id查询所有投票信息
	 * @param id 管理员id
	 * @return 所有投票
	 */
	List<VoteEntity> findAllVoteById(int id);
	
	/**
	 * 查询一个投票
	 * @param id 投票id
	 * @return
	 */
	List<VoteContextEntity> findOneVoteContext(int id);
	
	/**
	 * 更新选项
	 * @param voteContextBean 条件
	 */
	void updateVoteContext(VoteContextBean voteContextBean);
	
	/**
	 * 增加投票
	 * @param voteContextBean
	 */
	void addVoteAndContext(VoteContextBean voteContextBean,int adminId);
	
	
	List<VoteEntity> findAllVoteByIdAndCondition(int id,String condition);
	
	/**
	 * 根据id修改密码
	 * @param id 管理员id
	 * @param pwd 密码
	 * @return
	 */
	int updateAccountPwd(int id,String pwd);
	
	/**
	 * 	增加密码
	 * @param adminEntity
	 * @return
	 */
	int insertAccount(String account, String pwd);
}
