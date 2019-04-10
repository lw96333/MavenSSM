package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.service.disasterPreventionAndControl.IncidentService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;
import com.one.service.disasterPreventionAndControl.Imp.IncidentServiceImp;

/**
 * Servlet implementation class IncidentServlet
 */
@WebServlet("/incident")
public class IncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncidentServlet() {
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
		IncidentService inci = new IncidentServiceImp();
		PageBean<List<IncidentRecordBean>> pageBean = inci.getAllIncidentRecord(1, 5, null, null,null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/incident_record.jsp").forward(request,response);
	}

}
