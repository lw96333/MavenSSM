package com.my.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.my.entity.UserEntity;

/**
 * 用户映射接口
 * @author 罗维
 *
 * 2019年3月11日
 */
public interface UserMapper extends SqlMapper{
	/**
	 * 查询用户
	 * @param name 用户名
	 * @param password 密码
	 * @return 用户实体
	 */
	@Select("select * from t_user where name = #{name} and password = #{password}")
	UserEntity getUserByNameAndPassword(@Param("name")String name,@Param("password")String password);
	/**
	 * 插入用户
	 * @param name
	 * @param password
	 * @return
	 */
	@Insert("insert into t_user values(null,#{name},#{password},null,null)")
	int insertUser(@Param("name")String name,@Param("password")String password);
}
