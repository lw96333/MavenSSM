package com.one.servlet.disposalManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.disposalManagement.Outgoing_managementService;

/**
 *  添加出库信息
 * @author 郑
 *
 */
@WebServlet("/outgoing_management")
public class Outgoing_managementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Outgoing_managementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageBean pageBean = Outgoing_managementService.getInstance().getShowOutGoing(1, 5, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/outgoing_management.jsp").forward(request, response);
	}

}
