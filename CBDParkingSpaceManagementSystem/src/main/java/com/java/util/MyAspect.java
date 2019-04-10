package com.java.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.java.entity.Admin;
import com.java.entity.Enterprise;
import com.java.entity.Log;
import com.java.entity.User;
import com.java.service.LogService;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 日志切面类
 * 
 * @author 张冀川
 *
 *         2019年3月27日
 */
@Aspect
@Component
public class MyAspect {
	@Autowired
	private LogService logService;
	static final String OPERATE = "操作";
	static final String LOGIN = "登录";
	
	static final String FORWARD = "前台";
	static final String BACK = "后台";
	
	static final String ADD = "添加";
	static final String DELETE = "删除";
	static final String UPDATE = "修改";
	
	
	static final String PERSONAL = "个人";
	static final String COMPANY = "企业";
	
	static final String PERSONUSER = "个人用户";
	static final String COMPANYUSER = "企业用户";
	static final String BACKUSER = "后台管理员";
	static final String SUPERADMIN = "超级管理员";
	static final String LOGINSYSTEM = "登录系统";
	

	/**
	 * 后置通知记录日志通过注解匹配到需要增加日志功能的方法
	 * 
	 * @param jp
	 * @throws Throwable
	 */
	@After("execution(* com.java.restcontroller.*.*(..))")
	public void afterAdvice(JoinPoint jp) throws Throwable {
		// 1.方法执行前的处理，相当于前置通知
		// 获取方法签名
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		// 获取方法
		Method method = methodSignature.getMethod();
		// 获取方法上面的注解
		LogStatistics logAnno = method.getAnnotation(LogStatistics.class);
		// 创建一个日志对象(准备记录日志)
		Log logEntity = new Log();

        if(logAnno!=null) {
        	
			// 获取RequestAttributes
			RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
			// 从获取RequestAttributes中获取HttpServletRequest的信息
			HttpServletRequest request = (HttpServletRequest) requestAttributes
					.resolveReference(RequestAttributes.REFERENCE_REQUEST);
			HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION); 
			// 何地（获取ip地址）
			String ip = request.getLocalAddr();
			// 操作ip
			logEntity.setIp(ip);
        	
			Admin admin = (Admin) session.getAttribute("admin");
			User user = (User) session.getAttribute("user");
			Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
			
			
			if(admin!=null||
					user!=null||
							enterprise!=null){
				//记录日志类型（前台后台）（人员名字）
				if(admin!=null){
					logEntity.setRank(BACK);
					logEntity.setName(admin.getName());
				}else if(user!=null){
					logEntity.setRank(FORWARD);
					logEntity.setName(user.getName());
				}else if(enterprise!=null){
					logEntity.setRank(FORWARD);
					logEntity.setName(enterprise.getName());
				}
				// 获取操作描述的属性值(得到操作名称（通过名称判断是操作还是登录）(将枚举类型数组里的值转为String类型))
				String operation=logAnno.operation()[0].toString();
	        	//记录日志的操作类型 操作还是登陆
		        if(ADD.equals(operation.trim())) {
		        	logEntity.setOperation(OPERATE); 
		        }
		        if(DELETE.equals(operation.trim())) {
		        	logEntity.setOperation(OPERATE); 
		        }
		        if(UPDATE.equals(operation.trim())) {
		        	logEntity.setOperation(OPERATE); 
		        }
		        if(LOGIN.equals(operation.trim())){
		        	logEntity.setOperation(LOGIN); 
		        	
		        }
		        
		        //日志内容
		        String operatecontent = logAnno.operatecontent();
		        //记录操作内容（如添加了一条投诉信息）
		        logEntity.setOperatecontent(operatecontent);

				// 记录操作日期
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(System.currentTimeMillis());
				logEntity.setOperatetime(time);
				logService.insert(logEntity);
			}
			
        }

	}
	
	
}
