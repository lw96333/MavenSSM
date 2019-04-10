package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.SmallClassService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;
import com.one.service.disasterPreventionAndControl.Imp.SmallClassServiceImp;

/**
 * Servlet implementation class AddSmallClassServlet
 */
@WebServlet("/addSmallClass")
public class AddSmallClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSmallClassServlet() {
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
		String areaName = request.getParameter("areaName");
		String smallClassName = request.getParameter("smallClassName");
		String personName = request.getParameter("personName");
		String personNum = request.getParameter("personNum");
		String personPhone = request.getParameter("personPhone");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SmallClassService smallService = new SmallClassServiceImp();
		List<SmallClassManagementBean> list = smallService.getAllSmallClassManagementByName();
		Gson gson = new Gson();
		String pageBean = null;
		boolean flag = true;
		for (SmallClassManagementBean smallClassManagementBean : list) {
			if(smallClassManagementBean.getName().equals(smallClassName)){
				pageBean = gson.toJson(2);
				response.getWriter().print(pageBean);
				flag = false;
				break;
			}
		}
		if(flag){
			if(areaName != null || smallClassName != null || personName != null || personNum != null ||  personPhone != null){
				SmallClassManagementBean small = new SmallClassManagementBean();
				small.setName(smallClassName.trim());
				small.setPersonPhone(personPhone.trim());
				small.setPersonNum(personNum.trim());
				small.setPersonName(personName.trim());
				AreaInBean area = new AreaInBean();
				area.setAreaId(Integer.parseInt(areaName));
				small.setAreaIn(area);
				small.setCreationTime(df.format(new Date()));
				int num = smallService.addSmallClass(small);
				if(num == 1){
					pageBean = gson.toJson(num);
					response.getWriter().print(pageBean);
				}
			}
		}

	}

}
