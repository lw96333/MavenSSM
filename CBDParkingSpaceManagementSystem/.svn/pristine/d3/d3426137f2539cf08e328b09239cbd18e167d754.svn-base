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
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagination.css" />
    <!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" /> -->
    <link href="css/styleLogin.css" rel="stylesheet" type="text/css" />

    <title>个人用户修改</title>
    
</head>
<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页<span class="c-gray en">&gt;</span> 个人模块<span class="c-gray en">&gt;</span> 个人用户修改<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <article class="page-container" style="margin-top: 100px">
        <form action="" method="post" class="form form-horizontal" id="form-member-add">
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>新密码：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="password" class="input-text" value="" placeholder="请输入2~12位英文字母和数字"minlength="2" maxlength="10"
	                    id="password" name="password" >
	            </div>
	        </div>
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>再次输入新密码：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="password" class="input-text" value="" placeholder="请输入2~12位英文字母和数字"minlength="2" maxlength="10"
	                    id="passwords" name="passwords" >
	            </div>
	        </div>
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>家庭地址：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="text" class="input-text" name="adderss"  id="adderss" value=""
 					placeholder="请输入2~15位字符" minlength="2" maxlength="15">
	            </div>
	        </div>
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>电话号码：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="text" class="input-text" name="phone" id="phone" placeholder="请输入11位手机号码"
	                maxlength="11" minlength="11" value="">
	            </div>
	        </div>
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>职业描述：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="text" class="input-text" name="job" placeholder="请输入个人职业"value=""
	                    id="job" maxlength="10">
	            </div>
	        </div>
	        <div class="row cl col-md-offset-3">
	            <label class="form-label col-xs-4 col-sm-3"><span
	                class="c-red">*</span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
	            <div class="formControls col-xs-4 col-sm-3">
	                <input type="text" class="input-text" name="email" id="email" placeholder="请输入个人QQ邮箱" value="" maxlength="20">
	            </div>
	        </div>
	        <br>
	        <div class="row cl col-md-offset-3">
	            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
	                <input id="btn_alter" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
	            </div>
	        </div>
	    </form>
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
    <script type="text/javascript" src="js/Alter.js"></script>
</body>
</html>