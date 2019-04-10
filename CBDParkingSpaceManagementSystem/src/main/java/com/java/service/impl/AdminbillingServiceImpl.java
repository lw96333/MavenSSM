package com.java.service.impl;

import com.java.entity.Adminbilling;
import com.java.mapper.AdminbillingMapper;
import com.java.service.AdminbillingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员计费 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class AdminbillingServiceImpl extends ServiceImpl<AdminbillingMapper, Adminbilling> implements AdminbillingService {
	
	@Autowired
	private AdminbillingMapper adminbillingMapper;
	
	@Override
	public Integer countDealSum(Adminbilling adminbilling) {
		Integer result = adminbillingMapper.countDealSum(adminbilling);
		return result;
	}

	@Override
	public Double countIncomeSum(Adminbilling adminbilling) {
		Double result = adminbillingMapper.countIncomeSum(adminbilling);
		return result;
	}

	@Override
	public Double countExpendSum(Adminbilling adminbilling) {
		Double result = adminbillingMapper.countExpendSum(adminbilling);
		return result;
	}
	
}
