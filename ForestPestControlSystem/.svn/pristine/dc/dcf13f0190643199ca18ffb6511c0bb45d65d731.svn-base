package com.one.servlet.expertConsultation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.service.expertConsultation.IInstrumentManagementService;

/**
 * 专家会商事件一览显示
 * Servlet implementation class InstrumentManagementServlet
 */
@WebServlet("/instrumentManagement")
public class InstrumentManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentManagementServlet() {
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
		PageBean<List<IncidentRecordBean>> pageBean = IInstrumentManagementService.getInstance().getIncidentRecordByStageId(1, 5);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/instrument_management.jsp").forward(request, response);
	}

}
