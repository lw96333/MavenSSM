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
 * Servlet implementation class UpdataSmallClassServlet
 */
@WebServlet("/updataSmallClass")
public class UpdataSmallClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataSmallClassServlet() {
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
		
		String personName = request.getParameter("personName");
		String personPhone = request.getParameter("personPhone");
		String smallId = request.getParameter("smallId");
		if(personPhone != null && personName != null){
			SmallClassManagementBean small = new SmallClassManagementBean();
			small.setId(Integer.parseInt(smallId));
			small.setPersonName(personName.trim());
			small.setPersonPhone(personPhone.trim());
			SmallClassService smallService = new SmallClassServiceImp();
			int isUpdate = smallService.updateSmallClassById(small);
			if(isUpdate == 1){
				Gson gson = new Gson();
				String pageBean = gson.toJson(isUpdate);
				response.getWriter().print(pageBean);
			}
		}
	}

}









