package com.java.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.CbdBean;
import com.java.bean.EnterprisecontractBean;
import com.java.bean.PageBean;
import com.java.bean.ViewTheRentalPageBean;
import com.java.entity.Cbd;
import com.java.entity.Enterprise;
import com.java.service.CbdService;
import com.java.util.ResponseData;

import lombok.extern.log4j.Log4j;

/**
 * 企业用户查看车位页面控制器
 * @author 温家强
 *
 * 2019年3月26日
 */
@RestController
@Log4j
public class CbdCarportController {
	
	@Autowired
	private CbdService cbdService;
	
	/**
	 * 查看cbd空闲车位(分页)
	 * @param cbdBean cbdBean
	 * @param pageNum 当前页数
	 * @param pageSize 当前页数总条数
	 * @return 分页数据
	 */
	@RequestMapping("showCbdLeisureCarport")
	public ResponseData showCbdLeisureCarport(CbdBean cbdBean,int pageNum,int pageSize) {
		Page<Cbd> pageCbds =  new Page<Cbd>(pageNum,pageSize);
		
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		
		Page cbdPages = cbdService.selectPage(pageCbds,entityWrapper.eq("state", "空闲").orderBy("cbdid"));
		log.info(cbdPages);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", cbdPages);
		
		return responseData;
		
	}
	
	/**
	 * 查看企业已租赁车位(分页)
	 * @param pageNum 当前页数
	 * @param pageSize 当前页数总条数
	 * @return 分页数据
	 */
	@RequestMapping("showEnterpriseLeaseCarport")
	public ResponseData showEnterpriseLeaseCarport(int pageNum, int pageSize,HttpSession session) {
		Enterprise enterprise = (Enterprise) session.getAttribute("enterprise");
		
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("curPage", pageNum);
		map.put("pageSize", pageSize);
		map.put("enterprise", enterprise);
		log.info(map);
		PageBean<CbdBean> pageBean= cbdService.getEnterpriseLeaseCarport(map);
		log.info(pageBean);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", pageBean);
		return responseData;
	}
}
