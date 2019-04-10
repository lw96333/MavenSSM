package com.one.servlet.disposalManagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.disposalManagement.Consultation_managementService;

/**
 *  Æ÷ÐµÒ»ÀÀ
 * @author Ö£
 *
 */
@WebServlet("/consultation_management")
public class Consultation_managementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Consultation_managementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PageBean pageBean = Consultation_managementService.getInstance().getShowConsultation_management(1, 5, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/consultation_management.jsp").forward(request, response);
		
	}

}
