package com.one.servlet.dataManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.service.dataManagement.InterDataManagementService;
@WebServlet("/diseasesList_managementPage")
public class diseasesList_managementPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public diseasesList_managementPageServlet(){
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
		String pageNum = req.getParameter("currPage");
		String pageSize = req.getParameter("pageSize");
		PageBean page = InterDataManagementService.getInstance().getAllDiseaseBeanList(Integer.parseInt(pageNum), Integer.parseInt(pageSize), null,null);
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		resp.getWriter().print(pageBean);
	}
}
