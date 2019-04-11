package com.mist.chart.bar;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class BarChart4 {
	public static String getBarChart4(HttpSession session) throws Exception {
		// 自定义，不使用默认的
		double[][] data = new double[][] { { 1320, 500, 800, 700 },
				{ 750, 800, 900, 950 }, { 800, 600, 900, 1300 },
				{ 600, 560, 500, 900 } };
		String[] rowKeys = { "苹果", "香蕉", "橘子", "梨子" };
		String[] columnKeys = { "江西", "北京", "上海", "深圳" };
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				rowKeys, columnKeys, data);

		JFreeChart chart = ChartFactory.createBarChart3D("水果销售统计图", "水果", "销售",
				dataset, PlotOrientation.VERTICAL, true, true, true);
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500,
				null, session);
		return fileName;
	}
}
