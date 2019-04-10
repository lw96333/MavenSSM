package com.java.mapper;

import com.java.entity.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 个人用户 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface UserMapper extends BaseMapper<User> {
	/**
	 * 根据用户ID查询用户真实姓名
	 * @param userId 用户ID
	 * @return
	 */
	@Select(value="SELECT realname FROM `user` WHERE userid = ${userId} ")
	String getUserNameById(@Param(value="userId")int userId);

}