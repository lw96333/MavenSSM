package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;

/**
 * Servlet implementation class AddSmallClassServlet
 */
@WebServlet("/showArea")
public class ShowAreaByAddSmallClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAreaByAddSmallClassServlet() {
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
		AreaInService area = new  AreaInServiceImp();
		List<AreaInBean> list = area.getAreaInBySmall();
		request.setAttribute("areaIn", list);
		request.getRequestDispatcher("jsp/add_small_class.jsp").forward(request,response);
	}

}
