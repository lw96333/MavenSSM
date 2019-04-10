package com.java.restcontroller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.EnterprisecontractBean;
import com.java.bean.PageBean;
import com.java.entity.Admin;
import com.java.entity.Adminbilling;
import com.java.entity.Cbd;
import com.java.entity.Enterprise;
import com.java.entity.Enterprisebilling;
import com.java.entity.Enterprisecontract;
import com.java.service.AdminbillingService;
import com.java.service.CbdService;
import com.java.service.EnterpriseService;
import com.java.service.EnterprisebillingService;
import com.java.service.EnterprisecontractService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.UploadFiles;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 企业合约页面控制
 * @author 肖中华
 *
 * 2019年3月21日
 */
@RestController
@Log4j
public class ContractController {
	@Autowired
	private EnterprisecontractService enterpriseContractService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private CbdService cbdService;
	@Autowired
	private EnterprisebillingService enterpriseBillingService;
	@Autowired
	private AdminbillingService adminBillingService;
	
	/**
	 * 分页显示企业合同
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="getAllContract")
	public ResponseData getAllContract(int curPage,int pageSize) {
		Map<String, Integer> map = new HashMap<String, Integer>(20);
		map.put("curPage", curPage);
		map.put("pageSize", pageSize);
		PageBean<EnterprisecontractBean> pageBean=enterpriseContractService.findAllContract(map);
		log.info(pageBean);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("pages", pageBean);
		return responseData;
	}
	/**
	 * 企业名称和id
	 * @return
	 */
	@RequestMapping("getAllEnterpriseNameAndID")
	public ResponseData getAllEnterpriseNameAndID() {
		log.info( "得到企业的ID和名字");
		List<Enterprise> list=enterpriseService.selectList(new EntityWrapper<Enterprise>());
		ResponseData responseData = new ResponseData();
		responseData.getData().put("name", list);
		return responseData;
	}
	/**
	 * cbd车位状态
	 * @return
	 */
	@RequestMapping("getAllCBDByState")
	public ResponseData getAllCBDByState() {
	List<Cbd> list =cbdService.selectList(new EntityWrapper<Cbd>().eq("state", "空闲"));
	ResponseData responseData = new ResponseData();
	responseData.getData().put("state", list);
		return responseData;
	}
	/**
	 * 添加企业合约
	 * @param eBean
	 * @return
	 */
	@LogStatistics(operatecontent="添加企业合约",operation=logType.添加)
	@RequestMapping("insertContract")
	public ResponseData insertContract(EnterprisecontractBean eBean,HttpSession session) {
			
			Admin admin = (Admin) session.getAttribute("admin");
			log.info(admin.getAdminid()+"=====");
			String describe = "租赁车位的数量为:";
			String describe1 = "出租车位的数量为:";
			LocalDateTime localDateTime =LocalDateTime.now();
			String time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String[] cbdid = eBean.getAreanumber().split(",");
			ResponseData responseData = new ResponseData();
			Enterprisecontract enterprisecontract = new Enterprisecontract();
			enterprisecontract.setEnterpriseid(eBean.getEnterpriseid());
			enterprisecontract.setContractnumber(eBean.getContractnumber());
			enterprisecontract.setFromdate(eBean.getFromdate());
			enterprisecontract.setDeadline(eBean.getDeadline());
			enterprisecontract.setPrice(eBean.getPrice());
			int flag = enterpriseContractService.addEnterprisecontract(enterprisecontract);
			if(flag==1) {
				int enterpriseContractid = enterprisecontract.getEnterprisecontractid();
				for (String id : cbdid) {
					Cbd cbd	 = cbdService.selectOne(new EntityWrapper<Cbd>().eq("cbdid", id));
					cbd.setEnterprisecontractid(enterpriseContractid);
					cbd.setState("已出租");
					cbdService.update(cbd,new EntityWrapper<Cbd>().eq("cbdid", id));
				}
				/**
				 * 企业计费支出
				 */
				int cbds = cbdid.length;
				Enterprisebilling enterpriseBilling = new Enterprisebilling();
				enterpriseBilling.setEnterpriseid(eBean.getEnterpriseid());
				log.info(Double.parseDouble(eBean.getPrice()));
				enterpriseBilling.setExpend( Double.parseDouble(eBean.getPrice()));
				enterpriseBilling.setStarttime(eBean.getFromdate());
				enterpriseBilling.setEndtime(time);
				enterpriseBilling.setComment(describe+cbds);
				enterpriseBillingService.insert(enterpriseBilling);
				/**
				 * 管理员计费收入
				 */
				Adminbilling adminbilling = new Adminbilling();
				adminbilling.setAdminid(admin.getAdminid());
				adminbilling.setStarttime(eBean.getFromdate());
				adminbilling.setEndtime(time);
				adminbilling.setIncome(Double.parseDouble(eBean.getPrice()));
				adminbilling.setComment(describe1+cbds);
				adminBillingService.insert(adminbilling);
				return responseData;
			}	
			
		return ResponseData.unauthorized();
	}
	/**
	 * 通过企业合约ID得到续约前合约的数据
	 * @return
	 */
	@RequestMapping("getContractByid")
	public ResponseData getContractByid(String id) {
		ResponseData responseData = new ResponseData();
		Enterprisecontract enterprisecontract= enterpriseContractService.selectOne(new EntityWrapper<Enterprisecontract>().eq("enterprisecontractid", id));
		Integer enterpriseid= enterprisecontract.getEnterpriseid();
		Enterprise enterprise= enterpriseService.selectOne(new EntityWrapper<Enterprise>().eq("enterpriseid", enterpriseid));
		
		responseData.getData().put("enterprisecontractInfo", enterprisecontract);
		responseData.getData().put("enterpriseInfo", enterprise);
		return responseData;
	}
	
	/**
	 * 续约企业合约
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@LogStatistics(operatecontent="企业合约续约",operation=logType.修改)
	@RequestMapping("contractExtension")
	public ResponseData contractExtension(EnterprisecontractBean eBean,HttpServletRequest request,HttpSession session){
		String message = "续约";
		LocalDateTime localDateTime =LocalDateTime.now();
		String time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		Admin admin = (Admin) session.getAttribute("admin");
		log.info( eBean);
		String imgs = "";
 		try {
			 imgs =UploadFiles.fileUpload(request);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Enterprisecontract enterprisecontract = new Enterprisecontract();
		enterprisecontract.setEnterprisecontractid(eBean.getEnterprisecontractid());
		enterprisecontract.setFromdate(eBean.getFromdate());
		enterprisecontract.setDeadline(eBean.getDeadline());
		enterprisecontract.setPrice(eBean.getPrice());
		enterprisecontract.setOldcontractid(eBean.getContractnumber());
		enterprisecontract.setContractnumber(eBean.getNewcontractnumber());
		enterprisecontract.setContract(imgs);
		
		Enterprise enterprise =new Enterprise();
		enterprise.setEnterpriseid(eBean.getEnterpriseid());
		enterprise.setContactperson(eBean.getContactperson());
		enterprise.setPhone(eBean.getPhone());
				
		
	
		boolean flag = enterpriseContractService.update(enterprisecontract, new EntityWrapper<Enterprisecontract>().eq("enterprisecontractid", enterprisecontract.getEnterprisecontractid()));
		boolean flag2=enterpriseService.update(enterprise, new EntityWrapper<Enterprise>().eq("enterpriseid", enterprise.getEnterpriseid()));
		ResponseData responseData = new ResponseData();
		log.info(flag+"==="+flag2);
		if(flag==flag2) {
			/**
			 * 企业续约计费支出
			 */
			Enterprisebilling enterpriseBilling = new Enterprisebilling();
			enterpriseBilling.setEnterpriseid(eBean.getEnterpriseid());
			log.info(Double.parseDouble(eBean.getPrice()));
			enterpriseBilling.setExpend( Double.parseDouble(eBean.getPrice()));
			enterpriseBilling.setStarttime(eBean.getFromdate());
			enterpriseBilling.setEndtime(time);
			enterpriseBilling.setComment(message);
			enterpriseBillingService.insert(enterpriseBilling);
			/**
			 * 管理员续约计费收入
			 */
			Adminbilling adminbilling = new Adminbilling();
			adminbilling.setAdminid(admin.getAdminid());
			adminbilling.setStarttime(eBean.getFromdate());
			adminbilling.setEndtime(time);
			adminbilling.setIncome(Double.parseDouble(eBean.getPrice()));
			adminbilling.setComment(message);
			adminBillingService.insert(adminbilling);
			return responseData;
		}
		
		return ResponseData.unauthorized();
	}
	/**
	 * 企业合约解约
	 * @param id
	 * @return
	 */
	@LogStatistics(operatecontent="企业合约解约",operation=logType.删除)
	@RequestMapping("deletContractById")
	public ResponseData deletContractById(Integer id) {
		String satas = "空闲";
		List< Cbd> list= cbdService.selectList(new EntityWrapper<Cbd>().eq("enterprisecontractid", id));
		for (Cbd cbd2 : list) {
			cbd2.setState(satas);
			cbd2.setEnterprisecontractid(0);
			cbdService.update(cbd2, new EntityWrapper<Cbd>().eq("cbdid", cbd2.getCbdid()));
		}
		boolean flag=enterpriseContractService.delete(new EntityWrapper<Enterprisecontract>().eq("enterprisecontractid", id));
		
		ResponseData responseData = new ResponseData();
		
		if (flag) {
			return ResponseData.ok();
		}
		
		return ResponseData.unauthorized();
	}
	
	
	
	
}
