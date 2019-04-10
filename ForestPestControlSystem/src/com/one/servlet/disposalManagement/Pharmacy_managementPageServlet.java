package com.one.servlet.disposalManagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.bean.disposalManagement.Consultation_managementBean;
import com.one.bean.disposalManagement.Pharmacy_managementBean;
import com.one.service.disposalManagement.Pharmacy_managementService;
import com.one.service.disposalManagement.imp.Pharmacy_managementServiceImp;

/**
 * Servlet implementation class Pharmacy_managementPageServlet
 */
@WebServlet("/pharmacy_managementPage")
public class Pharmacy_managementPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pharmacy_managementPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNum = request.getParameter("currPage");
		String pageSize = request.getParameter("pageSize");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
//		System.out.println(">>>>>>>>>>>>>>>");
//		System.out.println(type);
//		System.out.println(">>>>>>>>>>>>>>>");
		String diseasesType = request.getParameter("diseasesType");
//		Pharmacy_managementService pmt = new Pharmacy_managementServiceImp();
		
		if("".equals(name)) {
			name = null;
		}
		if("".equals(type)) {
			type = null;
		}
		if("".equals(diseasesType)) {
			diseasesType = null;
		}
		
		PageBean page = Pharmacy_managementService.getInstance().getShowPharmacy_management(Integer.parseInt(pageNum), Integer.parseInt(pageSize), name, type, diseasesType);
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
//		System.out.println(pageNum+"111111111111111111112222222"+pageSize);
		response.getWriter().print(pageBean);
	}

}
