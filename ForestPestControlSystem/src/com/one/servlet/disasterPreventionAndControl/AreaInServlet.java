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
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.dataManagement.InterDataManagementService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;

/**
 * Servlet implementation class AreaInServlet
 */
@WebServlet("/areaIn")
public class AreaInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaInServlet() {
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
		AreaInServiceImp area = new AreaInServiceImp();
		PageBean<List<AreaInBean>> pageBean = area.getAllAreaIn(1, 5, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/area_in.jsp").forward(request,response);
	}

}
