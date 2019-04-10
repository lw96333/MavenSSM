package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;
//import com.one.service.disposalManagement.DisposalManagementService;

/**
 * Servlet implementation class AreaInServlet
 */
@WebServlet("/areaInPage")
public class AreaInPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaInPageServlet() {
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
		String name = request.getParameter("areaName");
		String advantage = request.getParameter("forest");
		System.out.println(pageNum +"------------" + pageSize);
		AreaInService area = new AreaInServiceImp();
		if(pageNum != null && pageSize != null){
			
			PageBean<List<AreaInBean>> page = area.getAllAreaIn(Integer.parseInt(pageNum), Integer.parseInt(pageSize), name, advantage);
			Gson gson = new Gson();
			String pageBean = gson.toJson(page);
			response.getWriter().print(pageBean);
		}
	}

}
