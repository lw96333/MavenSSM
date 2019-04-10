package com.one.servlet.dataManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.dataManagement.InterDataManagementService;

@WebServlet("/QueryDiseasesList")
public class QueryDiseasesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public QueryDiseasesListServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryName = req.getParameter("queryName");
		String querySymptom = req.getParameter("querySymptom");
		PageBean pageBean = InterDataManagementService.getInstance().getAllDiseaseBeanList(1, 5, queryName,querySymptom);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("jsp/diseasesList_management.jsp").forward(req, resp);
	}
}
