package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.disasterPreventionAndControl.SmallClassService;
import com.one.service.disasterPreventionAndControl.Imp.SmallClassServiceImp;

/**
 * Servlet implementation class QuerySmallClassByIdServlet
 */
@WebServlet("/querySmallClassById")
public class QuerySmallClassByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerySmallClassByIdServlet() {
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
		String smallClassId = request.getParameter("smallClassId");
		if(smallClassId != null){
			SmallClassService small = new SmallClassServiceImp();
			SmallClassManagementBean smallClass = small.getSmallClassInfoById(Integer.parseInt(smallClassId));
			Gson gson = new Gson();
			String pageBean = gson.toJson(smallClass);
			response.getWriter().print(pageBean);
		}
	}

}
