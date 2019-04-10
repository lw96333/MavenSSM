package com.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.java.shiro.LoginInterceptor;
import com.java.util.SessionInterceptor;


/**
 * 加载过滤器和拦截器
 * @author 罗维
 *
 * 2019年3月27日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private SessionInterceptor session;
	@Autowired
	private LoginInterceptor login;
	 /**
	  * 加载拦截器
	  */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    	
        registry.addInterceptor(login).addPathPatterns("/**");
        registry.addInterceptor(session).addPathPatterns("/**");
    }
    /**
     * 加载过滤器
     * @return
     */
//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new LoginFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("LogCostFilter");
//        registration.setOrder(1);
//        return registration;
//    }


}