package com.one.servlet.disposalManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.one.bean.PageBean;
import com.one.service.disposalManagement.Pharmacy_managementService;

/**
 *  ÃÌº”“©º¡
 * @author ÷£
 *
 */
@WebServlet("/pharmacy_management")
public class Pharmacy_managementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Pharmacy_managementServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageBean pageBean = Pharmacy_managementService.getInstance().getShowPharmacy_management(1, 5, null, null, null);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("jsp/pharmacy_management.jsp").forward(request, response);
	}

}
