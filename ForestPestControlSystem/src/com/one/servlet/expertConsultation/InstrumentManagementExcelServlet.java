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
		//����HSSFWorkbook����(excel���ĵ�����)  
	      HSSFWorkbook wb = new HSSFWorkbook(); 
	      //����
	      int cellNum = 0;
		//�����µ�sheet����excel�ı���  
		HSSFSheet sheet=wb.createSheet("�¼���¼");  
		//��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��  
		
		HSSFRow row1=sheet.createRow(cellNum);  
		//������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��  
		HSSFCell cell=row1.createCell(0);  
		      //���õ�Ԫ������  
		cell.setCellValue("�¼���¼��");  
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������  
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));  
		//��sheet�ﴴ���ڶ���  
		HSSFRow row2=sheet.createRow(++cellNum);      
        //������Ԫ�����õ�Ԫ������  
        row2.createCell(0).setCellValue("�¼�����");  
        row2.createCell(1).setCellValue("����");      
        row2.createCell(2).setCellValue("����λ��"); 
        row2.createCell(3).setCellValue("���η���");  
        row2.createCell(4).setCellValue("����״̬");  
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
      
	      
	      
	    //���Excel�ļ�  
	    OutputStream output=response.getOutputStream();  
	    response.reset();  
	    response.setHeader("Content-disposition", "attachment; filename=details.xls");  
	    response.setContentType("application/msexcel");          
	    wb.write(output);  
	    output.close(); 
	}

}
