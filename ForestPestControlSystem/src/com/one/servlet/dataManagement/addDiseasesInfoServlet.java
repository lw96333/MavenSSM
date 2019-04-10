package com.one.servlet.dataManagement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.one.bean.dataManagement.DiseaseBean;
import com.one.service.dataManagement.InterDataManagementService;
import com.one.util.FileLoadUtil;
import com.one.util.ResizeImage;

@WebServlet("/addDiseasesInfo")
public class addDiseasesInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public addDiseasesInfoServlet(){
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
		// 创建工厂（这里用的是工厂模式）
				 DiskFileItemFactory factory = new DiskFileItemFactory();
				 // 创建一个新的文件上传处理程序
			      ServletFileUpload upload = new ServletFileUpload(factory);
			      Map<String,String> map = null;
		       	  // 3 解析请求对象, 获得文件选项
		       	try {
		       		List<FileItem> list = upload.parseRequest(request);
					map = FileLoadUtil.uploadFile(list, this.getServletContext().getInitParameter("Url"));
				} catch (FileUploadException e) {//D:\ADengJavaProject\ForestPestControlSystem\WebContent\images
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       	DiseaseBean db = new DiseaseBean();
		       	
		       	
		       	for(Map.Entry<String, String> entry : map.entrySet()){
		       		
		     		if(entry.getKey().equals("d-diseaseName")) {
		       			db.setDiseaseName(entry.getValue().trim());
		       		}
		     		else if(entry.getKey().equals("pic1")) {
		     			String outputFolder = this.getServletContext().getInitParameter("Url")+File.separator;
		                String fileName = this.getServletContext().getInitParameter("Url")+File.separator+entry.getValue();
		                ResizeImage r = new ResizeImage();
		                int toWidth=120;
		                int toHeight=105;
		                BufferedImage imageList = r.getImageList(fileName,new String[] {"jpg","png","gif"});
		                String uuid = UUID.randomUUID().toString();
		                uuid += ".jpg";
		                r.writeHighQuality(uuid,r.zoomImage(imageList,toWidth,toHeight),outputFolder);
		                File file = new File(outputFolder+entry.getValue());
		                file.delete();
		       		db.setDiseasePic(uuid);
		       		//System.out.println("tu pian lujin......"+entry.getValue());
		       		}
		     		else if(entry.getKey().equals("d-incidenceRegularity")) {		  
		       			db.setIncidenceRegularity(entry.getValue().trim());
		       		}
		     		else if(entry.getKey().equals("d-mainHazards")) {
		       			db.setMainHazards(entry.getValue().trim());
		       		}
		     		else if(entry.getKey().equals("d-onsetSymptom")) {
		       			db.setOnsetSymptom(entry.getValue().trim());
		       		}
		     		else if(entry.getKey().equals("d-pathology")) {
		       			db.setPathology(entry.getValue().trim());
		       		}
		     		else if(entry.getKey().equals("d-preventiveMeasures")) {
		       		db.setPreventiveMeasures(entry.getValue().trim());
		       		}
		       	}
		       	
		       	InterDataManagementService.getInstance().addDiseaseBean(db);
		       	
		       	request.getRequestDispatcher("diseasesList_management").forward(request, resp);
		       	
	/*	String dName = request.getParameter("d-diseaseName");
		String dpathology = request.getParameter("d-pathology");
		String donsetSymptom = request.getParameter("d-onsetSymptom");
		String dRegularity = request.getParameter("d-incidenceRegularity");
		String dmainHazards = request.getParameter("d-mainHazards");
		String dMeasures = request.getParameter("d-preventiveMeasures");
		String dpic = request.getParameter("uploadImgFile");
		db.setDiseaseName(dName);
		db.setDiseasePic(dpic);
		db.setIncidenceRegularity(dRegularity);
		db.setMainHazards(dmainHazards);
		db.setOnsetSymptom(donsetSymptom);
		db.setPathology(dpathology);
		db.setPreventiveMeasures(dMeasures);*/
	}
}
