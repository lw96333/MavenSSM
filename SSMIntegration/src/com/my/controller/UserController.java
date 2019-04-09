package com.my.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.bean.UserBean;
import com.my.service.IUserService;

/**
 * 用户页面控制器
 * @author 罗维
 *
 * 2019年3月11日
 */
@Controller

public class UserController {
	
	/**
	 * 获取日志记录器
	 */
	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	@RequestMapping("login")
	public String userLogin(UserBean userBean) {
		logger.log(Priority.DEBUG, "收到login请求");
		logger.log(Priority.DEBUG, userBean);
//		if(userService.login(userBean.getName(), userBean.getPassword())) {
			return "LoginOk";			
//		}
//		return "login";
	}
}
