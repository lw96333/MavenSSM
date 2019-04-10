package com.one.servlet.expertConsultation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.one.bean.PageBean;
import com.one.service.expertConsultation.ISpecialistServlce;

/**
 * Servlet implementation class SpecialistDeleteServlet
 */
@WebServlet("/specialistDelete")
public class SpecialistDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str = request.getParameter("chonseId");
		String[] strs = str.split(",");
		int[] arr = new int[strs.length];
		for(int i=0;i<strs.length;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int num = ISpecialistServlce.getInstance().deleteSpecialist(arr);
		PageBean page = ISpecialistServlce.getInstance().getAllSpecialist(1, 5, null, null, null,true);
		HttpSession session = request.getSession();
		Integer num2 = (Integer) session.getAttribute("total");
		if(num2 != null) {
			session.setAttribute("total", num2-strs.length);
		}
		Gson gson = new Gson();
		String pageBean = gson.toJson(page);
		response.getWriter().print(pageBean);
	}

}
