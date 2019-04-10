package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.service.ViewHistoricalParkingRentalService;
import com.java.util.ResponseData;

/**
 * 查看历史租赁车位控制器
 * @author 温岱
 *
 * 2019年3月26日
 */
@RestController
public class ViewHistoricalParkingRentalController {

	@Autowired
	private ViewHistoricalParkingRentalService viewHistoricalParkingRentalService;
	
	@RequestMapping(value="showHistoricalRentalParking",method=RequestMethod.POST)
	public ResponseData showInfo(Integer userId,Integer pageNum) {
		ResponseData responseData = new ResponseData();
		if (userId != null && pageNum != null) {
			PageBean<ViewTheRentalPageBean> pageBean = viewHistoricalParkingRentalService.getAllNeedData(userId, pageNum);
			Map<String, Object> map = new HashMap<String, Object>(20);
			map.put("pageInfo", pageBean);
			responseData.setData(map);
		}else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
}
