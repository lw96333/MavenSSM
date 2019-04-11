package com.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.bean.AdminBean;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;
/**
 * 用户Dao
 * @author 罗维
 *
 * 2019年3月12日
 */
public interface IAdminDao {
	/**
	 * 查询用户登录是否正确
	 * @param adminBean 输入类容
	 * @return 查询用户
	 */
	AdminEntity findAdminByNameAndPassword(AdminBean adminBean);
	/**
	 * 更新最后登录时间
	 * @param date 最后登录实时间
	 * @param id 用户id
	 * @return
	 */
	int updateLoginTimeById(String date,int id);
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
	 * 更新投票
	 * @param type 类型
	 * @param publish 是否公开
	 * @param id 投票id
	 * @return 改变行数
	 */
	int updateVote(@Param("type")int type,@Param("publish")int publish,@Param("id")int id);
	
	/**
	 * 批量新增投票选项
	 * @param menus 投票选项
	 * @return 影响航速
	 */
	int batchInsert(List<VoteContextEntity> menus);
	
	/**
	 * 批量删除
	 * @param array
	 * @return
	 */
	int batchDelete(@Param("array")int[] array);
	/**
	 * 添加投票信息
	 * @param voteEntity
	 * @return
	 */
	int insertVote(VoteEntity voteEntity);
	
	/**
	 * 通过时间查询id
	 * @param date
	 * @return
	 */
	int selectVoteIDByDate(@Param("date")String date);
	/**
	 * 根据id和标题查询
	 * @param id
	 * @param condition
	 * @return
	 */
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
	int insertAccount(AdminEntity adminEntity);
}
