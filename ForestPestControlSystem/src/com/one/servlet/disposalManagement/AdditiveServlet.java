package com.one.servlet.disposalManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.DiseasesAndInsectPestsBean;
import com.one.bean.PestTypesBean;
import com.one.bean.dataManagement.PestsBean;
import com.one.bean.disposalManagement.Pharmacy_managementBean;
import com.one.service.dataManagement.InterDataManagementService;
import com.one.service.disposalManagement.Pharmacy_managementService;

/**
 * Servlet implementation class Additive
 */
@WebServlet("/additive")
public class AdditiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditiveServlet() {
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
		
		String uName = request.getParameter("name");
		String uInsect = request.getParameter("insect");
		String uDiseases = request.getParameter("diseases");
		String uTree = request.getParameter("tree");
	
//		测试前台页面获取的输入值 
//		  System.out.println(uName+"==111"+uInsect+"==222"+uDiseases+"==333"+uTree+"==");
		
		Pharmacy_managementBean pb = new Pharmacy_managementBean();
		pb.setName(uName);
		
		PestTypesBean pt = new PestTypesBean();
		pt.setInsectId(Integer.parseInt(uInsect));
		pb.setInsect(pt);
		
		DiseasesAndInsectPestsBean da = new DiseasesAndInsectPestsBean();
		da.setDiseasesId(Integer.parseInt(uDiseases));
		pb.setDiseases(da);
		
		pb.setTree(uTree);
		
		Pharmacy_managementService.getInstance().additive(pb);
		response.sendRedirect("pharmacy_management");
	}

}
