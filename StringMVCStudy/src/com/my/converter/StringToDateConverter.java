package com.my.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器（字符串转日期）
 * @author 49160
 *
 */

public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String str) {
		// TODO Auto-generated method stub
		str = str.replace("/", "-");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
