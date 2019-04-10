package com.java.service.impl;

import com.java.entity.Enterprise;
import com.java.entity.Enterprisebilling;
import com.java.mapper.EnterprisebillingMapper;
import com.java.service.EnterprisebillingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 计费 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class EnterprisebillingServiceImpl extends ServiceImpl<EnterprisebillingMapper, Enterprisebilling> implements EnterprisebillingService {

	@Autowired
	private EnterprisebillingMapper enterprisebillingMapper;
	
	/**
	 * 计算总笔数
	 */
	@Override
	public Integer countNumById(Enterprisebilling enterprisebilling) {
		// TODO Auto-generated method stub
		return enterprisebillingMapper.countNumById(enterprisebilling);
	}

	/**
	 * 计算总收入
	 */
	@Override
	public Double countNumByIncome(Enterprisebilling enterprisebilling) {
		// TODO Auto-generated method stub
		return enterprisebillingMapper.countNumByIncome(enterprisebilling);
	}
	
	/**
	 * 计算总支出
	 */
	@Override
	public Double countNumByExpend(Enterprisebilling enterprisebilling) {
		// TODO Auto-generated method stub
		return enterprisebillingMapper.countNumByExpend(enterprisebilling);
	}
	
}
