package com.one.servlet.expertConsultation;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.service.expertConsultation.ISpecialistServlce;

/**
 * Servlet implementation class SpecialistCheckServlet
 */
@WebServlet("/specialistcheck")
public class SpecialistCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistCheckServlet() {
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
		String str = request.getParameter("chonseId");
		SpecialistManagementBean smb = ISpecialistServlce.getInstance().getSpecialist(Integer.parseInt(str));
		
		String str2 = "http://"+request.getHeader("Host")+File.separator +"img"+File.separator + smb.getPic();
		smb.setPic(str2);
		request.setAttribute("specialist", smb);
		request.getRequestDispatcher("jsp/check_specialist.jsp").forward(request, response);
	}

}
