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
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.SmallClassService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;
import com.one.service.disasterPreventionAndControl.Imp.SmallClassServiceImp;

/**
 * Servlet implementation class SmallClassPageServlet
 */
@WebServlet("/smallClassPage")
public class SmallClassPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SmallClassPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageNum = request.getParameter("currPage");
		String pageSize = request.getParameter("pageSize");
		String smallClassName = request.getParameter("smallClassName");
		String areaName = request.getParameter("areaName");
		SmallClassService small = new SmallClassServiceImp();
		if (pageNum != null && pageSize != null) {

			PageBean<List<SmallClassManagementBean>> page = small.getAllSmallClassManagement(Integer.parseInt(pageNum),
					Integer.parseInt(pageSize), smallClassName, areaName);
			Gson gson = new Gson();
			String pageBean = gson.toJson(page);
			System.out.println(page);
			response.getWriter().print(pageBean);
		}
	}

}
