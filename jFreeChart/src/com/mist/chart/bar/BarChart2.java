package com.mist.chart.bar;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart2 {
	public static String getBarChart2(HttpSession session) throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(510, "江西", "香蕉");
		dataset.addValue(320, "江西", "苹果");
		dataset.addValue(580, "江西", "橘子");
		dataset.addValue(400, "江西", "梨子");
		JFreeChart chart = ChartFactory.createBarChart3D("水果销售统计图", "水果", "销售",
				dataset, PlotOrientation.HORIZONTAL, true, true, true);
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500,
				null, session);

		return fileName;
	}
}
