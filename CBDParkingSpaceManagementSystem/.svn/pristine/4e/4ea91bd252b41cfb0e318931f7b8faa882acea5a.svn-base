package com.java.service.impl;

import com.java.bean.LessorInfoBean;
import com.java.bean.MyParkingSpaceInfoByDealBean;
import com.java.bean.MyParkingSpaceInfoByLeasecarsBean;
import com.java.bean.PageBean;
import com.java.bean.PersonalAddedParkingBean;
import com.java.entity.Deal;
import com.java.mapper.DealMapper;
import com.java.service.DealService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租赁 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class DealServiceImpl extends ServiceImpl<DealMapper, Deal> implements DealService {

	@Autowired
	private DealMapper dealMapper;
	
	@Override
	public PageBean<MyParkingSpaceInfoByDealBean> getMyParkingSpaceInfo(int userId, int pageNum) {
		// TODO Auto-generated method stub
		PageBean<MyParkingSpaceInfoByDealBean> pageBean = new PageBean<MyParkingSpaceInfoByDealBean>();
		List<MyParkingSpaceInfoByLeasecarsBean> list = dealMapper.getMyParkingSpaceInfoByLeasecars(userId, (pageNum - 1) * 5);
		List<MyParkingSpaceInfoByDealBean> list2 = dealMapper.getMyParkingSpaceInfo(userId, (pageNum - 1) * 5);
		for (MyParkingSpaceInfoByLeasecarsBean leasecarsBean : list) {
			MyParkingSpaceInfoByDealBean myParkingSpaceInfoByDealBean = new MyParkingSpaceInfoByDealBean();
			myParkingSpaceInfoByDealBean.setArea(leasecarsBean.getArea());
			myParkingSpaceInfoByDealBean.setEndtime(leasecarsBean.getEndtime());
			myParkingSpaceInfoByDealBean.setEquitiesid(leasecarsBean.getEquitiesid());
			myParkingSpaceInfoByDealBean.setMessage(leasecarsBean.getMessage());
			myParkingSpaceInfoByDealBean.setPrivatecarsid(leasecarsBean.getPrivatecarsid());
			myParkingSpaceInfoByDealBean.setStartime(leasecarsBean.getStarttime());
			myParkingSpaceInfoByDealBean.setState(leasecarsBean.getState());
			myParkingSpaceInfoByDealBean.setUserid(leasecarsBean.getUserid());
			list2.add(myParkingSpaceInfoByDealBean);
		}
		pageBean.setPageData(list2);
		pageBean.setTotalData(dealMapper.getAll(userId).size() + dealMapper.getAlLeasecarsBeans(userId).size());
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		return pageBean;
	}

	@Override
	public LessorInfoBean getLessorByPrivatecarsid(int privatecarsid) {
		// TODO Auto-generated method stub
		LessorInfoBean lessorInfoBean = dealMapper.getLessorInfoByPrivatecarsid(privatecarsid);
		return lessorInfoBean;
	}

	@Override
	public boolean confirmRentalByUserIdAndPrivatecarsid(int userId, int duserId, int privatecarsid) {
		// TODO Auto-generated method stub
		
		  int updateLeasecars = dealMapper.updateLeasecarsByPrivatecarsid(privatecarsid); 
		  int update = dealMapper.updateRentalStatusByPrivatecarsid(privatecarsid); 
		  dealMapper.updateRentalStatusByPrivatecars(privatecarsid);
		  int userDealnumber = dealMapper.updateTransactionNumberByUserId(userId);
		  dealMapper.updateTransactionNumberByUserId(duserId);
		  if(updateLeasecars != 0 && update != 0 && userDealnumber != 0) { 
			  return true;
		  }
		  return false;
	}

	@Override
	public boolean cancellationOfRentalByUserIdAndPrivatecarsid(int userId, int privatecarsid) {
		// TODO Auto-generated method stub
		
		  int cancelTransaction = dealMapper.updateCancelTransactionByPrivatecarsid(privatecarsid); 
		  int updateLessor = dealMapper.updateLessorByPrivatecarsid(privatecarsid);
		  if(cancelTransaction != 0 && updateLessor != 0) { return true; }
		  return false;
	}
	
}
