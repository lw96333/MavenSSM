package com.java.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.HistoricalRecordBean;
import com.java.bean.PageBean;
import com.java.entity.Complaint;
import com.java.service.ComplaintService;
import com.java.service.SellcarsService;
import com.java.service.ViewHistoricalParkingLeaseService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;
import com.sun.org.apache.bcel.internal.generic.NEW;

import lombok.extern.log4j.Log4j;

/**
 * 查看历史出租车位控制器
 * @author 温岱
 *
 * 2019年3月26日
 */
@RestController
@Log4j
public class ViewHistoricalParkingLeaseController {

	@Autowired
	private ViewHistoricalParkingLeaseService viewHistoricalParkingLeaseService;
	@Autowired
	private ComplaintService complaintService;
	
	@RequestMapping(value="showHistoricalLeaseParking",method = RequestMethod.POST)
	public ResponseData showInfo(Integer userId,Integer pageNum){
		ResponseData responseData = new ResponseData();
		if (userId != null && pageNum != null) {
			PageBean<HistoricalRecordBean> pageBean = viewHistoricalParkingLeaseService.getAllNeedData(userId, pageNum);
			Map<String, Object> map = new HashMap<String, Object>(20);
			map.put("pageInfo", pageBean);
			responseData.setData(map);
		}else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
	@LogStatistics(operatecontent="历史记录：投诉",operation=logType.添加)
	@RequestMapping(value="complaintLJQ",method=RequestMethod.POST)
	public ResponseData complaintLJQ(Complaint complaint) {
		log.info("投诉功能");
		log.info("投诉信息： " + complaint);
		log.info("被投诉人ID： " + complaint.getBtid());
		ResponseData responseData = new ResponseData();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(new Date());
		complaint.setComplaintime(date);
		complaintService.insert(complaint);
		return responseData;
	}
	
}
