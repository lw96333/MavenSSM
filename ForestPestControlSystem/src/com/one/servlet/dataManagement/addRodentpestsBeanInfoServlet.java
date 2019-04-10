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

import com.one.bean.dataManagement.RodentpestsBean;
import com.one.service.dataManagement.InterDataManagementService;
import com.one.util.FileLoadUtil;
import com.one.util.ResizeImage;
@WebServlet("/addRodentpestsBeanInfo")
public class addRodentpestsBeanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public addRodentpestsBeanInfoServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ���������������õ��ǹ���ģʽ��
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 // ����һ���µ��ļ��ϴ���������
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      Map<String,String> map = null;
      	  // 3 �����������, ����ļ�ѡ��
      	try {
      		List<FileItem> list = upload.parseRequest(request);
			map = FileLoadUtil.uploadFile(list, this.getServletContext().getInitParameter("Url"));
		} catch (FileUploadException e) {//D:\ADengJavaProject\ForestPestControlSystem\WebContent\images
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RodentpestsBean rb = new RodentpestsBean();
		for(Map.Entry<String, String> entry : map.entrySet()){
       		
     		if(entry.getKey().equals("mainHazards")) {
       			rb.setMainHazards(entry.getValue().trim());
       		}
     		else if(entry.getKey().equals("mouseFoot")) {
       		rb.setMouseFoot(entry.getValue().trim());
       		}
     		else if(entry.getKey().equals("mouseName")) {		  
       			rb.setMouseName(entry.getValue().trim());
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
                rb.setMousePic(uuid);
       		}
     		else if(entry.getKey().equals("naturalEnemy")) {
       			rb.setNaturalEnemy(entry.getValue().trim());
       		}
     		else if(entry.getKey().equals("preventiveMeasures")) {
       			rb.setPreventiveMeasures(entry.getValue().trim());
       		}
     		else if(entry.getKey().equals("reproduction")) {
       		rb.setReproduction(entry.getValue().trim());
       		}
       	}
		InterDataManagementService.getInstance().addRodentpestsBean(rb);
		request.getRequestDispatcher("rodentpestsList_management").forward(request, resp);
		
		/*
		String mName = request.getParameter("mouseName");
		String mFoot = request.getParameter("mouseFoot");
		String mtion = request.getParameter("reproduction");
		String mEnemy = request.getParameter("naturalEnemy");
		String mFile1 = request.getParameter("uploadImgFile");
		String mMeasures = request.getParameter("preventiveMeasures");
		String mHazards = request.getParameter("pestsmainHazards");
		
		RodentpestsBean rb = new RodentpestsBean();
		rb.setMouseName(mName);
		rb.setMainHazards(mHazards);
		rb.setMouseFoot(mFoot);
		rb.setMousePic(mFile1);
		rb.setNaturalEnemy(mEnemy);
		rb.setPreventiveMeasures(mMeasures);
		rb.setReproduction(mtion);
		*/
		
	}

}