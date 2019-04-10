package com.java.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.log4j.Log4j;

/**
 * session监听器
 * @author 肖中华
 *
 * 2019年3月26日
 */
@Log4j
@WebListener
public class Sessionlistener implements HttpSessionListener{

	/**
	 * 记录session的数量
	 */
	private int num = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("session创建");
		Integer num=(Integer) arg0.getSession().getServletContext().getAttribute("session");
		if (num==null) {
			arg0.getSession().getServletContext().setAttribute("session", 1);
		}else {
			arg0.getSession().getServletContext().setAttribute("session",num.intValue()+1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		arg0.getSession().getServletContext().setAttribute("session", (Integer) arg0.getSession().getServletContext().getAttribute("session")-1);
		
		log.info("session销毁");
	}

}
