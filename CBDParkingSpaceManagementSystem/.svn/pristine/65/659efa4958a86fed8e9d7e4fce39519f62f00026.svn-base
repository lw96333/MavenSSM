package com.java.shiro;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.entity.Admin;
import com.java.entity.Enterprise;
import com.java.entity.Examine;
import com.java.entity.User;
import com.java.service.AdminService;
import com.java.service.EnterpriseService;
import com.java.service.ExamineService;
import com.java.service.UserService;

import lombok.extern.log4j.Log4j;
/**
 * 判断用户是否用remeberme登录
 * @author 罗维
 *
 * 2019年3月27日
 */
@Component
@Log4j
public class LoginInterceptor implements HandlerInterceptor{

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	private static final String ADMIN = "admin";
	
	private static final String USER = "user";
	
	private static final String ONE = "1";
	
	private static final String ZEAR = "0";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("进入LoginInterceptor拦截器");
		Subject currentUser = null;
		try {
			 currentUser = SecurityUtils.getSubject();  			
		}catch (Exception e) {
			// TODO: handle exception
			log.info("拦截器报错");
		}
			try {
				if(!currentUser.isAuthenticated() && currentUser.isRemembered()){  
					
					log.info(currentUser.getPrincipals().toString());
					if(currentUser.hasRole(ADMIN)){
						log.info("是管理员");
						Admin admin = adminService.selectOne(
								new EntityWrapper<Admin>()
								.eq("jobnumber", currentUser.getPrincipals().toString()));
						log.info("admin"+admin);

						request.getSession().setAttribute("admin", admin);
						 
						 log.info("验证完成");
					}else if(currentUser.hasRole(USER)) {
						log.info("是个人用户");
						String[] strs = currentUser.getPrincipals().toString().split(",");
		
						String password = "";
						if(ZEAR.equals(strs[0])) {
							User user = userService.selectOne(
									new EntityWrapper<User>()
									.eq("name", strs[1]));

							password = user.getPassword();
							request.getSession().setAttribute("user", user);
							log.info("user"+user);
						}else if(ONE.equals(strs[0])){
							log.info("是企业用户");
							Enterprise examine = enterpriseService.selectOne(
									new EntityWrapper<Enterprise>()
									.eq("name",strs[1]));
							password = examine.getPassword();
							request.getSession().setAttribute("examine", examine);
							log.info("examine"+examine);
						}

					}
					  
					 
				}
			}catch (Exception e){  
                //自动登录失败,跳转到登录页面  
               //e.printStackTrace();
               
            } 
			
        log.info("退出LoginInterceptor");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
