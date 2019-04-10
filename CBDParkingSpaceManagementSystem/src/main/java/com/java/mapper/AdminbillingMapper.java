package com.java.mapper;

import com.java.entity.Adminbilling;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 管理员计费 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface AdminbillingMapper extends BaseMapper<Adminbilling> {
	
	/**
	 *  计算超级管理员计费交易总笔数
	 * @param adminbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select count(adminbillingid) from adminbilling where adminid = #{adminid}")
	public Integer countDealSum(Adminbilling adminbilling);
	
	/**
	 * 计算超级管理员计费交易收入总额
	 * @param adminbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select sum(income) from adminbilling where adminid = #{adminid}")
	public Double countIncomeSum(Adminbilling adminbilling);
	
	/**
	 * 计算超级管理员计费交易支出总额
	 * @param  adminbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select sum(expend) from adminbilling where adminid = #{adminid}")
	public Double countExpendSum(Adminbilling adminbilling);
}