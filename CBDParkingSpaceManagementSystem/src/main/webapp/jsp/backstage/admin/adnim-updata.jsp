<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href=<%=basePath %>/>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
 	<link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
	<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/> -->
	
<link href="css/styleLogin.css" rel="stylesheet"
	type="text/css" />

<title>后台管理员信息修改</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<article class="page-container">
		<div class="container" style="position: absolute; top: 100px;">
			<form action="" method="post" class="form form-horizontal"
				id="form-member-add">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>新密码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="password" class="input-text"  placeholder="请输入2~10位英文和数字"
							id="password" name="password" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>再次输入新密码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="password" class="input-text" value="" placeholder="请输入2~10位英文和数字"
							id="passwords" name="passwords" minlength="2" maxlength="10">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>电话号码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" value="" class="input-text" name="phone" id="phone" 
						placeholder="请输入11位手机号码" minlength="11" maxlength="11">
					</div>
				</div><br>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<input class="btn btn-primary radius" type="submit" id="updata_admin"
							value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script> 
	<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript" src="js/adnim-updata.js"></script>
</body>
</html>