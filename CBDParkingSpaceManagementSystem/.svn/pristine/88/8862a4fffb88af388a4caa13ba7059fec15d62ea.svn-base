package com.java.service.impl;

import com.java.bean.EnterprisecontractBean;
import com.java.bean.PageBean;
import com.java.entity.Enterprise;
import com.java.entity.Enterprisecontract;
import com.java.mapper.EnterprisecontractMapper;
import com.java.service.EnterprisecontractService;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业合约 服务实现类
 * </p>
 *
 * @author 肖中华
 * @since 2019-03-21
 */
@Service
public class EnterprisecontractServiceImpl extends ServiceImpl<EnterprisecontractMapper, Enterprisecontract> implements EnterprisecontractService {

	@Autowired
	private EnterprisecontractMapper enterprisecontractMapper;
	
	@Override
	public PageBean<EnterprisecontractBean> findAllContract(Map<String,Integer> map) {
		int curPage = map.get("curPage");

		int pageSize = map.get("pageSize");

		PageBean<EnterprisecontractBean> pageBean = new PageBean<EnterprisecontractBean>();

		int newcurPage = (curPage - 1) * pageSize;

		map.put("newcurPage", newcurPage);
		List<EnterprisecontractBean> list = enterprisecontractMapper.findAllContract(map);

		int tolSize = enterprisecontractMapper.getsize().getEnterprisecontractid();
		pageBean.setPageNum(curPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalData(tolSize);
		pageBean.setPageData(list);
		//计算得到总页数
		int tolNum = (int) Math.ceil((double)tolSize/pageSize);
		pageBean.setTotalNum(tolNum);
		return pageBean;
	}

	@Override
	public int addEnterprisecontract(Enterprisecontract eBean) {
		
		return enterprisecontractMapper.addEnterprisecontract(eBean);
	}
	
	
}
