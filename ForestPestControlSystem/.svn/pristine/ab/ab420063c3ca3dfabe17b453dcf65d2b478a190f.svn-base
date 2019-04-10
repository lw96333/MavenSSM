package com.one.servlet.disposalManagement;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.service.disposalManagement.Outgoing_managementService;

/**
 * Servlet implementation class addOutGoing
 */
@WebServlet("/addOutGoing")
public class addOutGoingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOutGoingServlet() {
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
		Map<String,Object> map = Outgoing_managementService.getInstance().getAll();
		request.setAttribute("name", map.get("name"));
		request.setAttribute("PestType", map.get("PestType"));
		request.setAttribute("small", map.get("small"));
		request.setAttribute("type", map.get("type"));
		
		
		
		
//		System.out.println(map.get("small")+"1111111111111111111111111111111");
//		System.out.println(map.get("PestType")+"1111111111111111111111111111111");
		request.getRequestDispatcher("jsp/addOutGoing.jsp").forward(request, response);
		
	}

}
