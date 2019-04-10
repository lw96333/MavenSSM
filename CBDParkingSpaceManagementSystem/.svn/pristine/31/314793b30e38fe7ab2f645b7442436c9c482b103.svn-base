package com.java.mapper;

import com.java.entity.Userbilling;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 个人用户计费 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface UserbillingMapper extends BaseMapper<Userbilling> {
	
	/**
	 *  计算个人用户计费交易总笔数
	 * @param userbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select count(userbillingid) from userbilling where userid = #{userid}")
	public Integer countDealSum(Userbilling userbilling);
	
	/**
	 * 计算个人用户计费交易收入总额
	 * @param userbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select sum(income) from userbilling where userid = #{userid}")
	public Double countIncomeSum(Userbilling userbilling);
	
	/**
	 * 计算个人用户计费交易支出总额
	 * @param  userbilling 超级管理员计费实体类
	 * @return 影响行数
	 */
	@Select("select sum(expend) from userbilling where userid = #{userid}")
	public Double countExpendSum(Userbilling userbilling);
}