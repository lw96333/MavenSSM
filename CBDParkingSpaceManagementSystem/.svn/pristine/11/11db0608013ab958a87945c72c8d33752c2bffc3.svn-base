package com.java.service;

import com.java.entity.Enterprise;
import com.java.entity.Enterprisebilling;
import com.java.mapper.EnterprisebillingMapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 计费 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface EnterprisebillingService extends IService<Enterprisebilling> {
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
