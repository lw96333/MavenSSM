package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.java.bean.BuyerInformationBean;
import com.java.bean.PageBean;
import com.java.bean.SellcarsBean;
import com.java.bean.SellingParkingInformationBean;
import com.java.bean.UnauditedParkingSpaceInfoBean;
import com.java.entity.Purchasecars;
import com.java.mapper.ExaminationAndApprovalOfIndividualParkingSpacesMapper;
import com.java.service.ExaminationAndApprovalOfIndividualParkingSpacesService;
/**
 * 审批车位买卖
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Service
public class ExaminationAndApprovalOfIndividualParkingSpacesServiceImpl
		extends ServiceImpl<ExaminationAndApprovalOfIndividualParkingSpacesMapper, Purchasecars>
		implements ExaminationAndApprovalOfIndividualParkingSpacesService {

	@Autowired
	private ExaminationAndApprovalOfIndividualParkingSpacesMapper examinationMapper;

	@Override
	public PageBean<UnauditedParkingSpaceInfoBean> selectAllSellerInformation(int pageNum) {
		// TODO Auto-generated method stub
		PageBean<UnauditedParkingSpaceInfoBean> pageBean = new PageBean<UnauditedParkingSpaceInfoBean>();
		List<SellingParkingInformationBean> sellList = examinationMapper.selectSellerInformation((pageNum - 1) * 5);
		List<BuyerInformationBean> buyerList = examinationMapper.selectBuyerInformation((pageNum - 1) * 5);
		List<UnauditedParkingSpaceInfoBean> unauditedList = new ArrayList<UnauditedParkingSpaceInfoBean>();
		for (BuyerInformationBean b : buyerList) {
			for (SellingParkingInformationBean s : sellList) {
				if (s.getPurchasecarsid() == b.getPurchasecarsid()) {
					UnauditedParkingSpaceInfoBean unauditedParkingSpaceInfoBean = new UnauditedParkingSpaceInfoBean();
					unauditedParkingSpaceInfoBean.setPrivatecarsid(s.getPrivatecarsid());
					unauditedParkingSpaceInfoBean.setPurchasecarsid(s.getPurchasecarsid());
					unauditedParkingSpaceInfoBean.setArea(s.getArea());
					unauditedParkingSpaceInfoBean.setEquitiesid(s.getEquitiesid());
					unauditedParkingSpaceInfoBean.setIdentitynumber(s.getIdentitynumber());
					unauditedParkingSpaceInfoBean.setPhone(s.getPhone());
					unauditedParkingSpaceInfoBean.setPurchasePhone(b.getPhone());
					unauditedParkingSpaceInfoBean.setPurchaseRealname(b.getRealname());
					unauditedParkingSpaceInfoBean.setPurchaseUserid(b.getUserid());
					unauditedParkingSpaceInfoBean.setRealname(s.getRealname());
					unauditedParkingSpaceInfoBean.setSellUserid(s.getUserid());
					unauditedList.add(unauditedParkingSpaceInfoBean);
				}
			}
		}
		pageBean.setPageData(unauditedList);
		pageBean.setTotalData(examinationMapper.getAllPurchasecars().size());
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		return pageBean;
	}

	@Override
	public boolean updateAuditPass(int purchasecarsid) {
		// TODO Auto-generated method stub
		int update = examinationMapper.updateAuditPass(purchasecarsid);
		examinationMapper.insertSellcars(purchasecarsid);
		
		if(update != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAuditFailed(int purchasecarsid,int privatecarsid) {
		// TODO Auto-generated method stub
		int update = examinationMapper.updateAuditFailed(purchasecarsid);
		int delete = examinationMapper.deleteSellcarsByprivatecarsid(privatecarsid);
		int updatePrivatecars = examinationMapper.updatePrivatecarsById(privatecarsid);
		if(update != 0) {
			return true;
		}
		return false;
	}

}
