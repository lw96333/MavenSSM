package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.service.systemInformation.InterUserManagementBeanService;

@WebServlet("/showUserInfo")
public class showUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public showUserInfoServlet(){
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = req.getParameter("chonseId");
		User_Management_Bean ub =InterUserManagementBeanService.getInstance().showUser_Management_BeanInfoById(Integer.parseInt(str));
	    req.setAttribute("UserBean", ub);
	    req.getRequestDispatcher("jsp/modify_user.jsp").forward(req, resp);
	}
	
}
