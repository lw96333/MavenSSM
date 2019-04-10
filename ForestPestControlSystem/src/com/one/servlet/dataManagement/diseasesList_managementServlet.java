package com.one.servlet.dataManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.dataManagement.InterDataManagementService;

@WebServlet("/diseasesList_management")
public class diseasesList_managementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public diseasesList_managementServlet(){
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
		PageBean pageBean = InterDataManagementService.getInstance().getAllDiseaseBeanList(1, 5, null,null);
		System.out.println(pageBean);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("jsp/diseasesList_management.jsp").forward(req, resp);
		
	}
}
