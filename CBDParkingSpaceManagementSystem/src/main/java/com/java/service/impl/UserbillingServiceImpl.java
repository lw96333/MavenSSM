package com.java.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.java.entity.Userbilling;
import com.java.mapper.UserbillingMapper;
import com.java.service.UserbillingService;

/**
 * <p>
 * 个人用户计费 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
public class UserbillingServiceImpl extends ServiceImpl<UserbillingMapper, Userbilling> implements UserbillingService {
	
	@Autowired
	private UserbillingMapper userbillingMapper;
	
	@Override
	public Integer countDealSum(Userbilling userbilling) {
		Integer result = userbillingMapper.countDealSum(userbilling);
		return result;
	}

	@Override
	public Double countIncomeSum(Userbilling userbilling) {
		Double result = userbillingMapper.countIncomeSum(userbilling);
		return result;
	}

	@Override
	public Double countExpendSum(Userbilling userbilling) {
		Double result = userbillingMapper.countExpendSum(userbilling);
		return result;
	}
	
}
