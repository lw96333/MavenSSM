package com.my.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 * 上传文件页面控制器
 * @author 49160
 *
 */
@Controller
@RequestMapping("/user/")
public class FlieController {

	@RequestMapping(value="fileupload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request) {
		//获取请求参数
		String title = request.getParameter("title");
		System.out.println(title);
		//创建上传文件解析器
		CommonsMultipartResolver multipartResolver = 
				new CommonsMultipartResolver(request.getServletContext());
		//判断上传文件
		if(multipartResolver.isMultipart(request)) {
			//转换request类型为上传文件类型
			MultipartHttpServletRequest muRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = muRequest.getFileNames();
			while(iterator.hasNext()) {
				MultipartFile file = muRequest.getFile(iterator.next());
				if(file!=null) {
					//获取源文件名
					String fileName = file.getOriginalFilename();
					System.out.println(fileName);
					if(fileName!=null) {
						//写文件
						try {
							file.transferTo(new File("d:/"+fileName));
						} catch (IllegalStateException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
					}
				}
			}
			return "fileUploadOK";
		}
		
		return "../fileUpload";
	}
}
