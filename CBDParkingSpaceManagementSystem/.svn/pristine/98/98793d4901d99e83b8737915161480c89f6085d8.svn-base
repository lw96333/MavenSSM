package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.bean.PageBean;
import com.java.bean.PersonalAddedParkingBean;
import com.java.service.PersonalAddedParkingService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;
import com.sun.corba.se.spi.orb.Operation;

import lombok.extern.log4j.Log4j;

/**
 * 后台审批私人添加车位监听器
 * 
 * @author 刘佳秋
 *
 *         2019年3月21日
 */
@RestController
@Log4j
public class ApprovalAddParkingSpacesController {

	@Autowired
	private PersonalAddedParkingService personSerivce;

	/**
	 * 显示需要审批的车位
	 * @param pageNum 分页当前页面
	 * @return 需要显示的数据
	 */
	@RequestMapping(value="showPersonalAddedParkingInfo",method=RequestMethod.POST)
	public ResponseData showPersonalAddedParkingInfo(Integer pageNum) {
		ResponseData responseData = new ResponseData();
		Map<String , Object> map = new HashMap<String, Object>(2);
		if(pageNum != null) {
			PageBean<PersonalAddedParkingBean> pageBean = personSerivce.getPersonalAddedParking(pageNum);
			if(pageBean != null) {
				map.put("parkingInfo", pageBean);
				responseData.setData(map);
			} else {
				responseData = ResponseData.noFound();
			}
		} else {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}

	/**
	 * 审核不通过
	 * @param privatecarsid 车位id
	 * @return
	 */
	@LogStatistics(operatecontent="审批个人添加车位：不通过",operation=logType.修改)
	@RequestMapping(value="auditFailedPerson",method=RequestMethod.POST)
	public ResponseData auditFailed(Integer privatecarsid, Integer pageNum) {
		log.info("审批个人添加车位不通过 审批车位ID:" + privatecarsid);
		ResponseData responseData = new ResponseData();
		Map<String , Object> map = new HashMap<String, Object>(2);
		boolean auditPass = personSerivce.updateAuditFailed(privatecarsid);
		if(pageNum != null) {
			PageBean<PersonalAddedParkingBean> pageBean = personSerivce.getPersonalAddedParking(pageNum);
			if(pageBean != null) {
				map.put("parkingInfo", pageBean);
				responseData.setData(map);
			} else {
				responseData = ResponseData.noFound();
			}
		}
		if(!auditPass) {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
	/**
	 * 审核通过
	 * @param privatecarsid 车位id
	 * @return
	 */
	@LogStatistics(operatecontent="审批个人添加车位：通过",operation=logType.修改)
	@RequestMapping(value="auditPassPerson",method=RequestMethod.POST)
	public ResponseData auditPass(Integer privatecarsid, Integer pageNum) {
		log.info("审批个人添加车位通过 审批车位ID:" + privatecarsid);
		ResponseData responseData = new ResponseData();
		Map<String , Object> map = new HashMap<String, Object>(2);
		boolean auditPass = personSerivce.updateAuditPass(privatecarsid);
		if(pageNum != null) {
			PageBean<PersonalAddedParkingBean> pageBean = personSerivce.getPersonalAddedParking(pageNum);
			if(pageBean != null) {
				map.put("parkingInfo", pageBean);
				responseData.setData(map);
			} else {
				responseData = ResponseData.noFound();
			}
		}
		if(!auditPass) {
			responseData = ResponseData.noFound();
		}
		return responseData;
	}
}
