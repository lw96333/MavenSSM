package com.one.servlet.expertConsultation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.service.expertConsultation.ISpecialistServlce;

/**
 * Servlet implementation class SpecialistUpdateServlet
 */
@WebServlet("/specialistUpdate")
public class SpecialistUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistUpdateServlet() {
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
		String id = request.getParameter("id");
		String newPost = request.getParameter("newPost");
		String newPhone = request.getParameter("newPhone");
		String newWorkUnit = request.getParameter("newWorkUnit");
		String newEmail = request.getParameter("newEmail");
		ISpecialistServlce iss = ISpecialistServlce.getInstance();
		iss.updateSpecialist(Integer.parseInt(id), newPhone,newWorkUnit , newPost, newEmail);
		request.getRequestDispatcher("specialistcheck?chonseId="+Integer.parseInt(id)).forward(request, response);
	}

}
