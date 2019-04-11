package com.mist.chart.pie;

import java.awt.Font;
import java.text.NumberFormat;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 饼状图pie
 * 
 * @author Administrator
 * 
 */
public class PieChart1 {

	public static String getPieChart(HttpSession session) throws Exception {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("QQ", 1000);
		dataset.setValue("微信", 1200);
		dataset.setValue("陌陌", 400);
		dataset.setValue("飞信", 100);
		dataset.setValue("其他", 29);

		JFreeChart chart = ChartFactory.createPieChart("社交软件下载量统计图", dataset,
				true, true, true);

		// 副标题
		chart.addSubtitle(new TextTitle("2016年度（单位/万）"));

		PiePlot pieplot = (PiePlot) chart.getPlot();
		pieplot.setLabelFont(new Font("宋体", 0, 11));
		// 设置饼图是圆的（true），还是椭圆的（false）；默认为true
		pieplot.setCircular(true);
		// 没有数据的时候显示的内容
		pieplot.setNoDataMessage("无数据显示");
		StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator(
				"{0}:({1}.{2})", NumberFormat.getNumberInstance(),
				NumberFormat.getPercentInstance());
		pieplot.setLabelGenerator(standarPieIG);
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 500,
				null, session);

		return fileName;
	}
}
