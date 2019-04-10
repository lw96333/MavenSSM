package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.PageBean;
import com.java.bean.ParkingAreaHomePageBean;
import com.java.entity.Externalcontract;
import com.java.entity.Log;
import com.java.service.LogService;
import com.java.util.ResponseData;

/**
 * 日志控制器
 * @author 张冀川
 *
 * 2019年3月28日
 */
@RestController
public class LogController {
	@Autowired
	private LogService logService;
	/**
	 * 显示所有日志
	 * @param curPage 当前页数
	 * @return
	 */
	@RequestMapping("showLog")
	public ResponseData showLog(Integer curPage, String permission,
			String endTime, String stateTime){
		ResponseData responseData = new ResponseData();
		if(curPage != null) {
			PageBean<Log> pageBean = logService.getAllPageBean(curPage,permission,endTime,stateTime);
				Map<String, Object> map = new HashMap<String, Object>(1);
				map.put("pageInfo", pageBean);
				responseData.setData(map);
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
}
