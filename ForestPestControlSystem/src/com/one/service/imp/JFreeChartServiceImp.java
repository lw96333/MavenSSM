package com.one.service.imp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import com.one.bean.CompanyBean;
import com.one.dao.expertConsultation.ISpecialistDao;
import com.one.service.IJFreeChartService;
import com.one.util.MybatisUtil;

public class JFreeChartServiceImp implements IJFreeChartService{

	@Override
	public String getBarChart(HttpSession session) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSession();
		ISpecialistDao sd = sqlSession.getMapper(ISpecialistDao.class);
		List<CompanyBean> li = sd.getAllCompany();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<li.size();i++) {
			dataset.addValue(li.get(i).getPersonNum(), "公司", li.get(i).getName());			
		}

		JFreeChart chart = ChartFactory.createBarChart3D("公司人员统计", "公司", "人数",
				dataset, PlotOrientation.VERTICAL, true, true, true);
		String fileName = "";
		try {
			fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500,
					null, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

}
