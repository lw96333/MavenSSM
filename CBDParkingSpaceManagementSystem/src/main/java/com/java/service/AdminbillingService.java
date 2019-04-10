package com.java.service;

import com.java.entity.Adminbilling;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 管理员计费 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface AdminbillingService extends IService<Adminbilling> {
	
	/**
	 * 交易总笔数
	 * @param adminbilling 超级管理员实体类
	 * @return 影响行数
	 */
	public Integer countDealSum(Adminbilling adminbilling);
	
	/**
	 * 交易收入总额
	 * @param adminbilling 超级管理员实体类
	 * @return 影响行数
	 */
	public Double countIncomeSum(Adminbilling adminbilling);
	
	/**
	 *  交易支出总额
	 * @param adminbilling 超级管理员实体类
	 * @return 影响行数
	 */
	public Double countExpendSum(Adminbilling adminbilling);
	
}
