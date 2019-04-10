package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.systemInformation.InterUserManagementBeanService;


@WebServlet("/QueryUserInfo")
public class QueryUserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public QueryUserInfoServlet(){
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryId = req.getParameter("queryId");
		System.out.println("queryId"+queryId);
		PageBean pageBean = InterUserManagementBeanService.getInstance().getAllUser_Management_BeanByCondition(1, 5, Integer.parseInt(queryId));
		req.setAttribute("pageBean", pageBean);
		//System.out.println(pageBean.getPageData().size()+"***222*****");
		req.getRequestDispatcher("jsp/user_management.jsp").forward(req, resp);
	}
	
}
