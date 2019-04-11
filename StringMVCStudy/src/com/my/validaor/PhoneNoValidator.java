package com.my.validaor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义电话号码注解校验器
 * @author 49160
 *
 */
public class PhoneNoValidator implements ConstraintValidator<PhoneNo, String>{

	@Override
	public void initialize(PhoneNo arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(phone == null || phone.isEmpty()) {
			return false;
		}
		if(phone.matches("1[3|4|5|7|8|9]\\d{9}")) {
			return true;
		} 
		return false;
	}

}
