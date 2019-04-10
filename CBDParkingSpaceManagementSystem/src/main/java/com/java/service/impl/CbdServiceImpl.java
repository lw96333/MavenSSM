package com.java.service.impl;

import com.java.bean.CbdBean;
import com.java.bean.EnterprisecontractBean;
import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Cbd;
import com.java.entity.Enterprise;
import com.java.mapper.CbdMapper;
import com.java.service.CbdService;

import lombok.extern.log4j.Log4j;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * cbd车位表 服务实现类
 * </p>
 *
 * @author 刘云升
 * @since 2019-03-21
 */
@Service
@Log4j
public class CbdServiceImpl extends ServiceImpl<CbdMapper, Cbd> implements CbdService {
	
	@Autowired
	private CbdMapper cbdMapper;

	@Override
	public PageBean<CbdBean> getEnterpriseLeaseCarport(Map<String, Object> map) {
		int curPage = (Integer) map.get("curPage");

		int pageSize = (Integer) map.get("pageSize");
		
		Enterprise enterprise = (Enterprise) map.get("enterprise");
		
		PageBean<CbdBean> pageBean = new PageBean<CbdBean>();

		int newcurPage = (curPage - 1) * pageSize;

		map.put("newcurPage", newcurPage);
		map.put("enterpriseId", enterprise.getEnterpriseid());
		List<CbdBean> list = cbdMapper.getEnterpriseLeaseCarport(map);
		log.info(list);
		
		int tolSize = cbdMapper.getSize(enterprise);
		log.info(tolSize);
		pageBean.setPageNum(curPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalData(tolSize);
		pageBean.setPageData(list);
		//计算得到总页数
		int tolNum = (int) Math.ceil((double)tolSize/pageSize);
		pageBean.setTotalNum(tolNum);
		return pageBean;
		
	}

	
	
}
