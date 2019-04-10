package com.one.servlet.expertConsultation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.one.bean.PageBean;
import com.one.service.expertConsultation.ISpecialistServlce;

/**
 * Servlet implementation class SpecialistServlet
 */
@WebServlet("/specialist")
public class SpecialistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistServlet() {
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
		
		PageBean pageBean = ISpecialistServlce.getInstance().getAllSpecialist(1, 5, null, null, null,true);
		request.setAttribute("pageBean", pageBean);
		HttpSession session = request.getSession();
		Integer num = (Integer) session.getAttribute("total");
		if(num != null) {
			if(pageBean.getTotalData()-num==1) {
				request.setAttribute("add", "ok");
			}
		}
		session.setAttribute("total", pageBean.getTotalData());			

		request.getRequestDispatcher("jsp/specialist_management.jsp").forward(request, response);
	}

}
