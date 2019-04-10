package com.one.servlet.systemInformation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.systemInformation.User_Management_Bean;
import com.one.bean.systemInformation.User_Privileges_Bean;
import com.one.service.systemInformation.InterUserManagementBeanService;

@WebServlet("/addUserBeanInfo")
public class addUserBeanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public addUserBeanInfoServlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("userName");
		String userPass1 = req.getParameter("userPass1");
		String userPass2 = req.getParameter("userPass2");
		String trueName = req.getParameter("trueName");
		String choice = req.getParameter("choice");
		if(userPass1.equals(userPass2)){
			User_Management_Bean ub = new User_Management_Bean();
			User_Privileges_Bean up = new User_Privileges_Bean();
			ub.setName(trueName);
			ub.setUserName(userName);
			ub.setPassword(userPass2);
			up.setPrivilegesId(Integer.parseInt(choice));
			ub.setPrivileges(up);
			InterUserManagementBeanService.getInstance().addUser_Management_Bean(ub);
		}
	//	System.out.println("choice"+choice+" "+userName+" "+userPass1+" "+trueName);
		req.getRequestDispatcher("user_management").forward(req, resp);
	}
}
