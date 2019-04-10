package com.one.servlet.disasterPreventionAndControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.one.bean.LandClassBean;
import com.one.bean.disasterPreventionAndControl.AreaInBean;
import com.one.service.disasterPreventionAndControl.AreaInService;
import com.one.service.disasterPreventionAndControl.Imp.AreaInServiceImp;

/**
 * Servlet implementation class AddAreaServler
 */
@WebServlet("/addArea")
public class AddAreaServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAreaServler() {
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
		String areaForest = request.getParameter("areaForest");
		String areaAdvantage = request.getParameter("areaAdvantage");
		String linDi = request.getParameter("linDi");
		AreaInService areaIn = new AreaInServiceImp();
		List<AreaInBean> list = areaIn.getAreaInByName();
		Gson gson = new Gson();
		String pageBean = null;
		boolean flag = true;
		for (AreaInBean areaInBean : list) {
			if(areaInBean.getName().equals(areaName)){
				pageBean = gson.toJson(2);
				response.getWriter().print(pageBean);
				flag = false;
				break;
			}
		}
		if(flag){
			if(areaName != null && areaForest != null && areaAdvantage != null && linDi != null){
				AreaInBean area = new AreaInBean();
				area.setName(areaName.trim());
				area.setForest(areaForest.trim());
				LandClassBean land = new LandClassBean();
				land.setLandId(Integer.parseInt(linDi));
				area.setLinDi(land);
				area.setAdvantage(areaAdvantage);
				int isAdd = areaIn.addAreaIn(area);
				if(isAdd == 1){
					pageBean = gson.toJson(isAdd);
					response.getWriter().print(pageBean);
				}
			}
		}
	
	}

}
