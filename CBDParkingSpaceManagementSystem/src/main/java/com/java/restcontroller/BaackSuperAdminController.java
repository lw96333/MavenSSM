package com.java.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.AdminBean;
import com.java.entity.Admin;
import com.java.entity.Adminpower;
import com.java.service.AdminService;
import com.java.service.AdminpowerService;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;
import sun.security.util.Password;
/**
 * 超级管理员模块
 * @author 罗维
 *
 * 2019年3月21日
 */
@RestController
@Log4j
public class BaackSuperAdminController {
	/**
	 * 管理员service
	 */
	@Autowired
	private AdminService adminService;
	/**
	 * 权限管理
	 */
	@Autowired
	private AdminpowerService adminpowerService;
	/**
	 * 添加管理员
	 * @param adminBean
	 * @return
	 */
	@LogStatistics(operatecontent="增加管理员",operation=logType.添加)
	@RequestMapping("super/insertAdmin")
	public ResponseData insertAdmin(AdminBean adminBean) {
		log.info("接受insertAdmin请求");
		EntityWrapper<Admin> entityWrapper = new EntityWrapper<Admin>();
		entityWrapper.eq("jobnumber", adminBean.getJobnumber());
		ResponseData responseData = new ResponseData();
		//查询是否存在用户
		Admin adminOld = adminService.selectOne(entityWrapper);
		if(adminOld != null) {
			responseData.setCode(5);
			responseData.setMessage("工号已经存在");
			return responseData;
		}
		//添加用户
		Admin admin = new Admin();
		admin.setJobnumber(adminBean.getJobnumber().trim());
		admin.setName(adminBean.getName().trim());
		admin.setPassword(PasswordUtil.generate(adminBean.getJobnumber().trim(),adminBean.getPassword().trim()));
		admin.setPhone(adminBean.getPhone().trim());
		adminService.insert(admin);
		
		//添加权限
		Admin adminNew = adminService.selectOne(entityWrapper);

		String power = adminBean.getJurisdiction(); 

		String[] powerStr = power.split(",");
		for(int index = 0;index < powerStr.length ; index++) {
			Adminpower adminpower = new Adminpower();
			adminpower.setAdminid(adminNew.getAdminid());
			adminpower.setJurisdictionid(Integer.parseInt(powerStr[index]));
			adminpowerService.insert(adminpower);
		}
		return ResponseData.ok();
	}
	/**
	 * 条件分页查询所有数据
	 * @param adminBean 数据
	 * @return 查询数据
	 */
	@RequestMapping("selectAdmin")
	public ResponseData selectAdmin(AdminBean adminBean) {
		log.info("接受selectAdmin请求");
		ResponseData responseData = new ResponseData();
		EntityWrapper<Admin> entityWrapper = new EntityWrapper<Admin>();
		String jobnumber = adminBean.getJobnumber();
		String name = adminBean.getName();
		String phone = adminBean.getPhone();
		if(jobnumber != null && jobnumber != "") {
			entityWrapper.eq("jobnumber", adminBean.getJobnumber());
		}
		
		if(name != null && name != "") {
			entityWrapper.like("name", name);
		}
		
		if(phone != null && phone != "") {
			entityWrapper.eq("phone", phone);
		}
		entityWrapper.orderBy("adminid",false);
		page(responseData,adminBean.getPageNum(),adminBean.getPageSize(),entityWrapper);
		return responseData;
	}
	/**
	 * 跟新方法
	 * @return更新后的数据
	 */
	@LogStatistics(operatecontent="更改管理员权限",operation=logType.修改)
	@RequestMapping("super/updateAdmin")
	public ResponseData updateAdmin(int adminId,String addPower,String delPower) {
		
		
		if(addPower != "") {
			String[] addStr = addPower.split(",");
			for(int index=0; index < addStr.length ;index++) {
				Adminpower adminpower = new Adminpower();
				adminpower.setAdminid(adminId);
				adminpower.setJurisdictionid(
						Integer.parseInt(addStr[index]));
				adminpowerService.insert(adminpower);	
			}
		}
		
		if(delPower != "") {
			String[] delStr = delPower.split(",");
			for(int index=0; index < delStr.length ;index++) {
				
				adminpowerService.delete(new EntityWrapper<Adminpower>()
						.eq("adminid", adminId)
						.eq("jurisdictionid", delStr[index]));
					
			}
		}
		
		
		return ResponseData.ok();
	}
	
	/**
	 * 删除方法
	 * @param adminId 删除id
	 * @return 返回删除后数据
	 */
	@LogStatistics(operatecontent="删除管理员",operation=logType.删除)
	@RequestMapping("super/deleteAdmin")
	public ResponseData deleteAdmin(int  adminId) {
		ResponseData responseData = new ResponseData();
		
		EntityWrapper<Admin> entity = new EntityWrapper<Admin>();
		entity.eq("adminid", adminId);
		adminService.delete(entity);
		
		adminpowerService.delete(new EntityWrapper<Adminpower>().eq("adminid", adminId));
		EntityWrapper<Admin> entity2 = new EntityWrapper<Admin>();
		entity2.orderBy("adminid",false);
		page(responseData,1,5,entity2);
		
		
		return responseData;
	}
	/**
	 *	 通过id查询管理员
	 * @param adminId
	 * @return
	 */
	@RequestMapping("selectOneAdmin")
	public ResponseData selectOneAdmin(int adminId) {
		ResponseData responseData = new ResponseData();
		EntityWrapper<Admin> adminWrapper = new EntityWrapper<Admin>();
		adminWrapper.eq("adminid", adminId);
		Admin admin = adminService.selectOne(adminWrapper);
		
		EntityWrapper<Adminpower> powerWrapper = new EntityWrapper<Adminpower>();
		powerWrapper.eq("adminid", adminId);
		List<Adminpower> li = adminpowerService.selectList(powerWrapper);
		
		responseData.getData().put("admin", admin);
		responseData.getData().put("power", li);		
		return responseData;
	}
	
	/**
	 * 查询方法
	 * @param responseData 保存数据
	 * @param pageNum 当前页数
	 * @param pageSize 每页显示多少条
	 * @param entityWrapper 
	 */
	private void page(ResponseData responseData,int pageNum,int pageSize,EntityWrapper<Admin> entityWrapper) {
		Page<Admin> page = new Page<Admin>(pageNum,pageSize);
		Page<Admin> pageAdmin = adminService.selectPage(page, entityWrapper);
		
		responseData.getData().put("pageAdmin", pageAdmin);
		
		List<Admin> li = pageAdmin.getRecords();
		Map<Integer, List> map = new HashMap<Integer, List>(4);
		for(Admin admin : li) {
			List<Adminpower> power = adminpowerService.selectList(new EntityWrapper<Adminpower>().eq("adminid", admin.getAdminid()));
			List powers = new ArrayList(4);
			for(Adminpower adminpower : power) {
				powers.add(adminpower.getJurisdictionid());
			}
			map.put(admin.getAdminid(), powers);
		}
		responseData.getData().put("power",map);
	}
	
	
}
