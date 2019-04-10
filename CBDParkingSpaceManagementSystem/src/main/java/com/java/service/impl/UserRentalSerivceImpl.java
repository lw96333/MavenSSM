package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Deal;
import com.java.mapper.ViewTheRentalPageMapper;
import com.java.service.UserRentalSerivce;
/**
 *   查询用户租赁车位
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
@Service
public class UserRentalSerivceImpl  extends ServiceImpl<ViewTheRentalPageMapper, Deal> implements UserRentalSerivce  {

	@Autowired
	private ViewTheRentalPageMapper viewTheRentalMapper;
	
	@Override
	public PageBean<ViewTheRentalPageBean> getUserRentalInfoByUserId(int userId, int pageNum) {
		// TODO Auto-generated method stub
		PageBean<ViewTheRentalPageBean> pageBean = new PageBean<ViewTheRentalPageBean>();
		pageBean.setPageData(viewTheRentalMapper.getMyLeaseByUserId(userId,(pageNum - 1) * 5));
		pageBean.setTotalData(viewTheRentalMapper.getAll(userId).size());
		pageBean.setPageNum(pageNum);
		pageBean.setTotalNum((int) Math.ceil((double)pageBean.getTotalData()/5));
		return pageBean;
	}

}
