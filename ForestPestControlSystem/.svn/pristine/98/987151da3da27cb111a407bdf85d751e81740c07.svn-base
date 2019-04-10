package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.service.disasterPreventionAndControl.IncidentService;
import com.one.service.disasterPreventionAndControl.Imp.IncidentServiceImp;

/**
 * Servlet implementation class ApplyForExpertServlet
 */
@WebServlet("/applyFor")
public class ApplyForExpertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyForExpertServlet() {
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
		String inciId = request.getParameter("chonseId");
		if(inciId != null){
			
			IncidentService inci = new IncidentServiceImp();
			int applyFor = inci.applyForExpertReview(Integer.parseInt(inciId));
			if(applyFor == 1){
				request.getRequestDispatcher("incident").forward(request, response);
			}
		}
		
	}

}
