<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<base href=<%=basePath %>/>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
	<link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/pagination.css" />
	
	<title>查看企业用户</title>
</head>
<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 企业用户管理 <span class="c-gray en">&gt;</span> 查看企业用户<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div>
			企业名称&nbsp;&nbsp;<input id="enterpriename" class="input-text" style="width: 180px;">
			企业联系人&nbsp;&nbsp;<input id="contactperson" class="input-text" style="width: 180px;">
			联系电话&nbsp;&nbsp;<input id="phone" class="input-text" style="width: 180px;">
			所在楼层&nbsp;&nbsp;<input id="floor" class="input-text" style="width: 180px;">
			&nbsp;&nbsp;&nbsp;<button type="button" id="submit" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> </button>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="200px">企业登录名</th>
						<th width="300px">企业名称</th>
						<th width="200px">企业联系人</th>
						<th width="280px">联系电话</th>
						<th width="150px">所在楼层</th>
						<th width="100px">操作</th>
					</tr>
				</thead>
				<tbody id="bodyTr">
					<!-- 数据插入位置 -->
				</tbody>
			</table>
			<div id="pagination_2" style="margin-left:400px;margin-top: 50px"></div>
		</div>
	</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="js/pagination.min.js"></script>
<script type="text/javascript" src="js/enterpriseShow.js"></script> 
</body>
</html>