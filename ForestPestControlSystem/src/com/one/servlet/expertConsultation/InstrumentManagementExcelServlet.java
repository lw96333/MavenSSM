package com.one.servlet.expertConsultation;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.one.bean.disasterPreventionAndControl.IncidentRecordBean;
import com.one.service.expertConsultation.IInstrumentManagementService;

/**
 * Servlet implementation class InstrumentManagementExcelServlet
 */
@WebServlet("/instrumentManagementExcel")
public class InstrumentManagementExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstrumentManagementExcelServlet() {
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
		List<IncidentRecordBean> li = IInstrumentManagementService.getInstance().getIncidentRecordForExcel();
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
        row2.createCell(0).setCellValue("事件名称");  
        row2.createCell(1).setCellValue("日期");      
        row2.createCell(2).setCellValue("发生位置"); 
        row2.createCell(3).setCellValue("防治方案");  
        row2.createCell(4).setCellValue("灾情状态");  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<li.size();i++) {
        	cellNum++;
        	HSSFRow row=sheet.createRow(cellNum);
        	row.createCell(0).setCellValue(li.get(i).getEventName());  
        	row.createCell(1).setCellValue(sdf.format(li.get(i).getTime()));
        	row.createCell(2).setCellValue(li.get(i).getSmallClass().getAreaIn().getName()); 
        	row.createCell(3).setCellValue(li.get(i).getControlMethod());  
        	row.createCell(4).setCellValue(li.get(i).getStage().getTypeName());  
        }
      
	      
	      
	    //输出Excel文件  
	    OutputStream output=response.getOutputStream();  
	    response.reset();  
	    response.setHeader("Content-disposition", "attachment; filename=details.xls");  
	    response.setContentType("application/msexcel");          
	    wb.write(output);  
	    output.close(); 
	}

}
