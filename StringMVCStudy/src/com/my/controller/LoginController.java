package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 登录页面控制器
 * @author 49160
 *
 */
public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//创建ModelAndView实例
		ModelAndView modelAndView = new ModelAndView();
		//添加模型数据（等价于request.setAttribute）
		modelAndView.addObject("name", name);
		//设置逻辑视图名
		modelAndView.setViewName("LoginOk");
		
		
		return modelAndView;
	}

}
