package com.java.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.entity.Admin;
import com.java.service.AdminService;
import com.java.service.AdminpowerService;

import lombok.extern.log4j.Log4j;
/**
 * 用户控制后端验证
 * @author 罗维
 *
 * 2019年3月23日
 */
@Log4j
public class BackstageRealm extends AuthorizingRealm{

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminpowerService adminpowerService;
	
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub

			log.info("收到授权请求");
			String userName = (String) arg0.getPrimaryPrincipal();
			log.info("授权用户名"+userName);
			//从数据或缓存中获取数据
			Set<String> powers = adminpowerService.getAdminPower(userName);
			Set<String> roles = new HashSet<String>();
			for(String str : powers) {
				roles.add(str.split(":")[0]);
			}
			
			SimpleAuthorizationInfo simpleAuthorizationInfo = 
					new SimpleAuthorizationInfo();
			simpleAuthorizationInfo.setRoles(roles);
			simpleAuthorizationInfo.setStringPermissions(powers);
			
			return simpleAuthorizationInfo;
			
	
	}
	
	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		log.info("后台验证");
		//1.从主体传过来的认证信息中，获得用户名
		String jobnumber = (String) arg0.getPrincipal();
		log.info("工号:"+jobnumber);
		//2.通过用户名到数据库中获取凭证
		Admin password = this.getPasswordByUserName(jobnumber);
		if(password == null) {
			return null;
		}
		log.info("查询密码"+password.getPassword());
		SimpleAuthenticationInfo authenticationInfo =
				new SimpleAuthenticationInfo(jobnumber, password.getPassword(),getName());
		
		return authenticationInfo;
	}
	/**
	 * 数据库访问
	 * @param userName
	 * @return
	 */
	private Admin getPasswordByUserName(String userName) {
		Admin admin = adminService.selectOne(new EntityWrapper<Admin>().eq("jobnumber", userName));
		
		return admin;
	}
}
