package com.my.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.bean.UserBean;
import com.my.service.IUserService;
import com.my.util.ResponseData;
/**
 * 注册页面控制器（支持restful风格）
 * @author 罗维
 *
 * 2019年3月12日
 */
@RestController//等价于Controller + @ResponeBody
public class RegisterController {

	@Autowired
	private IUserService userService;
	

	
	//封装restfulapi
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ResponseData register(UserBean user) {
		System.out.println("===========");
		userService.register(user.getName(), user.getPassword());
		
		return ResponseData.ok();
	}
	
}
