package com.my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.bean.AdminBean;
import com.my.entity.AdminEntity;
import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;

/**
 * 用户数据库查询
 * @author 罗维
 *
 * 2019年3月12日
 */
public interface AdminMapper extends SqlMapper{

	@Select("select * from admin where name=#{name} and password = #{password}")
	AdminEntity findAdminByNameAndPassword(AdminBean adminBean);
	
	@Update("update admin set logintime=#{date} where admin_id=#{id}")
	int updateLoginTimeById(@Param("date")String date,@Param("id")int id);
	
	@Select("select type,count(type) as typeNum from vote where admin_id=#{id} group by type")
	List<VoteEntity> findVoteById(@Param("id")int id);
	
	@Select("select v.*,a.name as adminName from vote as v left join admin as a on v.admin_id = a.admin_id where v.admin_id=#{id}")
	List<VoteEntity> findAllVoteById(@Param("id")int id);
	
	@Select("select vc.*,v.title as voteName,v.type as voteType,v.publish as votePublish from voteContext as vc left join vote as v on vc.vote_id = v.vote_id where vc.vote_id=#{id}")
	List<VoteContextEntity> findOneVoteContext(@Param("id")int id);
	
	@Update("update vote set type = #{type}, publish = #{publish} where vote_id = #{id}")
	int updateVote(@Param("type")int type,@Param("publish")int publish,@Param("id")int id);
	
	@Insert("<script>"  +
            "INSERT INTO votecontext VALUES" +
            "<foreach collection=\"list\" item=\"item1\" index=\"index\"  separator=\",\">" +
            "(null,#{item1.context},#{item1.count},#{item1.vote_id})" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("list")List<VoteContextEntity> menus);
	
	
	@Delete("<script>"  +
            "delete from votecontext where votecontext_id in(" +
            "<foreach collection=\"array\" item=\"item1\" index=\"index\"  separator=\",\">" +
            "#{item1}" +
            "</foreach>" +
            ")</script>")
	int batchDelete(@Param("array")int[] array);
	
	@Insert("insert into vote values(null,#{title},#{createdate},#{type},#{publish},#{adminId})")
	int insertVote(VoteEntity voteEntity);
	
	@Select("select vote_id from vote where createdate = #{date}")
	int selectVoteIDByDate(@Param("date")String date);
	
	@Select("select v.*,a.name as adminName from vote as v left join admin as a on v.admin_id = a.admin_id where v.admin_id=#{id} and v.title like concat(#{condition},'%')")
	List<VoteEntity> findAllVoteByIdAndCondition(@Param("id")int id,@Param("condition")String condition);
	
	@Update("update admin set password = #{pwd} where admin_id = #{id}")
	int updateAccountPwd(@Param("id")int id,@Param("pwd")String pwd);
	
	@Insert("insert into admin values(null,#{name},#{password},#{logintime})")
	int insertAccount(AdminEntity adminEntity);
}
