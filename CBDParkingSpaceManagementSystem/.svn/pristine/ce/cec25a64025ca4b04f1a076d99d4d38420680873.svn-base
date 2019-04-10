package com.java.restcontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.CbdBean;
import com.java.bean.ExternalcontractBean;
import com.java.bean.UpdataExternalcontractBean;
import com.java.entity.Cbd;
import com.java.entity.Externalcontract;
import com.java.service.CbdService;
import com.java.service.ExternalcontractService;
import com.java.util.LogStatistics;
import com.java.util.ResponseData;
import com.java.util.UploadFiles;
import com.java.util.UserType;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;

/**
 * 外部合约
 * 
 * @author 张冀川
 *
 *         2019年3月23日
 */
@Log4j
@RestController
public class ExternalcontractRestController {
	@Autowired
	private ExternalcontractService externalcontractService;
	@Autowired
	private CbdService cbdService;
	/**
	 * 传入当前页数，显示条数，查询外部租约的所有
	 * 
	 * @param curPage 当前页数
	 * @param pageSize 显示条数
	 * @return
	 */
	@RequestMapping("showPageExternalcontract")
	public ResponseData showPageExternalcontract(Integer curPage, Integer pageSize) {
		
		Page<Externalcontract> page = new Page<Externalcontract>(curPage, pageSize);
		Page page2 = externalcontractService.selectPage(page);
		ResponseData responseData = new ResponseData();
		responseData.getData().put("page", page2);
		return responseData;
	}
	/**
	 * 根据id解除一个合约
	 * @param id
	 * @return
	 */
	@LogStatistics(operatecontent="外部合约解约",operation=logType.删除)
	@RequestMapping("deleteExternalcontract")
	public ResponseData deleteExternalcontract(Integer id){
		ResponseData responseData = new ResponseData();
		Externalcontract externalcontract =externalcontractService.selectById(id);
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		entityWrapper.eq("externalid", externalcontract.getContractnumber());
		cbdService.delete(entityWrapper);
		boolean result = externalcontractService.deleteById(id);
		if(result==false){
			responseData.setMessage("no found resource");
			return responseData;
		}
		
		return responseData;
	}
	/**
	 * 根据id得到企业的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("getExternalcontract")
	public ResponseData getExternalcontract(Integer id){
		ResponseData responseData = new ResponseData();
		Externalcontract externalcontract =externalcontractService.selectById(id);
		responseData.getData().put("externalcontract", externalcontract);
		return responseData;
	}
	
	
	/**
	 * 根据id修改合约信息
	 * @param id
	 * @return
	 */
	@LogStatistics(operatecontent="续约外部合约",operation=logType.修改)
	@RequestMapping("updataExternalcontract")
	public ResponseData updataExternalcontract(
			@Valid UpdataExternalcontractBean updataEx, 
			BindingResult bindingResult,
			HttpServletRequest request){
		
		ResponseData responseData = new ResponseData();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldErrored : fieldErrors) {
				responseData.getData().put(fieldErrored.getField(), fieldErrored.getDefaultMessage());
			}
			responseData.setCode(400);
			responseData.setMessage("请将信息添加完整");
			return responseData;
		}
		String localhost = "1";
		try {
			localhost = UploadFiles.fileUpload(request);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 判断时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		try {
			d1 = sdf.parse(updataEx.getStarttime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		//得到前一天
		calendar.add(Calendar.DATE, -1); 
		Date date = calendar.getTime();
		Date d2=null;
		try {
			d2=sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long resultTwo = d1.getTime()-d2.getTime();
		if (resultTwo < 0) {
			responseData.setCode(400);
			responseData.setMessage("开始时间等于当前日期");
			return responseData;
		}
		Cbd cbdold = new Cbd();
		cbdold.setExternalid(updataEx.getContractnumber());
		cbdold.setSizetime(updataEx.getStarttime());
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		entityWrapper.eq("externalid", updataEx.getOldcontractnumber());
		cbdService.update(cbdold, entityWrapper);
		Externalcontract externalcontract=getExternalcontract(updataEx);
		externalcontract.setContract(localhost);
		boolean resultThree =externalcontractService.updateById(externalcontract);
		if(resultThree==false){
			responseData.setMessage("no found resource");
			return responseData;
		}
		return responseData;
	}
	/**
	 * 封装一个Externalcontract类
	 * @param updataEx 页面传入的bean类
	 * @return
	 */
	public Externalcontract getExternalcontract(UpdataExternalcontractBean updataEx){
		Externalcontract externalcontract = new Externalcontract();
		externalcontract.setId(Integer.parseInt(updataEx.getId()));
		externalcontract.setOldcontractnumber(updataEx.getOldcontractnumber());
		externalcontract.setContractnumber(updataEx.getContractnumber());
		externalcontract.setContactperson(updataEx.getContactperson());
		externalcontract.setPhone(updataEx.getPhone());
		externalcontract.setStarttime(updataEx.getStarttime());
		externalcontract.setEndtime(updataEx.getEndtime());
		externalcontract.setPrice(updataEx.getPrice());
		externalcontract.setContractcompany(updataEx.getContractcompany());
		return externalcontract;
	}
	

	/**
	 * 添加一个新的合约
	 * @param extBean 前端传入的数据
	 * @return
	 */
	@LogStatistics(operatecontent="添加外部合约",operation=logType.添加)
	@RequestMapping("inserterExternalcontract")
	public ResponseData inserterExternalcontract(@Valid ExternalcontractBean extBean, BindingResult bindingResult,
			HttpServletRequest request) {
		ResponseData responseData = new ResponseData();
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldErrored : fieldErrors) {
				responseData.getData().put(fieldErrored.getField(), fieldErrored.getDefaultMessage());
			}
			responseData.setCode(400);
			responseData.setMessage("请将信息添加完整");
			return responseData;
		}
		String localhost = "1";
		try {
			localhost = UploadFiles.fileUpload(request);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 判断时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		try {
			d1 = sdf.parse(extBean.getStarttime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		 //得到前一天
		calendar.add(Calendar.DATE, -1);
		Date date = calendar.getTime();
		Date d2=null;
		try {
			d2=sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long resultTwo = d1.getTime()-d2.getTime();
		if (resultTwo < 0) {
			responseData.setCode(400);
			responseData.setMessage("开始时间等于当前日期");
			return responseData;
		}
		CbdBean cbdBean=new CbdBean();
		//车位数量
		cbdBean.setNumber(extBean.getNumber());
		//车位编号
		cbdBean.setAreanumber(extBean.getStallnumber());
		//车位地址
		cbdBean.setAddress(extBean.getAddress());
		//车位合同
		cbdBean.setFromdate(extBean.getContractnumber());
		//添加车位时间
		cbdBean.setStartTime(extBean.getStarttime());
		//添加车位起始位置
		cbdBean.setFristnumbers(extBean.getStartnumber());
		String teString= insertCBD(cbdBean);
		String teStringTest = "车位编号已存在";
		if(teStringTest.equals(teString)){
			responseData.setMessage("车位编号已存在");
			return responseData;
		}
		Externalcontract externalcontract=getExternalcontractTwo(extBean);
		externalcontract.setContract(localhost);

		boolean judge = externalcontractService.insert(externalcontract);
		
		if (judge == false) {
			responseData.setMessage("no found resource");
			return responseData;
		}
		return responseData;
	}
	/**
	 * 一个添加页面封装Externalcontract
	 * @param extBean 页面传入的添加数据
	 * @return
	 */
	public Externalcontract getExternalcontractTwo(ExternalcontractBean extBean){
		Externalcontract externalcontract = new Externalcontract();
		externalcontract.setContractnumber(extBean.getContractnumber());
		externalcontract.setContractcompany(extBean.getContractcompany());
		externalcontract.setContactperson(extBean.getContactperson());
		externalcontract.setPhone(extBean.getPhone());
		externalcontract.setAddress(extBean.getAddress());
		externalcontract.setStarttime(extBean.getStarttime());
		externalcontract.setEndtime(extBean.getEndtime());
		externalcontract.setPrice(extBean.getPrice());
		externalcontract.setStalladdress(extBean.getStalladdress());
		externalcontract.setStallnumber(extBean.getStallnumber());
		return externalcontract;
	}
	public String insertCBD(CbdBean cbdBean){
		EntityWrapper<Cbd> entityWrapper = new EntityWrapper<Cbd>();
		int nubmer = cbdBean.getNumber();
		for(int i=0;i < nubmer;i++) {
			Cbd cbd = new Cbd();
			cbd.setAddress(cbdBean.getAddress());
			int number = cbdBean.getFristnumbers()+i;
			String result = cbdBean.getAreanumber()+number;
			entityWrapper.eq("areanumber", result);
			Cbd cbdold = cbdService.selectOne(entityWrapper);
			//判断车位编号已存在
			if(cbdold != null) {
				return "车位编号已存在";
			}else {
				cbd.setAreanumber(result);
			}
			cbd.setExternalid(cbdBean.getFromdate());
			
			cbd.setSizetime(cbdBean.getStartTime());
			cbd.setState("空闲");
			cbdService.insert(cbd);
		}
		return "ok";
	}

}
