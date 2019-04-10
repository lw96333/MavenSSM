package com.one.servlet.dataManagement;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.dataManagement.PestsBean;
import com.one.service.dataManagement.InterDataManagementService;

@WebServlet("/showPestsInfo")
public class showPestsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public showPestsInfoServlet(){
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
		PestsBean pb =InterDataManagementService.getInstance().showPestsInfoById(Integer.parseInt(str));
		String str2 = "http://"+req.getHeader("Host")+File.separator +"img"+File.separator + pb.getAduitPic();
		String str3 = "http://"+req.getHeader("Host")+File.separator +"img"+File.separator + pb.getLarvaPic();
		pb.setAduitPic(str2);
		pb.setLarvaPic(str3);
	    req.setAttribute("PestsBean", pb);
	    req.getRequestDispatcher("jsp/showInfoOfpests_informaation.jsp").forward(req, resp);
	}
}
