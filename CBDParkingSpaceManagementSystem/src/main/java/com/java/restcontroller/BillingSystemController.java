package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.AdminBillingBean;
import com.java.entity.Admin;
import com.java.entity.Adminbilling;
import com.java.service.AdminbillingService;
import com.java.util.ResponseData;

import lombok.extern.log4j.Log4j;

/**
 * 超级管理计费页面控制器
 * @author 温家强
 *
 * 2019年3月21日
 */
@RestController
@Log4j
public class BillingSystemController {
	
	@Autowired
	private AdminbillingService adminBillingService;
	
	/**
	 * 显示超级管理员计费信息分页、日期查询
	 * @param adminBillingBean 超级管理员Bean
	 * @return 分页显示数据
	 */
	@RequestMapping("showSuperAdminBilling")
	public ResponseData showSuperAdminBilling(AdminBillingBean adminBillingBean,int pageNum,int pageSize) {
		log.info(adminBillingBean.getEndTime()+" 00:00:00");
		Page<Adminbilling> pageBillings =  new Page<Adminbilling>(pageNum,pageSize);
		
		EntityWrapper<Adminbilling> entityWrapper = new EntityWrapper<Adminbilling>();
		
		if (!("".equals(adminBillingBean.getStartTime()) || adminBillingBean.getStartTime() == null)) {
			
			entityWrapper.ge("endtime", adminBillingBean.getStartTime() + " 00:00:00");
		}
		if (!("".equals(adminBillingBean.getEndTime()) || adminBillingBean.getEndTime() == null)) {
			
			
			entityWrapper.le("endtime", adminBillingBean.getEndTime() + " 00:00:00");
		}
		
		Page billingPages = adminBillingService.selectPage(pageBillings,entityWrapper.orderBy("adminbillingid"));
		log.info(billingPages);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", billingPages);
		responseData.getData().put("startTime", adminBillingBean.getStartTime());
		responseData.getData().put("endTime", adminBillingBean.getEndTime());
		return responseData;
		
	}
	
	/**
	 * 显示超级管理员账单合计
	 * @param adminbilling 超级管理员实体类
	 * @return 账单合计数据
	 */
	@RequestMapping("countSuperAdminBilling")
	public ResponseData countSuperAdminBilling(HttpSession session) {
		
		Adminbilling adminbilling = new Adminbilling();
		Admin adminId = (Admin) session.getAttribute("admin");
		adminbilling.setAdminid(adminId.getAdminid());
		
		Integer countDealSum = adminBillingService.countDealSum(adminbilling);
		Double countIncomeSum = adminBillingService.countIncomeSum(adminbilling);
		Double countExpendSum = adminBillingService.countExpendSum(adminbilling);
		
		ResponseData responseData = new ResponseData();
		responseData.getData().put("countDealSum", countDealSum);
		responseData.getData().put("countIncomeSum", countIncomeSum);
		responseData.getData().put("countExpendSum", countExpendSum);
		
		return responseData;
	}
	
}
