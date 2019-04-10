package com.java.mapper;

import com.java.entity.Enterprise;
import com.java.entity.Enterprisebilling;

import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Primary;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 计费 Mapper 接口
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */

public interface EnterprisebillingMapper extends BaseMapper<Enterprisebilling> {

	/**
	 * 计算总笔数
	 * @param enterprisebilling 企业计费实体
	 * @return 总笔数
	 */
	@Select("SELECT COUNT(enterprisebillingid) FROM enterprisebilling where enterpriseid=#{enterpriseid}")
	public Integer countNumById(Enterprisebilling enterprisebilling);
	/**
	 * 计算总收入
	 * @param enterprisebilling 企业计费实体
	 * @return 总收入
	 */ 
	@Select("SELECT SUM(income) FROM enterprisebilling where enterpriseid=#{enterpriseid}")
	public Double countNumByIncome(Enterprisebilling enterprisebilling);
	/**
	 * 计算总支出
	 * @param enterprisebilling 企业计费实体
	 * @return 总支出
	 */
	@Select("SELECT SUM(expend) FROM enterprisebilling where enterpriseid=#{enterpriseid}")
	public Double countNumByExpend(Enterprisebilling enterprisebilling);
}

