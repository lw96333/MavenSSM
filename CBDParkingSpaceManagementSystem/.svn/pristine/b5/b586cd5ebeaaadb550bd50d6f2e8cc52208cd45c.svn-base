package com.java.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.AddRentTimeBean;
import com.java.entity.Leasecars;
import com.java.entity.Privatecars;
import com.java.service.LeasecarsService;
import com.java.service.PrivatecarsService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;
import sun.rmi.runtime.Log;
import sun.util.logging.resources.logging;

/**
 * 添加出租发布时间控制器
 * @author 温岱
 *
 * 2019年3月24日
 */
@RestController
@Log4j
public class AddRentTimeController {

	/**
	 * 业务层
	 */
	@Autowired
	private LeasecarsService leasecarsService;

	@Autowired
	private PrivatecarsService privatecarsService;
	
	@LogStatistics(operatecontent="点击发布出租添加时间价格",operation=logType.添加)
	@RequestMapping(value = "insertSentTime",method = RequestMethod.POST)
	public ResponseData insertSentTime(@Valid AddRentTimeBean addRentTimeBean,BindingResult bindingResult,HttpSession session) {
		ResponseData responseData = new ResponseData();
		log.info("进入insertSentTiem");
		// 判断校验结果
			if (bindingResult.hasErrors()) {
				log.info("1进入错误信息判断,会返回一个notfound");
				// 获取校验错误信息
				List<FieldError> fieldErrors = bindingResult.getFieldErrors();
				log.info("校验错误数：" + bindingResult.getErrorCount());
				log.info("校验错误信息：");
				for (FieldError error : fieldErrors) {
					// 获取校验错误的参数名
					log.info(error.getField());
					// 获取校验错误的Message
					log.info(error.getDefaultMessage());
					// 取值在后面显示
					session.setAttribute(error.getField(), error.getDefaultMessage());
				}
			}else{
				log.info("2信息按照格式正确输入>>");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(new Date());
				
				Leasecars leasecarsEntity = new Leasecars();
				leasecarsEntity.setStarttime(addRentTimeBean.getStarttime());
				leasecarsEntity.setEndtime(addRentTimeBean.getEndtime());
				leasecarsEntity.setPrice(addRentTimeBean.getPrice());
				leasecarsEntity.setState("等待出租");
				leasecarsEntity.setIssuetime(date);
				leasecarsEntity.setPrivatecarsid(Integer.valueOf(addRentTimeBean.getPrivatecarsid()));
				
				
				EntityWrapper<Privatecars> privatecarsWrapper = new EntityWrapper<Privatecars>();
				privatecarsWrapper.eq("privatecarsid", addRentTimeBean.getPrivatecarsid());
				
				Privatecars privatecars = privatecarsService.selectOne(privatecarsWrapper);
				privatecars.setState("等待出租");
				
				
				boolean num = leasecarsService.insert(leasecarsEntity);
				
				boolean num1 = privatecarsService.update(privatecars, privatecarsWrapper);
				
				return ResponseData.ok();
			}
			return ResponseData.noFound();
	}
}
