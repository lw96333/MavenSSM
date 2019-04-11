package com.my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.entity.VoteContextEntity;
import com.my.entity.VoteEntity;

public interface ViewMapper extends SqlMapper{

	@Select("select * from vote where publish = 1")
	List<VoteEntity> selectAllPubVote();
	
	
	@Update("update votecontext set count = count + 1 where votecontext_id = #{id};")
	int updateVoteContext(@Param("id")int id);
}
