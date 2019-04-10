package com.java.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Priority;
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
import com.java.entity.Enterprise;
import com.java.entity.User;
import com.java.service.AdminService;
import com.java.service.AdminpowerService;
import com.java.service.EnterpriseService;
import com.java.service.UserService;

import lombok.extern.log4j.Log4j;
/**
 * 用于控制前端
 * @author 罗维
 *
 * 2019年3月23日
 */
@Log4j
public class FortendRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	@Autowired
	private AdminpowerService adminpowerService;
	
	private final int NUM = 2;
	
	private final String TYPE_0 = "0";
	
	private final String TYPE_1 = "1";
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		
			
			String userName = (String) arg0.getPrimaryPrincipal();
			log.info("进入个人授权");
			log.info("用户名"+userName);
			String[] strs = userName.split(",");
			if(strs.length == NUM) {
				Set<String> powers = null;
				Set<String> roles = new HashSet<String>();
				//从数据库中获取数据
				if(TYPE_0.equals(strs[0])) {
					log.info("个人权限查询");
					powers = adminpowerService.getUserPower(strs[1]);
				}else if(TYPE_1.equals(strs[0])){
					log.info("企业权限查询");
					powers = adminpowerService.getEnterprisePower(strs[1]);
				}
				for(String str : powers) {
					roles.add(str.split(":")[0]);
				}
				
				SimpleAuthorizationInfo simpleAuthorizationInfo = 
						new SimpleAuthorizationInfo();
				simpleAuthorizationInfo.setRoles(roles);
				simpleAuthorizationInfo.setStringPermissions(powers);
				return simpleAuthorizationInfo;
			}	
		
		return null;
		
	}
	
	/**
	 * 验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		log.info("进入前台验证！");
		//1.从主体传过来的认证信息中，获得用户名
		String name = (String) arg0.getPrincipal();
		log.info("验证用户名："+name);
		//2.通过用户名到数据库中获取凭证
		String password = this.getPasswordByUserName(name);
		if(password == null) {
			return null;
		}
		log.info("前台查询密码"+password);
		SimpleAuthenticationInfo authenticationInfo =
				new SimpleAuthenticationInfo(name, password,getName());
		
		return authenticationInfo;
	}
	/**
	 * 数据库访问
	 * @param userName
	 * @return
	 */
	private String getPasswordByUserName(String userName) {
		String[] strs = userName.split(",");
		String password = null;
		if(TYPE_0.equals(strs[0])) {
			User user = userService.selectOne(
					new EntityWrapper<User>().eq("name", strs[1]));
			if(user!=null) {
				password = user.getPassword();
			}
			
		}else if(TYPE_1.equals(strs[0])){
			Enterprise enterprise = enterpriseService.selectOne(
					new EntityWrapper<Enterprise>().eq("name", strs[1]));
			if(enterprise != null) {
				password = enterprise.getPassword();
			}
			

		}
		
		
		return password;
	}
}
