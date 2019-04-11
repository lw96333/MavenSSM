package com.my.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.javabean.DispositBean;
/**
 * 数据校验
 * @author 49160
 *
 */
@Controller
public class DespositController {

	@RequestMapping("deposit")
	//@Valid表示数据校验 BindingResult保存校验结果 注意：注解和校验结果参数必须放在响应位置，中间不能由其他参数
	public String desposit(@Valid DispositBean dispositBean,BindingResult bindingResult,ModelMap modelMap) {
		if(bindingResult.hasErrors()) {
			//获取校验错误信息
			List<FieldError> fieldError = bindingResult.getFieldErrors();
			System.out.println("错误数量"+fieldError.size());
			for(FieldError f : fieldError) {
				System.out.println(f);
				//获取错误信息参数
				System.out.println(f.getField());
				//获取校验信息的message
				System.out.println(f.getDefaultMessage());
				modelMap.addAttribute(f.getField(), f.getDefaultMessage());
			}
			
			return "../Deposit";
		}
		return "depoitOK";
	}
}
