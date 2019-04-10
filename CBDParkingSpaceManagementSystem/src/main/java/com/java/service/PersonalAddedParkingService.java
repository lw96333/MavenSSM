package com.java.service;

import com.baomidou.mybatisplus.service.IService;
import com.java.bean.PageBean;
import com.java.bean.PersonalAddedParkingBean;
import com.java.entity.Privatecars;
/**
 * 审批个人车位添加
 * @author 刘佳秋
 *
 * 2019年3月21日
 */
public interface PersonalAddedParkingService extends IService<Privatecars>{

	/**
	 * 查询待审核车辆  分页
	 * @param pageNum 当前页面
	 * @return 分页对象
	 */
	PageBean<PersonalAddedParkingBean> getPersonalAddedParking(int pageNum);
	/**
	 * 用户私人车位审核通过
	 * @param privatecarsid 用户私人车位ID
	 * @return 是否成功
	 */
	boolean updateAuditPass(int privatecarsid);
	/**
	 * 用户私人车位审核不通过
	 * @param privatecarsid 用户私人车位ID
	 * @return 是否成功
	 */
	boolean updateAuditFailed(int privatecarsid);
	
}
