package com.java.service.impl;

import com.java.entity.Adminpower;
import com.java.mapper.AdminMapper;
import com.java.mapper.AdminpowerMapper;
import com.java.service.AdminpowerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员权限关系表 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class AdminpowerServiceImpl extends ServiceImpl<AdminpowerMapper, Adminpower> implements AdminpowerService {

	@Autowired
	private AdminpowerMapper adminMapper;
	
	@Override
	public Set<String> getAdminPower(String jobnumber) {
		// TODO Auto-generated method stub
		return adminMapper.getAdminPower(jobnumber);
	}

	@Override
	public Set<String> getUserPower(String name) {
		// TODO Auto-generated method stub
		return adminMapper.getUserPower(name);
	}

	@Override
	public Set<String> getEnterprisePower(String name) {
		// TODO Auto-generated method stub
		return adminMapper.getEnterprisePower(name);
	}
	
}
