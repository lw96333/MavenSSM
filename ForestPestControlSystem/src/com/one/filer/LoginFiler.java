package com.one.filer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.one.bean.systemInformation.User_Management_Bean;

/**
 * Servlet Filter implementation class LoginFiler
 */
@WebFilter("/*")
public class LoginFiler implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFiler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//����û������uri
		String uri = httpServletRequest.getRequestURI();

		String[] exes = uri.split("\\.");
		String exe = exes[exes.length-1];
		if("/ForestPestControlSystem/jsp/login.jsp".equals(uri)||
				"/ForestPestControlSystem/login".equals(uri)||
				"css".equals(exe)||"js".equals(exe)||"png".equals(exe)||"jpg".equals(exe)) {
			chain.doFilter(request, response);			
		}else {
			HttpSession session = httpServletRequest.getSession();
			User_Management_Bean umb = (User_Management_Bean) session.getAttribute("LoginUser");
			if(umb==null){
				((HttpServletResponse)response).sendRedirect("/ForestPestControlSystem/jsp/login.jsp");
			}else {
				session.setAttribute("UserJurisdiction", umb.getPrivileges().getPrivilegesId()+"");
				chain.doFilter(request, response);	
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
