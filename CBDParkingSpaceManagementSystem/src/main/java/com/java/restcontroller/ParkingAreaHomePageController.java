package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Cbd;
import com.java.entity.Deal;
import com.java.entity.Leasecars;
import com.java.entity.Privatecars;
import com.java.service.DealService;
import com.java.service.LeasecarsService;
import com.java.service.PrivatecarsService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 出租车位首页控制器
 * @author 刘佳秋
 *
 * 2019年3月26日
 */
@RestController
@Log4j
public class ParkingAreaHomePageController {

	@Autowired
	private PrivatecarsService privatecarsService;
	@Autowired
	private DealService dealService;
	@Autowired
	private LeasecarsService leasecars;
	
	@RequestMapping(value="showAllParkingInfo",method=RequestMethod.POST)
	public ResponseData getAllParkingInfo(Integer pageNum, String endTime, String stateTime ) {
		ResponseData responseData = new ResponseData();
		if(pageNum != null) {
			PageBean<ParkingAreaHomePageBean> pageBean = privatecarsService.getAllPageBean(pageNum,endTime,stateTime);
				Map<String, Object> map = new HashMap<String, Object>(2);
				map.put("pageInfo", pageBean);
				responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
	@RequestMapping(value="getParkingByIdLJQ",method=RequestMethod.POST)
	public  ResponseData getParkingInfoById(Integer id) {
		log.info("查看出租车位详细信息");
		log.info("出租车位ID ： " + id);
		ResponseData responseData = new ResponseData();
		if(id != null) {
			ParkingAreaHomePageBean parkingBean = privatecarsService.getParkingInfoById(id);
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("parkingInfo", parkingBean);
			responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
	@LogStatistics(operatecontent="个人车位出租：预定车位",operation=logType.添加)
	@RequestMapping(value="insertDealLJQ",method=RequestMethod.POST)
	public  ResponseData bookAParkingPlace(Deal deal) {
		log.info("个人预定车位");
		log.info("预定车位信息 ： " + deal);
		ResponseData responseData = new ResponseData();
		if(deal != null) {
			dealService.insert(deal);
			EntityWrapper<Leasecars> leaEntityWrapper = new EntityWrapper<Leasecars>();
			leaEntityWrapper.eq("privatecarsid", deal.getPrivatecarsid());
			Leasecars leasecar = leasecars.selectOne(leaEntityWrapper);
			leasecar.setState("已出租");
			leasecars.updateById(leasecar);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	
}
