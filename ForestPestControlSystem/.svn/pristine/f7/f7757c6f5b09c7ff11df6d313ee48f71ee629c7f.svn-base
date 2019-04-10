package com.one.servlet.expertConsultation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.service.expertConsultation.IInstrumentManagementService;

/**
 * 专家会商显示
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/instrumentPage")
public class InstrumentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentPageServlet() {
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
		String id = request.getParameter("id");
		IInstrumentManagementService ims = IInstrumentManagementService.getInstance();

		PageBean page = ims.getInstrumentManagement(Integer.parseInt(pageNum), Integer.parseInt(pageSize), Integer.parseInt(id));
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		response.getWriter().print(pageBean);
	}

}
