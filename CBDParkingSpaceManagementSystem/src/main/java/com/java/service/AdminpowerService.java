package com.java.service;

import com.java.entity.Adminpower;

import java.util.Set;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 管理员权限关系表 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface AdminpowerService extends IService<Adminpower> {
	/**
	 *查询管理的权限
	 * @param jobnumber 管理员工号
	 * @return 权限
	 */
	Set<String> getAdminPower(String jobnumber);
	
	/**
	 * 查询用户权限
	 * @param name 用户名
	 * @return 权限
	 */
	Set<String> getUserPower(String name);
	
	/**
	 * 查询企业权限
	 * @param name 企业名
	 * @return 权限
	 */
	Set<String> getEnterprisePower(String name);
}
