package com.java.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.java.entity.Responsetime;
import com.java.service.ResponsetimeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 性能统计拦截器
 * @author 张冀川
 *
 * 2019年3月28日
 */
@Component
public class SessionInterceptor implements HandlerInterceptor{	
	
	@Autowired
	private ResponsetimeService responsetimeService;
	private long startTime;
	private long endTime;
	private String url;

	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    	url=request.getRequestURI();
        startTime=System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    	endTime=System.currentTimeMillis();
    	long over = endTime-startTime;
    	String name=String.valueOf(over);
    	Responsetime responsetime = new Responsetime();
   	 	responsetime.setName(url);
   	 	responsetime.setConsuming(name);
   	 	boolean size=responsetimeService.insert(responsetime);
    }
}
