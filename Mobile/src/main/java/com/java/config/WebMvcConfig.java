package com.java.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * 加载过滤器和拦截器
 * @author 罗维
 *
 * 2019年3月27日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	public static long time;
	private long startTime;
	private long endTime;
	 /**
	  * 加载拦截器
	  */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	HandlerInterceptor handler = new HandlerInterceptor() {
			
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				// TODO Auto-generated method stub
				startTime=System.currentTimeMillis();
				return true;
			}
			
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// TODO Auto-generated method stub
				endTime=System.currentTimeMillis();
				time = endTime-startTime;
				System.out.println("++++++++++++++"+time);
				Cookie cook = new Cookie("time",endTime-startTime+"");
				response.addCookie(cook);
			}
		};
		registry.addInterceptor(handler).addPathPatterns("/selectMobile");
    }
   


}