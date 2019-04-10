package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.service.systemInformation.InterUserManagementBeanService;
@WebServlet("/user_managementPage")
public class user_managementPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public user_managementPageServlet(){
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
		PageBean page = InterUserManagementBeanService.getInstance().getAllUser_Management_Bean(Integer.parseInt(pageNum), Integer.parseInt(pageSize), null);
	//	System.out.println(page.getPageData().size()+"********");
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		resp.getWriter().print(pageBean);
	}
}
