package com.one.util;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.one.bean.expertConsultation.SpecialistManagementBean;

/**
 * 
 * 说明：由servlet调用，传入（文件流，要上传的路径，文件名）三个参数
 * 
 * 上传文件的servlet获取表单数据必须使用
 * 
 * for(FileItem item : list)方法
 * 
 * @author student
 *
 * 
 * 
 */

public class FileLoadUtil {

	public static Map<String, String> uploadFile(List<FileItem> list, String path)  {

		// 创建一个mapyonglao保存表单中的值
		Map map = new HashMap();
		SpecialistManagementBean smb = new SpecialistManagementBean();
		int num = 1;
		for (FileItem fileItem : list) {

			// 判断文件选项是什么类型
			// isFormField 是否是简单的表单数据
			if (fileItem.isFormField()) {
				// 获得表单中参数名
				String name = fileItem.getFieldName();
				// 获得表单对应的值
				String value = "";
				try {
					value = fileItem.getString("utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				map.put(name, value);


			} else {

	
				// 获得文件的名字
				String fileName = fileItem.getName();

				// System.out.println("文件类型的表单"+ fileName);

				String ext = fileName.substring(fileName.lastIndexOf("."));

				String newFileName = System.currentTimeMillis() + ext;
				// 保存新的头像的名字
				map.put("pic"+num, newFileName);

				String save_path = path + File.separator + newFileName;
				num++;
				// 上传文件了
				try {
					fileItem.write(new File(save_path));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return map;

	}

}
