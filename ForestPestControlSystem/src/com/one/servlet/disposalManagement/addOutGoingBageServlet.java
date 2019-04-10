package com.one.servlet.disposalManagement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.NameOfGoodsBean;
import com.one.bean.PestTypesBean;
import com.one.bean.TypeBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.bean.disposalManagement.Outgoing_managementBean;
import com.one.bean.systemInformation.User_Management_Bean;
import com.one.service.disposalManagement.Outgoing_managementService;

/**
 * Servlet implementation class addOutGoingBageServlet
 */
@WebServlet("/addOutGoingBage")
public class addOutGoingBageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOutGoingBageServlet() {
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

		String uNum = request.getParameter("num");
		String uPerson = request.getParameter("purpoose");
		User_Management_Bean upb = (User_Management_Bean)request.getSession().getAttribute("LoginUser");
		String uPersonName = upb.getName();
		String uTypeName = request.getParameter("typeName");
		String uType = request.getParameter("type");
		String uGoodsName= request.getParameter("goodsName");
		String uSmall = request.getParameter("small");
		
		Outgoing_managementBean omb = new Outgoing_managementBean();
		omb.setNum(Integer.parseInt(uNum));
		omb.setPurpoose(uPerson);
		omb.setPersonName(uPersonName);
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	     String date=df.format(new Date());// new Date()为获取当前系统时间
//		 System.out.println(uPersonName+"13123"); 
		 omb.setDate(date);
      
		
		PestTypesBean pb = new PestTypesBean();
		pb.setInsectId(Integer.parseInt(uType));
		omb.setInsect(pb);
		
		TypeBean tb = new TypeBean();
		tb.setTypeId(Integer.parseInt(uTypeName));
		omb.setType(tb);
		
		NameOfGoodsBean nob = new NameOfGoodsBean();
		nob.setGoodsId(Integer.parseInt(uGoodsName));
		omb.setGoods(nob);
		
		SmallClassManagementBean small = new SmallClassManagementBean();
		small.setId(Integer.parseInt(uSmall));
		omb.setId(small);
		
//		System.out.println(omb+"666666666666666666666");
		Outgoing_managementService.getInstance().addOutGoing(omb);
		response.sendRedirect("outgoing_management");
	}

}
