package com.one.servlet.dataManagement;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.dataManagement.RodentpestsBean;
import com.one.service.dataManagement.InterDataManagementService;

@WebServlet("/showRodentpestsBeanInfo")
public class showRodentpestsBeanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public showRodentpestsBeanInfoServlet() {
		// TODO Auto-generated constructor stub
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
		String str = req.getParameter("chonseId");
		System.out.println("选中查看信息的id= "+str);
		RodentpestsBean rb =InterDataManagementService.getInstance().showRodentpestsBeanInfoById(Integer.parseInt(str));
		String str2 = "http://"+req.getHeader("Host")+File.separator +"img"+File.separator + rb.getMousePic();
		rb.setMousePic(str2);
	    req.setAttribute("RodentpestsBean", rb);
	    req.getRequestDispatcher("jsp/showInfoOfRodentpests_informaation.jsp").forward(req, resp);
	}
}
