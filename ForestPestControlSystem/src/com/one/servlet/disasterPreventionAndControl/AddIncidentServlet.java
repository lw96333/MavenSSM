package com.one.servlet.disasterPreventionAndControl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.one.bean.DisasterStageBean;
import com.one.bean.DiscoveryPathBean;
import com.one.bean.PestTypesBean;
import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.bean.disasterPreventionAndControl.SmallClassManagementBean;
import com.one.service.disasterPreventionAndControl.IncidentService;
import com.one.service.disasterPreventionAndControl.Imp.IncidentServiceImp;
import com.one.util.FileLoadUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class AddIncidentServlet
 */
@WebServlet("/addIncident")
public class AddIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddIncidentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建工厂（这里用的是工厂模式）
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建一个新的文件上传处理程序
		ServletFileUpload upload = new ServletFileUpload(factory);
		Map<String, String> map = null;
		// 3 解析请求对象, 获得文件选项
		try {
			List<FileItem> list = upload.parseRequest(request);
			String outputFolder = this.getServletContext().getInitParameter("Url");
			map = FileLoadUtil.uploadFile(list, outputFolder);
		} catch (FileUploadException e) {// D:\ADengJavaProject\ForestPestControlSystem\WebContent\images"C:\\JAVAWEBHOMEWORK\\ForestPestControlSystem\\WebContent\\images"
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IncidentRecordBean incidentRecord = new IncidentRecordBean();
		for (Map.Entry<String, String> entry : map.entrySet()) {

			if (entry.getKey().equals("incidentName")) {
				incidentRecord.setEventName(entry.getValue().trim());
			} else if (entry.getKey().equals("influence")) {
				incidentRecord.setInfluence(entry.getValue().trim());
			} else if (entry.getKey().equals("time")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date timeDate = null;
				try {
					timeDate = sdf.parse(entry.getValue().trim());
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				incidentRecord.setTime(timeDate);
			} else if (entry.getKey().equals("pestType")) {
				String s = entry.getValue().trim();
				PestTypesBean pest = new PestTypesBean();
				pest.setInsectId(Integer.parseInt(s));
				incidentRecord.setPestType(pest);

			} else if (entry.getKey().equals("controlMethod")) {
				incidentRecord.setControlMethod(entry.getValue().trim());

			} else if (entry.getKey().equals("discovery")) {
				String s = entry.getValue().trim();
				DiscoveryPathBean discovery = new DiscoveryPathBean();
				discovery.setPathId(Integer.parseInt(s));
				incidentRecord.setDiscovery(discovery);

			} else if (entry.getKey().equals("areaName")) {
				String s = entry.getValue().trim();
				SmallClassManagementBean small = new SmallClassManagementBean();
				small.setId(Integer.parseInt(s));
				incidentRecord.setSmallClass(small);

			} else if (entry.getKey().equals("initialloss")) {
				
				incidentRecord.setInitialloss(entry.getValue().trim());

			} else if (entry.getKey().equals("stage")) {
				
				String s = entry.getValue().trim();
				DisasterStageBean stage = new DisasterStageBean();
				stage.setStageId(Integer.parseInt(s));
				incidentRecord.setStage(stage);

			} else if (entry.getKey().equals("disaster")) {
				
				incidentRecord.setDisaster(entry.getValue().trim());

			} else if (entry.getKey().equals("pic1")) {
				
				String file = entry.getValue().trim();
				incidentRecord.setPic(file);
			}
		}
		IncidentService inci = new IncidentServiceImp();
		inci.addIncidentRecord(incidentRecord);
		request.getRequestDispatcher("incident").forward(request, response);

	}

}
