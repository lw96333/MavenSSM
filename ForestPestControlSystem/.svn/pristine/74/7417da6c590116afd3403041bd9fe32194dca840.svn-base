package com.one.servlet.dataManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.dataManagement.InterDataManagementService;
@WebServlet("/QueryPestsList")
public class QueryPestsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public QueryPestsListServlet(){
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
		String queryName = req.getParameter("queryName");
		String queryHost = req.getParameter("queryHost");
		//System.out.println("²éÑ¯½á¹û£º"+queryHost+"****"+queryName);
		PageBean pageBean = InterDataManagementService.getInstance().getAllPestsBeanList(1, 5, queryName,queryHost);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("jsp/pestsList_management.jsp").forward(req, resp);
		
	}
}
