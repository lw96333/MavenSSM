<%@page import="com.mist.chart.line.*"%>
<%@page import="com.mist.chart.pie.*"%>
<%@page import="com.mist.chart.bar.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
//柱状图 S
	String fileName=BarChart1.getBarChart(session);//垂直
	String fileName1=BarChart2.getBarChart2(session);//水平
	String fileName2=BarChart3.getBarChart3(session);//自定义 垂直
	String fileName3=BarChart4.getBarChart4(session);//自定义 垂直 多维数组
	String fileName4=BarChart5.getBarChart5(session);//自定义 垂直 多维数组
//柱状图  E
//饼状图 S
String fileName5=PieChart1.getPieChart(session);	
String fileName6=PieChart2.getPieChart2(session);
String fileName7=PieChart3.getPieChart3(session);
//折线图
String fileName8=LineChart1.getLineChart(session);	
String fileName9=LineChart2.getLineChart2(session);	
	
	System.out.println(fileName);
%>
<h1>柱状图</h1>
<img src="DisplayChart?filename=<%=fileName %>" width="700" height="500" border="0"/>
<img src="DisplayChart?filename=<%=fileName1 %>" width="700" height="500" border="0"/>
<img src="DisplayChart?filename=<%=fileName2 %>" width="700" height="500" border="0"/>
<img src="DisplayChart?filename=<%=fileName3%>" width="700" height="500" border="0"/>
<img src="DisplayChart?filename=<%=fileName4%>" width="700" height="500" border="0"/>
<h1>饼状图</h1>
<img alt="" src="DisplayChart?filename=<%=fileName5%>" width="700" height="500" border="0">
<img alt="" src="DisplayChart?filename=<%=fileName6%>" width="700" height="500" border="0">
<img alt="" src="DisplayChart?filename=<%=fileName7%>" width="700" height="500" border="0">
<h1>折线图</h1>
<img alt="" src="DisplayChart?filename=<%=fileName8%>" width="700" height="500" border="0">
<img alt="" src="DisplayChart?filename=<%=fileName9%>" width="700" height="500" border="0">
</body>
</html>