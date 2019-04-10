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
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    
    <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/pagination.css" />
    
    <title>添加CBD车位</title>
    
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 车位管理 <span class="c-gray en">&gt;</span> 添加CBD车位 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<article class="page-container" style="margin-top: 100px">
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
         <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位所在位置：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="请输入2~12位字符" id="address" name="address" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="请输入1~3位英文和数字" 
                id="areanumber" name="areanumber" style="width: 260px" maxlength="3" minlength="1">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位起始编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" maxlength="3" minlength="1"
                placeholder="请输入1~3位数字" id="fristnumbers" name="fristnumbers" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>添加数量：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入1~3位数字" 
                name="number" id="number" style="width: 260px" maxlength="3" minlength="1">
            </div>
        </div>

        <div class="row cl col-md-offset-3">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3" style="margin-top: 20px">
                <input id="btn" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/TruckSpace-add.js"></script>

</body>
</html>