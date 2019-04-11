<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>CBD-后台系统</title>
	<link href="../general/style/authority/main_css.css" rel="stylesheet" type="text/css" />
	<link href="../general/style/authority/zTreeStyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../general/scripts/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../general/scripts/zTree/jquery.ztree.core-3.2.js"></script>
	<script type="text/javascript" src="../general/scripts/authority/commonAll.js"></script>
    <script type="text/javascript" src="../general/js/cdbJs.js"></script>

</head>
<body onload="getDate01()">
    <div id="top">
		<div id="top_logo">
			<img alt="logo" src="../general/images/common/logo.png" width="274" height="49" style="vertical-align:middle;width: 120px;height: 70px">
		</div>
		<div id="top_links">
			<div id="top_op">
				<ul>
					<li>
						<img alt="当前用户" src="../general/images/common/user.jpg">：
						<span>admin</span>
					</li>
					<li>
						<img alt="事务月份" src="../general/images/common/month.jpg">：
						<span id="yue_fen"></span>
					</li>
					<li>
						<img alt="今天是" src="../general/images/common/date.jpg">：
						<span id="day_day"></span>
					</li>
				</ul> 
			</div>
			<div id="top_close">
				<a href="javascript:void(0);" onclick="logout();" target="_parent">
					<img alt="退出系统" title="退出系统" src="../general/images/common/close.jpg" style="position: relative; top: 10px; left: 25px;">
				</a>
			</div>
		</div>
	</div>
    <!-- side menu start -->
	<div id="side">
		<div id="left_menu">
		 	<ul id="TabPage2" style="height:200px; margin-top:50px;">
				<li id="left_tab1" class="selected" onClick="javascript:switchTab('TabPage2','left_tab1');" title="业务模块">
					<img alt="业务模块" title="业务模块" src="../general/images/common/1_hover.jpg" width="33" height="31">
				</li>
				<li id="left_tab2" onClick="javascript:switchTab('TabPage2','left_tab2');" title="系统管理">
					<img alt="系统管理" title="系统管理" src="../general/images/common/2.jpg" width="33" height="31">
				</li>		
				<li id="left_tab3" onClick="javascript:switchTab('TabPage2','left_tab3');" title="其他">
					<img alt="其他" title="其他" src="../general/images/common/3.jpg" width="33" height="31">
				</li>
			</ul>
			
			
			<div id="nav_show" style="position:absolute; bottom:0px; padding:10px;">
				<a href="javascript:;" id="show_hide_btn">
					<img alt="显示/隐藏" title="显示/隐藏" src="../general/images/common/nav_hide.png" width="35" height="35">
				</a>
			</div>
		 </div>
		 <div id="left_menu_cnt">
		 	<div id="nav_module">
		 		<img src="../general/images/common/module_1.png" width="210" height="58"/>
		 	</div>
		 	<div id="nav_resource">
		 		<ul id="dleft_tab1" class="ztree"></ul>
		 	</div>
		 </div>
	</div>
	<div id="top_nav">
		<span id="here_area">当前位置：系统&nbsp;>&nbsp;系统介绍</span>
	</div>

    <!-- side menu start -->

	<div id="main">
		<!-- 默认显示主页-->
		<iframe name="right" id="rightMain" src="indexImg.jsp" frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true"/>
	</div>
</body>
</html>
   