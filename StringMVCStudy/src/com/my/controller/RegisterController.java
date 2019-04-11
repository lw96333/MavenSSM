package com.my.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.my.javabean.UserBean;

/**
 * 	注册页面控制器，数据绑定
 * @author 49160
 *
 */
//声明该类为页面控制器
@Controller
//将modelMap中的模型数据存放到session
@SessionAttributes("phone")
public class RegisterController {
	//映射url地址
	@RequestMapping("register")
	//返回值只能为String
	public String register(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		System.out.println("ok");
		//获取请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		request.setAttribute("name", name);
		//如何没有返回值，逻辑视图名默认为url地址，契约配置
		return "RegisterOK";//本质上式请求转发
	}
	
	//获取请求参数的绑定方式1
	@RequestMapping("register2")
	public String registerTwo(
				//用于绑定请求参数，value对应空间参数名
				@RequestParam(value="name")String name,
				@RequestParam(value="password")String pwd,
				@RequestParam(value="email")String email,
				ModelMap modelMap//用于添加模型数据
			) {
		
		System.out.println(name+" "+pwd+" "+email);
		//等价于request.setAttribute("xx",xx);
		modelMap.addAttribute("name", name);
		return "RegisterOK";
	}
	//获取请求参数的绑定方式2
	//参数会自动放到request中,名字为类名的首字母小写
	//如果参数比较少（1-3个）推荐用方式1，如果参数多用方式2
	@RequestMapping("register3")
	public String registerThree(UserBean user) {
		System.out.println(user.getName()+" "+user.getPassword()+" "+user.getEmail());

		return "RegisterOK";
	}
	
	
	@RequestMapping("register4")
	public String registerFour(UserBean user,ModelMap modelMap,SessionStatus sessionStatus) {
		if(modelMap.get("phone") == null) {
			modelMap.addAttribute("phone", "13812312312");
		} else {
			modelMap.remove("phone");
			sessionStatus.setComplete();//清空session所有模型数据
		}
		
		return "RegisterOK";
	}

}
