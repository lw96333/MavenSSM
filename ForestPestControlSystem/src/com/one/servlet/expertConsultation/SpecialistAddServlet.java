package com.one.servlet.expertConsultation;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.one.bean.expertConsultation.SpecialistManagementBean;
import com.one.service.expertConsultation.ISpecialistServlce;
import com.one.util.FileLoadUtil;
import com.one.util.ResizeImage;

/**
 * 	添加专家
 * Servlet implementation class SpecialistAddServlet
 */
@WebServlet("/specialistAdd")
public class SpecialistAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialistAddServlet() {
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
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	SpecialistManagementBean smb = new SpecialistManagementBean();
       	for(Map.Entry<String, String> entry : map.entrySet()) {
       		if(entry.getKey().equals("pic1")) {
       		 String outputFolder = this.getServletContext().getInitParameter("Url")+File.separator;
             String fileName = this.getServletContext().getInitParameter("Url")+File.separator+entry.getValue();
             ResizeImage r = new ResizeImage();
             int toWidth=72;
             int toHeight=105;
             BufferedImage imageList = r.getImageList(fileName,new String[] {"jpg","png","gif"});
             String uuid = UUID.randomUUID().toString();
             uuid += ".jpg";
             r.writeHighQuality(uuid,r.zoomImage(imageList,toWidth,toHeight),outputFolder);
             File file = new File(outputFolder+entry.getValue());
             file.delete();
       			smb.setPic(uuid);
       		}else if(entry.getKey().equals("name")) {
       			smb.setName(entry.getValue());
       		}else if(entry.getKey().equals("gender")) {
       			smb.setGender(entry.getValue().equals("0")?true:false);
       		}else if(entry.getKey().equals("bithday")) {
       			String str = entry.getValue();
       			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       			java.util.Date date = null;
				try {
					date = sdf.parse(str);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       			smb.setBithday(new Date(date.getTime()));
       		}else if(entry.getKey().equals("expertise")) {
       			smb.setExpertise(entry.getValue());
       		}else if(entry.getKey().equals("post")) {
       			smb.setPost(entry.getValue());
       		}else if(entry.getKey().equals("phone")) {
       			smb.setPhone(entry.getValue());
       		}else if(entry.getKey().equals("workUnit")) {
       			smb.setWorkUnit(entry.getValue());
       		}else if(entry.getKey().equals("path")) {
       			smb.setPath(entry.getValue());
       		}else if(entry.getKey().equals("email")) {
       			smb.setEmail(entry.getValue());
       		}
       	}
       	ISpecialistServlce.getInstance().addSpecialist(smb);
       	response.sendRedirect("specialist");
	}
}
