/**
 * 
 */
package com.java.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
 * 模糊查询显示企业用户
 * 
 * @author 陈志强
 *
 *         2019年3月25日
 */
@Log4j
@RestController
public class SelectEnterpriseUserController {
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private Enterprise enterpriseEntity;
	@Autowired
	private ResponseData responseData;

	@RequestMapping(value = "selectEnterpriseUserbyname", method = RequestMethod.POST)
	public ResponseData selectEnterpriseUserbyname(EnterpriseUserBean enterpriseUser, Integer pageNum,
			Integer pageSize) {

		log.info(enterpriseUser);
		log.info(pageSize);
		log.info(pageNum);
		EntityWrapper<Enterprise> entityWrapper = new EntityWrapper<Enterprise>();
		Page<Enterprise> page = new Page<Enterprise>(pageNum, pageSize);
		Page page2 = enterpriseService.selectPage(page,
				entityWrapper.like("contactperson", enterpriseUser.getContactperson())
						.like("floor", enterpriseUser.getFloor()).like("phone", enterpriseUser.getPhone())
						.like("enterpriename", enterpriseUser.getEnterpriename()).orderBy("enterpriseid"));
		log.info(enterpriseUser.getEnterpriename());
		responseData.getData().put("page", page2);
		responseData.getData().put("contactperson", enterpriseUser.getContactperson());
		responseData.getData().put("floor", enterpriseUser.getFloor());
		responseData.getData().put("phone", enterpriseUser.getPhone());
		responseData.getData().put("enterpriename", enterpriseUser.getEnterpriename());

		return responseData;
	}

	/**
	 * 修改企业用户
	 * 
	 * @param enterpriseUser
	 * @return
	 */
	@LogStatistics(operatecontent = "修改企业用户", operation = logType.修改)
	@RequestMapping(value = "updateEnterpriseUser", method = RequestMethod.POST)
	public ResponseData updateEnterpriseUser(@Valid EnterpriseUserBean enterpriseUser, BindingResult bindingResult,
			HttpSession session) {
		log.info("进入updateEnterpriseUser");
		// 通过企业用户登录后存放的ID去查此列数据,然后做更改
		enterpriseEntity = (Enterprise) session.getAttribute("enterprise");
		log.info(enterpriseUser);
		log.info("拿到ID没有?" + enterpriseEntity.getEnterpriseid());
		// 判断校验结果
		if (bindingResult.hasErrors()) {
			log.info("1进入错误信息判断,会返回一个unauthorized()其code==401");
			// 获取校验错误信息
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			log.info("校验错误数：" + bindingResult.getErrorCount());
			log.info("校验错误信息：");
			for (FieldError error : fieldErrors) {
				// 获取校验错误的参数名
				log.info(error.getField());
				// 获取校验错误的Message
				log.info(error.getDefaultMessage());
				// 取值在后面显示
				session.setAttribute(error.getField(), error.getDefaultMessage());
			}
			return ResponseData.unauthorized();

		} else {
			log.info("2信息按照格式正确输入>>");
			EntityWrapper<Enterprise> entityWrapper = new EntityWrapper<Enterprise>();
			entityWrapper.eq("enterpriseid", enterpriseEntity.getEnterpriseid());

			String passwordStr = PasswordUtil.generate(enterpriseUser.getName(), enterpriseUser.getPassword());
			enterpriseEntity.setPassword(passwordStr);
			enterpriseEntity.setContactperson(enterpriseUser.getContactperson());
			enterpriseEntity.setPhone(enterpriseUser.getPhone());
			enterpriseEntity.setName(enterpriseUser.getName());
			enterpriseService.update(enterpriseEntity, entityWrapper);
			session.removeAttribute("user");
			session.removeAttribute("admin");
			session.removeAttribute("enterprise");
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
			log.info("更改后用户名" + enterpriseUser.getName());
			log.info("更改后密码" + PasswordUtil.generate(enterpriseUser.getName(), enterpriseUser.getPassword()));
			return ResponseData.ok();
		}
	}

}
