package com.java.service;

import com.java.entity.Userbilling;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  个人用户计费 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface UserbillingService extends IService<Userbilling> {
	
	/**
	 * 交易总笔数
	 * @param userbilling个人用户实体类
	 * @return
	 */
	public Integer countDealSum(Userbilling userbilling);

	/**
	 * 交易收入总额
	 * @param userbilling 个人用户实体类
	 * @return 影响行数
	 */
	public Double countIncomeSum(Userbilling userbilling);
	
	/**
	 * 交易支出总额
	 * @param userbilling 个人用户实体类
	 * @return 影响行数
	 */
	public Double countExpendSum(Userbilling userbilling);
}
