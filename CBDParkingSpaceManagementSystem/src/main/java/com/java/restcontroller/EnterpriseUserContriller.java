package com.java.restcontroller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.java.bean.EnterpriseUserBean;
import com.java.entity.Enterprise;
import com.java.service.EnterpriseService;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;


/**
 * 企业用户控制器
 * 
 * @author 温岱
 *
 *         2019年3月21日
 */

@RestController
@Log4j
public class EnterpriseUserContriller {
    @Autowired
	private EnterpriseService enterpriseService;
    
	/**
	 * 删除企业信息
	 * 
	 * @return
	 */
    @LogStatistics(operatecontent="删除企业信息",operation=logType.删除)
	@RequestMapping(value = "deleteEnterpriseUser", method = RequestMethod.POST)
	public ResponseData deleteEnterpriseUser(Integer enterpriseid) {
        log.info("我来了");
		if (enterpriseid != null) {
			
			Enterprise enterpriseEntity = new Enterprise();
			//如果要删除，要设置id
			enterpriseEntity.setEnterpriseid(enterpriseid);
			Boolean boolean1 = enterpriseService.delete(new EntityWrapper<Enterprise>(enterpriseEntity));
			if (boolean1) {
				ResponseData responseData = new ResponseData();
				
				return responseData;
				
			}else {
				return ResponseData.noFound();
			}

		} else {
			return ResponseData.noFound();
		} 
	}
}
