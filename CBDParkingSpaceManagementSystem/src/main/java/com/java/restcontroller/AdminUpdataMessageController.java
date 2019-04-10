package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.AdminBean;
import com.java.entity.Admin;
import com.java.service.AdminService;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 后台管理员信息修改
 * @author 郑升亮
 *
 *2019年3月27日
 */
@RestController
@Log4j
public class AdminUpdataMessageController {

	@Autowired
	private AdminService adminService;
	/**
	 * 修改后台管理员信息
	 * @param adminBean 获取修改内容
	 * @param session 获取当前登陆id
	 * @return 返回成功
	 */
	@LogStatistics(operatecontent="修改后台管理员信息",operation=logType.修改)
	@RequestMapping("adminUpdata")
	public ResponseData adminUpdata(AdminBean adminBean,HttpSession session) {
		log.info("收到修改后台管理员信息请求");
		EntityWrapper<Admin> entityWrapper = new EntityWrapper<Admin>();
		
		//获取登陆admin用户的ID
		Admin admins =  (Admin) session.getAttribute("admin");
		int adminid = admins.getAdminid();
		String userName = admins.getJobnumber();
		
		String password = adminBean.getPassword();
		
		//密码MD5加密 
		String passwordMD5 = PasswordUtil.generate(userName, password);
		
		//根据ID查询 并修改
		entityWrapper.eq("adminid", adminid);
		Admin admin = adminService.selectOne(entityWrapper);
		admin.setPassword(passwordMD5);
		log.info("电话："+adminBean.getPhone());
		admin.setPhone(adminBean.getPhone());
		adminService.update(admin, entityWrapper);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return ResponseData.ok();
	}
	/**
	 * 查询当前登陆管理员个人信息
	 * @param session
	 * @return
	 */
	@RequestMapping("selectAdmins")
	public ResponseData selectAdmin(HttpSession session) {
		log.info("收到查询当前登陆管理员个人信息请求");
		EntityWrapper<Admin> entityWrapper = new EntityWrapper<Admin>();
		//获取登陆admin用户的ID
		Admin admins =  (Admin) session.getAttribute("admin");
		int adminid = admins.getAdminid();
		
		entityWrapper.eq("adminid", adminid);
		Admin admin = adminService.selectOne(entityWrapper);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("us", admin);
		
		return responseData;
	}
}
