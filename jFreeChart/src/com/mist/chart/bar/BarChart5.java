package com.mist.chart.bar;

import java.awt.Color;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

public class BarChart5 {
	public static String getBarChart5(HttpSession session) throws Exception {
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
		// 细调样式
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 显示每个柱的数值
		BarRenderer3D renderer3d = new BarRenderer3D();
		renderer3d
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer3d.setBaseItemLabelsVisible(true);// 显示柱子上方实时数据
		renderer3d.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer3d.setItemLabelAnchorOffset(10D);
		// 设置平行柱的之间距离
		renderer3d.setItemMargin(0.4);

		plot.setRenderer(renderer3d);// 渲染
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500,
				null, session);
		return fileName;
	}
}
