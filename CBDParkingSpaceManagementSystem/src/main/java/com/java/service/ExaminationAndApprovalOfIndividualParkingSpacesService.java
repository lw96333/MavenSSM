package com.java.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.java.bean.PageBean;
import com.java.bean.SellcarsBean;
import com.java.bean.UnauditedParkingSpaceInfoBean;
import com.java.entity.Purchasecars;
/**
 * 审批车位买卖Mapper
 * @author 刘佳秋
 *
 * 2019年3月21日
 */
public interface ExaminationAndApprovalOfIndividualParkingSpacesService extends IService<Purchasecars> {

	/**
	 * 查询个人所有待审核车位
	 * @param pageNum 当前页数
	 * @return 所有待审核车位集合
	 */
	PageBean<UnauditedParkingSpaceInfoBean> selectAllSellerInformation(int pageNum);
	
	/**
	 * 个人车位买卖通过审核
	 * @param purchasecarsid 购买车位ID
	 * @return 修改状态是否成功
	 */
	boolean updateAuditPass(int purchasecarsid);
	
	/**
	 * 个人买卖车位后台审核不通过
	 * @param purchasecarsid 购买车位ID
	 * @param privatecarsid 车位ID
	 * @return
	 */
	boolean updateAuditFailed(int purchasecarsid, int privatecarsid);
	
}
