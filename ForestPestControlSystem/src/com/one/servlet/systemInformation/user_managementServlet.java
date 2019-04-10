package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.bean.systemInformation.User_Management_Bean;
import com.one.service.systemInformation.InterUserManagementBeanService;

@WebServlet("/user_management")
public class user_managementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public user_managementServlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
		User_Management_Bean ub = (User_Management_Bean) req.getSession().getAttribute("LoginUser");
		//System.out.println("ub======"+ub);
	PageBean pageBean = InterUserManagementBeanService.getInstance().getAllUser_Management_Bean(1, 5, null);
	req.setAttribute("pageBean", pageBean);
	req.setAttribute("LoginUser", ub);
	//System.out.println(pageBean.getPageData().size()+"***222*****");
	req.getRequestDispatcher("jsp/user_management.jsp").forward(req, resp);
	
	
	}
}
