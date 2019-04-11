package com.my.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * java支持国际化
 * @author 罗维
 *
 * 2019年3月5日
 */
public class I18NDomeTwo {

	public static void main(String[] args) {
		
		//获取当前系统支持的国家和环境
		Locale local = Locale.getDefault();
		
		//获取java语言支持所有的国家和语言环境
				Locale[] locales = Locale.getAvailableLocales();
				
				//打印java支持所有国家和语言
				for(int index = 0; index < locales.length; index++) {
					
					if ("GB".equals(locales[index].getCountry()) 
							&& "en".equals(locales[index].getLanguage())) {
						local = locales[index];
					}
								
				}
		
		//加载国家和语言环境资源文件
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message",local);
		
		//打印字符串信息
		System.out.println(resourceBundle.getString("hello"));
	}
}
