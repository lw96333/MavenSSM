package com.java.restcontroller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.entity.Admin;
import com.java.entity.Enterprise;
import com.java.entity.User;
import com.java.service.AdminService;
import com.java.service.EnterpriseService;
import com.java.service.UserService;
import com.java.shiro.CustomizedToken;
import com.java.shiro.LoginType;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 登录验证
 * @author 罗维
 *
 * 2019年3月23日
 */
@RestController
@Log4j
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	private static final String BACK_LOGIN_TYPE = LoginType.BACKSTAGE.toString();
	
	private static final String FORTEND_LOGIN_TYPE = LoginType.FORTEND.toString();
	
	private final String TYPE_0 = "0";
	
	private final String TYPE_1 = "1";
	/**
	 * 登录
	 * @param userName 用户名
	 * @param password 密码
	 * @return 返回结果
	 */
	@LogStatistics(operatecontent="后台登录",operation=logType.登录)
	@RequestMapping("backLogin")
	public ResponseData backLogin(
			String jobnumber,
			String password,
			boolean remeberMe,
			HttpSession session
			) {
		ResponseData responseData = new ResponseData();
		log.info("接收到backLogin请求");
		log.info("参数jobnumber："+jobnumber);
		log.info("参数password："+password);
		log.info("参数remeberMe："+remeberMe);
		log.info("加密密码"+PasswordUtil.generate(jobnumber, password));
		String passwordStr = PasswordUtil.generate(jobnumber, password);
		Subject currentUser = SecurityUtils.getSubject();
		CustomizedToken token = new CustomizedToken(
				jobnumber,passwordStr ,BACK_LOGIN_TYPE);
		if(remeberMe) {
			token.setRememberMe(true);			
		}

		try {
			currentUser.login(token);	
			
			
        } catch (IncorrectCredentialsException ice) {
        	responseData.setCode(5);
        	responseData.setMessage("账号/密码不匹配！");
        	log.info("账号/密码不匹配！");
           return responseData;
        } catch (LockedAccountException lae) {
        	
        	responseData.setCode(4);
        	responseData.setMessage("账号冻结");
        	log.info("账号冻结");
           return responseData;
        } catch (AuthenticationException ae) {
        	
        	responseData.setCode(3);
        	responseData.setMessage("账号不存在");
        	log.info( "账号不存在");
           return responseData;
        }
		
		Admin admin = adminService.selectOne(new EntityWrapper<Admin>().eq("jobnumber", jobnumber));


		log.info("admin:"+admin);
		log.info("添加admin");
		log.info("返回成功");
		session.setAttribute("admin", admin);
		return responseData;
	}
	/**
	 * 前端登录
	 * @param userName 用户名
	 * @param password 密码
	 * @param type 类型
	 * @param session session
	 * @return 信息
	 */
	@LogStatistics(operatecontent="前台登录",operation=logType.登录)
	@RequestMapping("fortendLogin")
	public ResponseData fortendLogin(
			String userName,
			String password,
			String type,
			boolean remeberMe,
			HttpSession session
			) {
		ResponseData responseData = new ResponseData();
		log.info("收到fortendLogin请求，前台登录");
		log.info("账号："+userName);
		log.info("密码："+password);
		log.info("登录类型"+type);
		log.info("remeberMe"+remeberMe);
		String passwordStr = PasswordUtil.generate(userName,password);
		Subject currentUser = SecurityUtils.getSubject();
		CustomizedToken token = new CustomizedToken(
				type+","+userName,passwordStr ,FORTEND_LOGIN_TYPE);
			log.info(type+","+userName);
			log.info(PasswordUtil.generate(userName,password));
			token.setRememberMe(remeberMe);
		
		
		try {
			currentUser.login(token);	
			
			
        } catch (IncorrectCredentialsException ice) {
        	
        	responseData.setCode(5);
        	responseData.setMessage("账号/密码不匹配！");
        	log.info("账号/密码不匹配！");
           return responseData;
        } catch (LockedAccountException lae) {
        	
        	responseData.setCode(4);
        	responseData.setMessage("账号冻结");
        	log.info("账号冻结");
           return responseData;
        } catch (AuthenticationException ae) {
        	ae.printStackTrace();
        	responseData.setCode(3);
        	responseData.setMessage("账号不存在");
        	log.info("账号不存在");
           return responseData;
        }
		log.info("登录成功");
		if(TYPE_0.equals(type)) {
			User user = userService.selectOne(
					new EntityWrapper<User>()
					.eq("name", userName)
					.eq("password", passwordStr));
//			currentUser.getSession().setAttribute("user", user);
			session.setAttribute("user", user);
			log.info("session中加入user");
			System.out.println(session.getAttribute("user"));
		}else if(TYPE_1.equals(type)) {
			Enterprise enterprise = enterpriseService.selectOne(
					new EntityWrapper<Enterprise>()
					.eq("name", userName)
					.eq("password", passwordStr));
			session.setAttribute("enterprise", enterprise);
			log.info("session中加入enterprise");
		}
		
		return responseData;
	}
	@RequestMapping("login")
	public ResponseData login(HttpSession session) {
		ResponseData responseData = new ResponseData();
		Admin admin = (Admin) session.getAttribute("admin");
		User user = (User)session.getAttribute("user");
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		if(admin != null) {
			responseData.getData().put("admin", admin);
		}
		if(user != null) {
			responseData.getData().put("anyOne", user);
		}
		if(enterprise != null) {
			responseData.getData().put("anyOne", enterprise);
		}
		return responseData;
	}
	
	@RequestMapping("loginOut")
	public ResponseData loginOut(HttpSession session) {
		ResponseData responseData = new ResponseData();
		session.removeAttribute("user");
		session.removeAttribute("admin");
		session.removeAttribute("enterprise");
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return responseData;
		
	}
}
