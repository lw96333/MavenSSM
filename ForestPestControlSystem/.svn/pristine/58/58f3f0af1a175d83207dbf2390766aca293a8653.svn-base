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
import com.one.dao.disasterPreventionAndControl.SmallClassManagementDao;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.SmallClassService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;
import com.one.service.disasterPreventionAndControl.Imp.SmallClassServiceImp;

/**
 * Servlet implementation class SmallClassServlet
 */
@WebServlet("/smallClass")
public class SmallClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmallClassServlet() {
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
		request.getSession().setAttribute("areaIn", list);
		
		SmallClassService smallClass = new SmallClassServiceImp();
		PageBean<List<SmallClassManagementBean>> pageBean = smallClass.getAllSmallClassManagement(1, 5, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/small_class_management.jsp").forward(request,response);
	}

}
