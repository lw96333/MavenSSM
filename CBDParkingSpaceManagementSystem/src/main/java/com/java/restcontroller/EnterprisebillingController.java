package com.java.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.EnterprisebillingBean;
import com.java.entity.Enterprise;
import com.java.entity.Enterprisebilling;
import com.java.service.EnterprisebillingService;
import com.java.util.ResponseData;

import lombok.extern.log4j.Log4j;


/**
 * 企业计费页面控制器
 * @author 汪雨晴
 *
 * 2019年3月21日
 */
@RestController
@Log4j
public class EnterprisebillingController {

	@Autowired
	private EnterprisebillingService enterprisebillingService;
	/**
	 * 显示企业计费页面
	 * @param enterprisebillingBean 企业计费Bean
	 * @return responseData
	 */
	@RequestMapping("showEnterprisebilling")
	public ResponseData showEnterbilling(EnterprisebillingBean enterprisebillingBean,int pageNum,int pageSize,HttpSession session){
		
		Page<Enterprisebilling> page = new Page<Enterprisebilling>(pageNum,pageSize);
		EntityWrapper<Enterprisebilling> entityWrapper = new EntityWrapper<Enterprisebilling>();
		log.info(enterprisebillingBean);
		
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		entityWrapper.eq("enterpriseid", enterprise.getEnterpriseid());
		
		if(!("".equals(enterprisebillingBean.getStarttime()) || enterprisebillingBean.getStarttime()==null )){
			entityWrapper.ge("endtime", enterprisebillingBean.getStarttime()+"00:00:00");
			log.info(enterprisebillingBean.getStarttime());
		}
		if(!("".equals(enterprisebillingBean.getEndtime()) || enterprisebillingBean.getEndtime() ==null)){
			entityWrapper.le("endtime", enterprisebillingBean.getEndtime()+"00:00:00");
			log.info(enterprisebillingBean.getEndtime());
		}
		//entityWrapper.eq("enterpriseid", enterprisebillingBean.getEnterpriseid());
		entityWrapper.orderBy("enterprisebillingid");
		Page<Enterprisebilling> page2 = enterprisebillingService.selectPage(page,entityWrapper);
		log.info(page2.getRecords());
		
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", page2);
		
	   	return responseData;
	}   
	
	/**
	 * 企业计费/各项计费合计
	 * @return 总笔数/总收入/总支出
	 */
	@RequestMapping("countAll")
	public ResponseData countAll(HttpSession session){
		
		Enterprisebilling eBean = new Enterprisebilling();
		Enterprise enterpriseid = (Enterprise) session.getAttribute("enterprise");
		eBean.setEnterpriseid(enterpriseid.getEnterpriseid());
		
		Integer countNum = enterprisebillingService.countNumById(eBean);
		Double countIncome = enterprisebillingService.countNumByIncome(eBean);
		Double countExpend = enterprisebillingService.countNumByExpend(eBean);
		
		ResponseData responseData = new ResponseData();
		responseData.getData().put("countNum", countNum);
		responseData.getData().put("countIncome", countIncome);
		responseData.getData().put("countExpend", countExpend);
		
		return responseData;
	}
}
