package com.java.service;

import com.java.bean.EnterprisecontractBean;
import com.java.bean.PageBean;
import com.java.entity.Enterprise;
import com.java.entity.Enterprisecontract;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 企业合约 服务类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
public interface EnterprisecontractService extends IService<Enterprisecontract> {
	
	/**
	 * 查询所有企业合同
	 * @param map 
	 * @return
	 */
	public PageBean<EnterprisecontractBean> findAllContract(Map<String,Integer> map);
	
	/**
	 * 添加新的企业合约
	 * @param eBean
	 * @return
	 */
	public int addEnterprisecontract(Enterprisecontract eBean);
	
}
