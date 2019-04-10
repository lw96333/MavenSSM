package com.java.restcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.AddPrivatecarsBean;
import com.java.entity.Privatecars;
import com.java.entity.User;
import com.java.service.PrivatecarsService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.UploadFiles;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 添加车位控制器
 * 
 * @author 董鑫
 *
 *         2019年3月25日
 */
@Log4j
@RestController
public class AddPrivatecarsController {

	@Autowired
	private PrivatecarsService privateCarService;
	@Autowired
	private ResponseData responseData;
	@Autowired
	private Privatecars privateCars;

	@LogStatistics(operatecontent="添加个人车位",operation=logType.添加)
	@RequestMapping(value = "addPrivatecars", method = RequestMethod.POST)
	public ResponseData addPrivateCars(AddPrivatecarsBean addPrivateCarsBean, HttpServletRequest request,
			HttpSession session) {

		String equitiesid = addPrivateCarsBean.getEquitiesid();
		EntityWrapper<Privatecars> entityWrapper = new EntityWrapper<Privatecars>();

		entityWrapper.eq("equitiesid", equitiesid);

		Privatecars privateCars2 = privateCarService.selectOne(entityWrapper);

		if (privateCars2 != null) {
			log.info("已存在车位");
			log.info(privateCars2.getEquitiesid());
			log.info(addPrivateCarsBean.getEquitiesid());
			responseData.setMessage("已存在");
			responseData.getData().put("privateCars2", privateCars2);
			return responseData;
		} else {
			log.info("添加成功");
			log.info(addPrivateCarsBean.getEquitiesid());
			privateCars.setEquitiesid(addPrivateCarsBean.getEquitiesid());
		   
		}
		

		log.info("收到AddprivateCars添加车位请求");
		String imgs = "teauytsd";
		try {

			imgs = UploadFiles.fileUpload(request);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		privateCars.setArea(addPrivateCarsBean.getArea());

		privateCars.setAreaid(addPrivateCarsBean.getAreaid());

		User user = (User) session.getAttribute("user");

		log.info(user.getUserid());

		privateCars.setUserid(user.getUserid());

		privateCars.setState("待审核");

		privateCars.setPropertyright(imgs);

		privateCarService.insert(privateCars);

		
		 responseData.getData().put("privateCars2", privateCars2);
		return responseData;

	}
}
