package com.java.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.LessorInfoBean;
import com.java.bean.MyParkingSpaceInfoByDealBean;
import com.java.bean.PageBean;
import com.java.bean.TransactionRecordBean;
import com.java.entity.Userbilling;
import com.java.service.DealService;
import com.java.service.UserbillingService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 个人用户查看我的出租车位控制器
 * 
 * @author 刘佳秋
 *
 *         2019年3月24日
 */
@RestController
@Log4j
public class MyParkingSpaceController {

	@Autowired
	private DealService dealService;
	@Autowired
	private UserbillingService userblilling;
	@RequestMapping(value = "showMyParkingSpaceInfo",method=RequestMethod.POST)
	public ResponseData showInfo(Integer userId, Integer pageNum) {
		ResponseData responseData = new ResponseData();
		if (userId != null && pageNum != null) {
			PageBean<MyParkingSpaceInfoByDealBean> pageBean = dealService.getMyParkingSpaceInfo(userId, pageNum);
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("pageInfo", pageBean);
			responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
	@RequestMapping(value="showLessorInfo",method=RequestMethod.POST)
	public ResponseData showLessorInfo(Integer privatecarsid) {
		log.info("查看车位预定人信息");
		log.info("预定车位ID : " + privatecarsid);
		ResponseData responseData = new ResponseData();
		if (privatecarsid != null) {
			Map<String, Object> map = new HashMap<String, Object>(2);
			LessorInfoBean lessorInfoBean = dealService.getLessorByPrivatecarsid(privatecarsid);
			map.put("lessorInfo", lessorInfoBean);
			responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
	@LogStatistics(operatecontent="个人车位出租是否出租给预定人：否",operation=logType.修改)
	@RequestMapping(value="cancellationOfRental",method=RequestMethod.POST)
	public ResponseData cancellationOfRental(Integer userId, Integer privatecarsid) {
		log.info("是否出租给预定人：否");
		log.info("预定人ID : " + userId);
		log.info("预定车位ID : " + privatecarsid);
		ResponseData responseData = new ResponseData();
		if(userId != null && privatecarsid != null) {
			boolean cancellationOfRental = dealService.cancellationOfRentalByUserIdAndPrivatecarsid(userId, privatecarsid);
			if( !cancellationOfRental) {
				responseData = ResponseData.noFound();
			}
		}
		return responseData;
	}
	
	@LogStatistics(operatecontent="个人车位出租是否出租给预定人：是",operation=logType.修改)
	@RequestMapping(value="confirmRental",method=RequestMethod.POST)
	public ResponseData confirmRental(TransactionRecordBean transactionRecordBean) {
		log.info("是否出租给预定人：是");
		log.info("预定人ID : " + transactionRecordBean.getDuserId());
		log.info("预定车位ID : " + transactionRecordBean.getPrivatecarsid());
		ResponseData responseData = new ResponseData();
		if(transactionRecordBean != null) {
			boolean confirmRental = dealService.confirmRentalByUserIdAndPrivatecarsid(transactionRecordBean.getUserId(), transactionRecordBean.getDuserId(), transactionRecordBean.getPrivatecarsid());
			if( !confirmRental ) {
				responseData = ResponseData.noFound();
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = simpleDateFormat.format(new Date());
			Userbilling userbilling = new Userbilling();
			userbilling.setUserid(transactionRecordBean.getDuserId());
			userbilling.setStarttime(transactionRecordBean.getStartime());
			userbilling.setEndtime(date);
			userbilling.setIncome(transactionRecordBean.getPrice());
			userblilling.insert(userbilling);
			Userbilling userbilling2 = new Userbilling();
			userbilling2.setUserid(transactionRecordBean.getUserId());
			userbilling2.setStarttime(transactionRecordBean.getStartime());
			userbilling2.setEndtime(date);
			userbilling2.setExpend(transactionRecordBean.getPrice());
			userblilling.insert(userbilling2);
			
			log.info("个人计费：收入" + userbilling);
			log.info("个人计费：支出" + userbilling2);
		}
		return responseData;
	}
	
}
