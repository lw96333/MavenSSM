package com.one.servlet.systemInformation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.service.systemInformation.InterUserManagementBeanService;

@WebServlet("/updateUserBeanInfo")
public class updateUserBeanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public updateUserBeanInfoServlet(){
	super();
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doPost(req, resp);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String id = request.getParameter("id");
	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	String choice = request.getParameter("choice");
//	System.out.println("id="+id+"pw"+pass1+"wj"+choice);
	if(pass1.equals(pass2)){
	Map<String,Object> map = new HashMap();
	map.put("npwd", pass1);
	map.put("privilegesId", Integer.parseInt(choice));
	map.put("userId", Integer.parseInt(id));
	InterUserManagementBeanService.getInstance().updateUser_Management_Bean(map);
	}
	request.getRequestDispatcher("user_management").forward(request, resp);
}
}
