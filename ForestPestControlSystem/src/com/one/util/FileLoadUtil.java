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
 * ˵������servlet���ã����루�ļ�����Ҫ�ϴ���·�����ļ�������������
 * 
 * �ϴ��ļ���servlet��ȡ�����ݱ���ʹ��
 * 
 * for(FileItem item : list)����
 * 
 * @author student
 *
 * 
 * 
 */

public class FileLoadUtil {

	public static Map<String, String> uploadFile(List<FileItem> list, String path)  {

		// ����һ��mapyonglao������е�ֵ
		Map map = new HashMap();
		SpecialistManagementBean smb = new SpecialistManagementBean();
		int num = 1;
		for (FileItem fileItem : list) {

			// �ж��ļ�ѡ����ʲô����
			// isFormField �Ƿ��Ǽ򵥵ı�����
			if (fileItem.isFormField()) {
				// ��ñ��в�����
				String name = fileItem.getFieldName();
				// ��ñ���Ӧ��ֵ
				String value = "";
				try {
					value = fileItem.getString("utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				map.put(name, value);


			} else {

	
				// ����ļ�������
				String fileName = fileItem.getName();

				// System.out.println("�ļ����͵ı�"+ fileName);

				String ext = fileName.substring(fileName.lastIndexOf("."));

				String newFileName = System.currentTimeMillis() + ext;
				// �����µ�ͷ�������
				map.put("pic"+num, newFileName);

				String save_path = path + File.separator + newFileName;
				num++;
				// �ϴ��ļ���
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
