package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.MyParkingSpaceInfoByDealBean;
import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Admin;
import com.java.entity.Deal;
import com.java.entity.Leasecars;
import com.java.service.LeasecarsService;
import com.java.service.UserRentalSerivce;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 用户租赁车位信息控制器
 * 
 * @author 刘佳秋
 *
 *         2019年3月25日
 */
@RestController
@Log4j
public class UserRentalController {

	@Autowired
	private UserRentalSerivce uSerivce;
	@Autowired
	private LeasecarsService leasecars;

	@RequestMapping(value = "showUserRentalInfo", method = RequestMethod.POST)
	public ResponseData showUserRentalById(Integer userId, Integer pageNum) {
		ResponseData responseData = new ResponseData();
		if (userId != null && pageNum != null) {
			PageBean<ViewTheRentalPageBean> pageBean = uSerivce.getUserRentalInfoByUserId(userId, pageNum);
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("pageInfo", pageBean);
			responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}

		return responseData;
	}

	
	@LogStatistics(operatecontent="个人车位租赁：取消租赁",operation=logType.删除)
	@RequestMapping(value = "deleteDeal", method = RequestMethod.POST)
	public ResponseData deleteDealById(Integer dealId) {
		log.info("个人车位租赁：取消租赁");
		log.info("预定车位ID： " + dealId);
		ResponseData responseData = new ResponseData();
		if (dealId != null) {
			EntityWrapper<Deal> entity = new EntityWrapper<Deal>();
			entity.eq("privatecarsid", dealId);
			boolean delete = uSerivce.delete(entity);
			
			EntityWrapper<Leasecars> leaEntityWrapper = new EntityWrapper<Leasecars>();
			leaEntityWrapper.eq("privatecarsid", dealId);
			
			Leasecars leasecar = leasecars.selectOne(leaEntityWrapper);
			
			leasecar.setState("等待出租");
			leasecars.insertOrUpdate(leasecar);
			
			if (!delete || leasecar == null) {
				responseData = ResponseData.noFound();
			}
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}

}
