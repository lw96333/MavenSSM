package com.one.servlet.systemInformation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.dao.systemInformation.ILogDao;
import com.one.service.expertConsultation.ISpecialistServlce;
import com.one.service.systemInformation.ILogService;

/**
 * 	»’÷æ
 * Servlet implementation class LogServlet
 */
@WebServlet("/log")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
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
		PageBean pageBean = ILogService.getInstance().getAllLog(1, 5, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/log_list.jsp").forward(request, response);
	}

}
