package com.java.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.bean.MobileBean;
import com.java.config.WebMvcConfig;
import com.java.entity.ExtendMobile;
import com.java.service.ExtendMobileService;
import com.java.util.ResponseData;


/**
 * <p>
 * 手机号码归属地 前端控制器
 * </p>
 *
 * @author J164
 * @since 2019-04-10
 */


@RestController
public class ExtendMobileController {
	
	@Autowired
	private ExtendMobileService extendMobileService;
	
	@PostMapping("selectMobile")	
	public ResponseData selectMobileByNum(String mobileNum,HttpServletRequest request) {

		ResponseData responseData = new ResponseData();
		ExtendMobile extendMobile = extendMobileService.getOne(
				new QueryWrapper<ExtendMobile>().eq("pre", mobileNum.substring(0,7)));
		responseData.getData().put("extendMobile", extendMobile);
		
		responseData.getData().put("time", WebMvcConfig.time);
		System.out.println("------------"+WebMvcConfig.time);
		return responseData;
	}
	
	@PostMapping("selectAllMobile")
	public ResponseData selectAllMobile(int pageNum,int pageSize) {
		
		ResponseData responseData = new ResponseData();
		Page<ExtendMobile> page = new Page<ExtendMobile>((pageNum/pageSize)+1,pageSize);
		
		IPage<ExtendMobile> pageBean = extendMobileService.page(page, new QueryWrapper<ExtendMobile>().or(false));
		responseData.getData().put("page", pageBean);
		return responseData;
	}
	
	@PostMapping("selectMobileForfigure")
	public ResponseData selectMobileForfigure() {
		ResponseData responseData = new ResponseData();
		List<MobileBean> li = extendMobileService.selectMobileByCity();
		responseData.getData().put("li", li);
		return responseData;
	}
	
	@PostMapping("down")
	public void down(int pageNum,int pageSize,HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		Page<ExtendMobile> page = new Page<ExtendMobile>(pageNum,pageSize);
		
		IPage<ExtendMobile> pageBean = extendMobileService.page(page, new QueryWrapper<ExtendMobile>().or(false));
		List<ExtendMobile> li = pageBean.getRecords();
		//创建HSSFWorkbook对象(excel的文档对象)  
		      HSSFWorkbook wb = new HSSFWorkbook(); 
		      //排数
		      int cellNum = 0;
			//建立新的sheet对象（excel的表单）  
			HSSFSheet sheet=wb.createSheet("事件记录");  
			//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
			
			HSSFRow row1=sheet.createRow(cellNum);  
			//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
			HSSFCell cell=row1.createCell(0);  
			      //设置单元格内容  
			cell.setCellValue("事件记录表");  
			//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
			sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));  
			//在sheet里创建第二行  
			HSSFRow row2=sheet.createRow(++cellNum);      
	        //创建单元格并设置单元格内容  
	        row2.createCell(0).setCellValue("手机号码前7位");  
	        row2.createCell(1).setCellValue("所在省");      
	        row2.createCell(2).setCellValue("所在市"); 
	        row2.createCell(3).setCellValue("地区编号");  
	        row2.createCell(4).setCellValue("邮编");  
	        row2.createCell(5).setCellValue("所属运营商");  
	       
	        for(int i=0;i<li.size();i++) {
	        	cellNum++;
	        	HSSFRow row=sheet.createRow(cellNum);
	        	row.createCell(0).setCellValue(li.get(i).getPre());  
	        	row.createCell(1).setCellValue(li.get(i).getProvice());
	        	row.createCell(2).setCellValue(li.get(i).getCity()); 
	        	row.createCell(3).setCellValue(li.get(i).getCode());  
	        	row.createCell(4).setCellValue(li.get(i).getProvice());  
	        	row.createCell(5).setCellValue(li.get(i).getOperators());  
	        }
	      
		      
		      
		    //输出Excel文件  
//	        FileOutputStream out = new FileOutputStream("数据统计");

	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=createList.xls");//默认Excel名称
	        response.flushBuffer();
	        OutputStream out = response.getOutputStream();
	        wb.write(out);
	        out.close();

		}
	
}
