package com.my.i18n;

import java.util.Locale;

/**
 * java国际化
 * @author 罗维
 *
 * 2019年3月5日
 */
public class I18NDome {

	public static void main(String[] args) {
		
		//获取java语言支持所有的国家和语言环境
		Locale[] locales = Locale.getAvailableLocales();
		
		//打印java支持所有国家和语言
		for(int index = 0; index < locales.length; index++) {
			
			System.out.println(
					locales[index].getDisplayCountry() 
					+ "="
					+ locales[index].getCountry()
					+ "="
					+ locales[index].getDisplayLanguage()
					+ "="
					+ locales[index].getLanguage()
					);
			System.out.println();			
		}
	}
}
