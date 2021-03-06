package com.one.servlet.expertConsultation;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.service.expertConsultation.IInstrumentManagementService;

/**
 * 专家会商显示
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/instrument")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentServlet() {
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
		String id = request.getParameter("chonseId");
		IInstrumentManagementService ims = IInstrumentManagementService.getInstance();
		IncidentRecordBean irb = ims.getIncidentRecordById(Integer.parseInt(id));
		String str2 = "http://"+request.getHeader("Host")+File.separator +"img"+File.separator + irb.getPic();
		irb.setPic(str2);
		request.setAttribute("irb", irb);
		PageBean pageBean = ims.getInstrumentManagement(1, 5, Integer.parseInt(id));
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/specialist_consult.jsp").forward(request, response);
	}

}
