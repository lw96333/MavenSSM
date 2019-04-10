package com.java.restcontroller;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.java.bean.EnterpriseUserBean;
import com.java.entity.Enterprise;
import com.java.service.EnterpriseService;
import com.java.util.LogStatistics;
import com.java.util.PasswordUtil;
import com.java.util.ResponseData;
import com.java.util.logType;

import lombok.extern.log4j.Log4j;
/**
 * 企业添加用户
 * @author 陈志强
 *
 * 2019年3月24日
 */

@RestController
@Log4j
public class EnterpriseAddUserContriller {

	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private Enterprise enterpriseEntity;
	@Autowired
	private ResponseData responseData;

	/**
	 * 新增企业信息
	 * 
	 * @param enterpriseUser
	 * @return responseData 
	 */
	@LogStatistics(operatecontent="添加企业用户",operation=logType.添加)
	@RequestMapping(value = "insertEnterpriseUser", method = RequestMethod.POST)
	public ResponseData insertEnterpriseUser(@Valid EnterpriseUserBean enterpriseUser, BindingResult bindingResult,
			HttpSession session) {
		log.info(enterpriseUser);
		log.info("1进入错误信息判断,会返回一个notfound");
		log.info("进入insertEnterpriseUser");
		// 判断校验结果
		if (bindingResult.hasErrors()) {
			log.info("1进入错误信息判断,会返回一个notfound");
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
			return ResponseData.noFound();

		} else {
			log.info("2信息按照格式正确输入>>");

			
			/**
			 * 排空,看添加的与数据库已有的是否重复冲突
			 */
			Boolean boolean1 = false;
			if (enterpriseUser != null && !"".equals(enterpriseUser)) {
				log.info("3进入排空判断,防止抛空指针");
				EntityWrapper<Enterprise> entityWrapper = new EntityWrapper<Enterprise>();
				entityWrapper.eq("name", enterpriseUser.getName());
				Enterprise enterpriseOld = enterpriseService.selectOne(entityWrapper);
				// 进入排重判断
				if (enterpriseOld == null) {
					//说明未查到相同用户名,就不重名允许添加进入循环
					log.info("4未进入排重复判断,说明数据不是重复可以添加");
					enterpriseEntity.setName(enterpriseUser.getName());
                    enterpriseEntity.setPassword(PasswordUtil.generate(enterpriseUser.getName(), enterpriseUser.getPassword()));
					enterpriseEntity.setEnterpriename(enterpriseUser.getEnterpriename());
					enterpriseEntity.setContactperson(enterpriseUser.getContactperson());
					enterpriseEntity.setPhone(enterpriseUser.getPhone());
					enterpriseEntity.setFloor(Integer.parseInt(enterpriseUser.getFloor()));
					enterpriseEntity.setJurisdictionid(2);
					// 当页面输入正确格式,并且新添加的与数据库用户名和电话号码不重复,这里才执行添加
					boolean1 = enterpriseService.insert(enterpriseEntity);
					return ResponseData.ok();
				} else {
					responseData.setCode(438);
					log.info("4.进入排重复判断,说明数据重复了不能添加,返回responseData.Data[result]==438");
					return responseData;
                }

			}
			// 此行是任意返回,是未成功的code
			responseData.setCode(88);
			return responseData;

		}

	}

}
