package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.service.systemInformation.ILogService;

/**
 * 	»’÷æ
 * Servlet implementation class LogServlet
 */
@WebServlet("/logPage")
public class LogPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogPageServlet() {
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
		String startDate = request.getParameter("stratDate");
		String endDate = request.getParameter("endDate");
		if(startDate==null || "".equals(startDate)) {
			startDate = null;
		}
		if(endDate==null || "".equals(endDate)) {
			endDate = null;
		}
		PageBean page = ILogService.getInstance().getAllLog(Integer.parseInt(pageNum), Integer.parseInt(pageSize), startDate, endDate);
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		response.getWriter().print(pageBean);
	}

}
