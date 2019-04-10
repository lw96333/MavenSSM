package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.UserBean;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;


/**
 * 个人用户注册  修改 页面控制器
 * @author 郑升亮
 *
 *2019年3月25日
 */
@RestController
@Log4j
public class PersonageEnrollController {
	@Autowired
	private UserService userService;
	
	/**
	 *  个人用户注册
	 * @param userBean
	 * @return 返回数据
	 */
	@LogStatistics(operatecontent="个人用户注册",operation=logType.添加)
	@RequestMapping("insertPersonage")
	public ResponseData personageEnroll(UserBean userBean) {
		log.info("收到个人用户注册请求");
		ResponseData responseData = new ResponseData();
		EntityWrapper<User> entityWrapper = new EntityWrapper<User>();
		String password = userBean.getPassword();
		String userName = userBean.getName();
		//密码MD5加密
		String passwordMD5 = PasswordUtil.generate(userName, password);
		
			//添加用户
			User user = new User();
			String name = userBean.getName();
			entityWrapper.eq("name", name);
			User user2 = userService.selectOne(entityWrapper);
			//判断工号是否唯一
			if(user2 != null) {
				responseData.setMessage("工号已存在");
				responseData.getData().put("user2", user2);
				return responseData;
			}else {
				user.setName(name);
			}
			user.setJurisdictionid(1);
			user.setPassword(passwordMD5);
			user.setRealname(userBean.getRealname());
			user.setAddress(userBean.getAddress());
			user.setPhone(userBean.getPhone());
			user.setIdentitynumber(userBean.getIdentitynumber());
			user.setJob(userBean.getJob());
			user.setEmail(userBean.getEmail());
			user.setComplaintnumber(0);
			user.setDealnumber(0);
			userService.insert(user);
	        
		return ResponseData.ok();
	}
	
	/**
	 * 修改个人信息
	 * @param userBean 输入的修改数据
	 * @param userid 登陆用户ID
	 * @return 成功
	 */
	@LogStatistics(operatecontent="修改个人信息",operation=logType.修改)
	@RequestMapping("updataPersonage")
	public ResponseData personageAlter(UserBean userBean,HttpSession session) {
		log.info("收到修改个人信息请求");
		EntityWrapper<User> entityWrapper = new EntityWrapper<User>();
		ResponseData responseData = new ResponseData();
		//获取登陆用户的ID
		User users = (User) session.getAttribute("user");
		int userid = users.getUserid();
		String userName = users.getName();
		
		String password = userBean.getPassword();
		//密码MD5加密
		String passwordMD5 = PasswordUtil.generate(userName, password);
		
		//根据ID查询  并修改
		entityWrapper.eq("userid", userid);
		User us = userService.selectOne(entityWrapper);
		
		us.setPassword(passwordMD5);
		us.setAddress(userBean.getAddress());
		us.setPhone(userBean.getPhone());
		us.setJob(userBean.getJob());
		us.setEmail(userBean.getEmail());
		userService.update(us, entityWrapper);
		
		session.removeAttribute("user");
		session.removeAttribute("admin");
		session.removeAttribute("enterprise");
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return responseData;
	}
	/**
	 * 查询当前登陆用户个人信息
	 * @param session
	 * @return
	 */
	@RequestMapping("selectPersonage")
	public ResponseData selectPersonage(HttpSession session) {
		log.info("收到查询当前登陆用户个人信息请求");
		EntityWrapper<User> entityWrapper = new EntityWrapper<User>();
		ResponseData responseData = new ResponseData();
		//获取登陆用户的ID
		User users = (User) session.getAttribute("user");
		int userid = users.getUserid();
		
		//根据ID查询  
		entityWrapper.eq("userid", userid);
		User us = userService.selectOne(entityWrapper);
		
		responseData.getData().put("us", us);
		return responseData;
	}
}
