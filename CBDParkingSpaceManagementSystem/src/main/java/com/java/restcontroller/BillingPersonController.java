package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.UserBillingBean;
import com.java.entity.User;
import com.java.entity.Userbilling;
import com.java.service.UserbillingService;
import com.java.util.ResponseData;

import lombok.extern.log4j.Log4j;

/**
 * 个人用户计费页面控制器
 * @author 温家强
 *
 * 2019年3月21日
 */
@RestController
@Log4j
public class BillingPersonController {
	
	@Autowired
	private UserbillingService userBillingService;
	
	/**
	 * 显示个人用户计费信息分页、日期查询
	 * @param userBillingBean 个人用户Bean
	 * @return 分页显示数据
	 */
	@RequestMapping("showPersonBilling")
	public ResponseData showPersonBilling(UserBillingBean userBillingBean,int pageNum,int pageSize,HttpSession session) {
		
		Page<Userbilling> pageBillings =  new Page<Userbilling>(pageNum, pageSize);
		EntityWrapper<Userbilling> entityWrapper = new EntityWrapper<Userbilling>();
		
		User userId = (User) session.getAttribute("user");
		log.info(userId);
		
		if (!("".equals(userBillingBean.getStartTime()) || userBillingBean.getStartTime() == null)) {
			entityWrapper.ge("endtime", userBillingBean.getStartTime() + " 00:00:00");
		}
		if (!("".equals(userBillingBean.getEndTime()) || userBillingBean.getEndTime() == null)) {
			entityWrapper.le("endtime", userBillingBean.getEndTime() + " 00:00:00");
		}
		Page billingPages = userBillingService.selectPage(pageBillings,entityWrapper.eq("userid", userId.getUserid()).orderBy("userbillingid"));
		log.info(billingPages);
		log.info(userBillingBean.getEndTime());
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", billingPages);
		
		return responseData;
		
	}
	
	/**
	 * 显示个人用户账单合计
	 * @param userbilling 个人用户实体类
	 * @return 账单合计数据
	 */
	@RequestMapping("countPersonBilling")
	public ResponseData countPersonBilling(HttpSession session) {
		
		Userbilling userBilling = new Userbilling();
		User userId = (User) session.getAttribute("user");
		userBilling.setUserid(userId.getUserid());
		
		Integer countDealSum = userBillingService.countDealSum(userBilling);
		Double countIncomeSum = userBillingService.countIncomeSum(userBilling);
		Double countExpendSum = userBillingService.countExpendSum(userBilling);
		
		ResponseData responseData = new ResponseData();
		responseData.getData().put("countDealSum", countDealSum);
		responseData.getData().put("countIncomeSum", countIncomeSum);
		responseData.getData().put("countExpendSum", countExpendSum);
		
		return responseData;
	}
	
}
