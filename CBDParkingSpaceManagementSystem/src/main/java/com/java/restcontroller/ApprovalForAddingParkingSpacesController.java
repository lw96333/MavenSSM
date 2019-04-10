package com.java.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.PageBean;
import com.java.bean.SellcarsBean;
import com.java.bean.UnauditedParkingSpaceInfoBean;
import com.java.entity.Leasecars;
import com.java.entity.Sellcars;
import com.java.service.ExaminationAndApprovalOfIndividualParkingSpacesService;
import com.java.service.LeasecarsService;
import com.java.service.SellcarsService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 后台审批个人买卖车位监听器
 * 
 * @author 刘佳秋
 *
 *         2019年3月21日
 */
@RestController
@Log4j
public class ApprovalForAddingParkingSpacesController {

	@Autowired
	private ExaminationAndApprovalOfIndividualParkingSpacesService examinationService;

	/**
	 * 查询显示需要审批的买卖信息
	 * 
	 * @param 当前页数
	 * @return
	 */
	@RequestMapping(value = "showInfo", method = RequestMethod.POST)
	public ResponseData showParkingInfo(Integer pageNum) {
		Map<String, Object> parkingInfo = new HashMap<String, Object>(2);
		ResponseData responseData = new ResponseData();

		if (pageNum != null) {
			PageBean<UnauditedParkingSpaceInfoBean> unauditedList = examinationService
					.selectAllSellerInformation(pageNum);
			if (unauditedList != null) {
				parkingInfo.put("parkingInfo", unauditedList);
				responseData.setData(parkingInfo);
			} else {
				responseData = ResponseData.noFound();
			}
		}
		return responseData;
	}

	/**
	 * 审核不通过
	 * 
	 * @param purchasecarsid
	 * @return
	 */
	@LogStatistics(operatecontent="审批个人买卖车位：不通过",operation=logType.修改)
	@RequestMapping(value = "auditFailed", method = RequestMethod.POST)
	public ResponseData auditFailed(Integer purchasecarsid,int privatecarsid) {
		log.info("审批个人买卖车位不通过 审批买卖车位ID:" + purchasecarsid);
		ResponseData responseData = new ResponseData();
		if (purchasecarsid != null) {
			boolean auditFailed = examinationService.updateAuditFailed(purchasecarsid,privatecarsid);
			if (!auditFailed) {
				responseData = ResponseData.noFound();
			}
		}
		return responseData;
	}

	/**
	 * 审核通过
	 * 
	 * @param purchasecarsid
	 * @param privatecarsid
	 * @return
	 */
	@LogStatistics(operatecontent="审批个人买卖车位：通过",operation=logType.修改)
	@RequestMapping(value = "auditPass", method = RequestMethod.POST)
	public ResponseData auditPass(Integer purchasecarsid, Integer privatecarsid) {
		log.info("审批个人买卖车位通过 审批买卖车位ID:" + purchasecarsid);
		log.info("审批个人买卖车位通过 审批车位ID:" + privatecarsid);
		ResponseData responseData = new ResponseData();
		if (purchasecarsid != null && privatecarsid != null) {
			boolean auditPass = examinationService.updateAuditPass(privatecarsid);
			if (!auditPass) {
				responseData = ResponseData.noFound();
			}

		}
		return responseData;
	}

}
