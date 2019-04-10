package com.java.mapper;

import com.java.entity.Adminpower;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 管理员权限关系表 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface AdminpowerMapper extends BaseMapper<Adminpower> {
	/**
	 *查询管理的权限
	 * @param jobnumber 管理员工号
	 * @return 权限
	 */
	@Select("select jur.jurisdiction from admin as admin"
			+ " left join adminpower as power on admin.adminid = power.adminid"
			+ "  left join jurisdiction as jur on power.jurisdictionid = jur.jurisdictionid" + 
			" where admin.jobnumber = #{jobnumber}")
	Set<String> getAdminPower(String jobnumber);
	
	/**
	 * 查询用户权限
	 * @param name 用户名
	 * @return 权限
	 */
	@Select("select jurisdiction from user as user "
			+ "left join jurisdiction as jur on user.jurisdictionid = jur.jurisdictionid \n" + 
			"where user.name = #{name}")
	Set<String> getUserPower(String name);
	
	/**
	 * 查询企业权限
	 * @param name 企业名
	 * @return 权限
	 */
	@Select("select jurisdiction from enterprise as ent "
			+ "left join jurisdiction as jur on ent.jurisdictionid = jur.jurisdictionid \n" + 
			"where ent.name = #{name}")
	Set<String> getEnterprisePower(String name);
}