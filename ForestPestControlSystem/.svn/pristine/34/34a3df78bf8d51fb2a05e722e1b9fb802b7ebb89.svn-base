package com.one.servlet.expertConsultation;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.bean.expertConsultation.InstrumentManagementBean;
import com.one.service.expertConsultation.IInstrumentManagementService;

/**
 * Servlet implementation class InstrumentAddServlet
 */
@WebServlet("/instrumentAdd")
public class InstrumentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentAddServlet() {
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
		String persons = request.getParameter("persons");
		String result = request.getParameter("result");
		String id = request.getParameter("id");
		IInstrumentManagementService ims = IInstrumentManagementService.getInstance();
		IncidentRecordBean irb = ims.getIncidentRecordById(Integer.parseInt(id));
		InstrumentManagementBean imb = new InstrumentManagementBean();
		imb.setPersons(persons);
		imb.setIncidentRecord(irb);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(new java.util.Date());
		try {
			imb.setDate(new Date(sdf.parse(str).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imb.setResult(result);
		ims.addInstrumentManagement(imb);
		PageBean page = ims.getInstrumentManagement(1, 5, Integer.parseInt(id));
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		response.getWriter().print(pageBean);
	}

}
