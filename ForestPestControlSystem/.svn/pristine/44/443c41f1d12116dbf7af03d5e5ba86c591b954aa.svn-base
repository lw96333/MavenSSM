package com.one.servlet.expertConsultation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.service.expertConsultation.ISpecialistServlce;

/**
 * Servlet implementation class SpecialistPageServlet
 */
@WebServlet("/specialistPage")
public class SpecialistPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistPageServlet() {
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
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("currPage");
		String pageSize = request.getParameter("pageSize");
		String queryName = request.getParameter("queryName");
		String queryExpertise = request.getParameter("queryExpertise");
		String queryWorkUnit = request.getParameter("queryWorkUnit");
		String falgStr = request.getParameter("falg");
		boolean falg = true;
		if("".equals(queryName)) {
			queryName = null;
		}else {
			queryName = queryName.trim();
		}
		if("".equals(queryExpertise)) {
			queryExpertise = null;
		}else {
			queryExpertise = queryExpertise.trim();
		}
		if("".equals(queryWorkUnit)) {
			queryWorkUnit = null;
		}else {
			queryWorkUnit = queryWorkUnit.trim();
		}
		if("".equals(falgStr)) {
			falg = false;
		}
		PageBean page = ISpecialistServlce.getInstance().getAllSpecialist(Integer.parseInt(pageNum), Integer.parseInt(pageSize), queryName, queryExpertise, queryWorkUnit,falg);
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		response.getWriter().print(pageBean);
	}

}
