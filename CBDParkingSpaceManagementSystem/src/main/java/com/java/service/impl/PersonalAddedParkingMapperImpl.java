package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.java.bean.PageBean;
import com.java.bean.PersonalAddedParkingBean;
import com.java.entity.Privatecars;
import com.java.mapper.BackstagePrivateParkingSpaceExaminationAndApprovalMapper;
import com.java.service.PersonalAddedParkingService;
/**
 * 审批个人车位添加
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Service
public class PersonalAddedParkingMapperImpl
		extends ServiceImpl<BackstagePrivateParkingSpaceExaminationAndApprovalMapper, Privatecars>
		implements PersonalAddedParkingService {

	@Autowired
	private BackstagePrivateParkingSpaceExaminationAndApprovalMapper backstageMapper;
	
	@Override
	public PageBean<PersonalAddedParkingBean> getPersonalAddedParking(int pageNum) {
		// TODO Auto-generated method stub
		PageBean<PersonalAddedParkingBean> pageBean = new PageBean<PersonalAddedParkingBean>();
		pageBean.setPageData(backstageMapper.queryApprovalParking((pageNum - 1) * 5));
		pageBean.setTotalData(backstageMapper.getAllPersonalAddedParking().size());
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		return pageBean;
	}

	@Override
	public boolean updateAuditPass(int privatecarsid) {
		// TODO Auto-generated method stub
		int update = backstageMapper.updateAuditPass(privatecarsid);
		if(update != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAuditFailed(int privatecarsid) {
		// TODO Auto-generated method stub
		int update = backstageMapper.updateAuditFailed(privatecarsid);
		if(update != 0) {
			return true;
		}
		return false;
	}

}
