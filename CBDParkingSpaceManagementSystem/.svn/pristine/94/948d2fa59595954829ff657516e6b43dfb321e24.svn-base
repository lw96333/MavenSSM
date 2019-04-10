package com.java.service;

import com.baomidou.mybatisplus.service.IService;
import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Deal;
/**
 *  查询用户租赁车位Serivce
 * @author 刘佳秋
 *
 * 2019年3月25日
 */
public interface UserRentalSerivce extends IService<Deal> {

	/**
	 * 查询用户租赁车位(分页)
	 * @param userId 用户ID
	 * @param pageNum 当前页面
	 * @return 分页数据
	 */
	PageBean<ViewTheRentalPageBean> getUserRentalInfoByUserId(int userId, int pageNum);
}
