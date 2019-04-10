package com.one.servlet.dataManagement;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.dataManagement.DiseaseBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.service.dataManagement.InterDataManagementService;

@WebServlet("/showDiseasesInfo")
public class showDiseasesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public showDiseasesInfoServlet(){
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
	//	System.out.println("选中查看信息的id= "+str);
		DiseaseBean db =InterDataManagementService.getInstance().showDiseaseBeanInfoById(Integer.parseInt(str));
	   // System.out.println(db);
		String str2 = "http://"+req.getHeader("Host")+File.separator +"img"+File.separator + db.getDiseasePic();
		db.setDiseasePic(str2);
	    req.setAttribute("DiseaseBean", db);
	    req.getRequestDispatcher("jsp/showInfoOfDiseases_informaation.jsp").forward(req, resp);
	}
}
