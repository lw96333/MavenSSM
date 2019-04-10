package com.java.bean;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 配置上传文件大小
 * @author 张冀川
 *
 * 2019年3月23日
 */
@Configuration
public class UploadFilesSizeBean {
	 @Bean  
	    public MultipartConfigElement multipartConfigElement() {  
	        MultipartConfigFactory factory = new MultipartConfigFactory();  
	        //文件最大 KB,MB   
	        factory.setMaxFileSize("10240KB"); 
	        /// 设置总上传数据总大小  
	        factory.setMaxRequestSize("102400KB");  
	        return factory.createMultipartConfig();  
	    } 
}
