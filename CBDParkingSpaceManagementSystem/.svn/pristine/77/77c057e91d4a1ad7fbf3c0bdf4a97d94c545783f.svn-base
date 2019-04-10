package com.java.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.logging.Log;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.CbdBean;
import com.java.entity.Cbd;
import com.java.service.CbdService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.logType;
import com.mysql.fabric.xmlrpc.base.Data;

import lombok.extern.log4j.Log4j;

/**
 * 车位管理页面控制器
 * @author 郑升亮
 *
 *2019年3月21日
 */
@RestController
@Log4j
public class CbdController {
	@Autowired
	private CbdService cbdService;
	
	/**
	 * 添加CBD车位
	 * @param cbdBean 页面获取数据
	 * @return 返回成功
	 */
	@LogStatistics(operatecontent="添加CBD车位",operation=logType.添加)
	@RequestMapping("insertCbd")
	public ResponseData insertCbd(CbdBean cbdBean) {
		log.info("收到添加CBD车位请求");
		//添加用户
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		ResponseData responseData = new ResponseData();
		int nubmer = cbdBean.getNumber();
		int fristnumber = cbdBean.getFristnumbers();
		for(int i=0;i < nubmer;i++) {
			Cbd cbd = new Cbd();
			cbd.setAddress(cbdBean.getAddress());
			//获取前台车位区域编号
			String areanumber = cbdBean.getAreanumber();
			//批量添加后，系统将自动生成车位编号
			int fristn = fristnumber + i;
			String result = cbdBean.getAreanumber()+fristn;
			entityWrapper.eq("areanumber", result);
			Cbd cbdold = cbdService.selectOne(entityWrapper);
			//判断车位编号已存在
			if(cbdold != null) {
				responseData.setMessage("车位编号已存在");
				responseData.getData().put("areanumbers", cbdold.getAreanumber());
				
				return responseData;
			}else {
				cbd.setAreanumber(areanumber + fristn);
			}
			
			String data = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			cbd.setSizetime(data);
			cbd.setState("空闲");
			cbdService.insert(cbd);
		}
		
		return ResponseData.ok();
	}
	/**
	 *  显示所有信息
	 * @param showCbds 查询条件
	 * @param pageNum 当前页面
	 * @return 返回显示数据
	 */
	@RequestMapping("selectCbd")
	public ResponseData selectCbd(String showCbds,Integer pageNum) {
		log.info("收到显示Cbd车位所有信息请求");
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		if(showCbds != null) {
			entityWrapper.like("address", showCbds);
		}
		entityWrapper.orderBy("cbdid",false);
		Page<Cbd> page = new Page<Cbd>(pageNum,5);
		Page page2 = cbdService.selectPage(page,entityWrapper);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page2", page2);
		return responseData;
	}
}
