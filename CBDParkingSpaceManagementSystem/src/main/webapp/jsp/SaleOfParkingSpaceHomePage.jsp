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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    
    <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagination.css" />
    
    <title>出售车位</title>
    
</head>
<body>
<span id="id" style="display: none;">${userinfo}</span>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页<span class="c-gray en">&gt;</span> 车位信息<span class="c-gray en">&gt;</span> 出售车位<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <input type="text" name="" id="startpice" placeholder="车位价格"  style="width:180px" class="input-text"><span> - </span>
    <input type="text" name="" id="endpice" placeholder="车位价格"  style="width:180px" class="input-text">
    <button name="" id="shou" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i></button>
    <div class="mt-20">
        	<div>
                <ul class="row">
                    <li class=" col-sm-3 ">
                         <img src="<%=basePath%>images/carPage.jpg" style="width:200px;height: 200px;" />
                              <h4>车位地址</h4>
                             <p>成都市天府一街12号中海兰亭小区E023车位</p>
                        <a class="info"  href='javascript:;' style='color: red;'>查看详情</a>
                    </li>
        </div><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <div id="pagination_2" style="margin-left:300px;margin-top: 50px;"></div>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="js/pagination.min.js"></script>
<script type="text/javascript" src="js/index-temporary2.js"></script>
</body>
</html>