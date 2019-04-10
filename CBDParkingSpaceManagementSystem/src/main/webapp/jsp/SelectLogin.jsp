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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="share/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="share/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="share/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>登录选择页面 - CBD车位管理系统</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="index.html" method="post">
    <div class="row cl">
        <label class="" style="margin-left:180px;font-size:20px;color:red"><i class="Hui-iconfont">欢迎光临NoBug车位管理系统</i></label>
       
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input name="fortendLogin" type="button" class="btn btn-success input-text size-L" value="我是客户" >
        </div>
      </div>
      <br/><br/>
	  <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input name="backLogin" type="button" class="btn btn-success input-text size-L" value="我是管理员" >
        </div>
      </div>
      
     
      
    </form>
  </div>
</div>
<div class="footer">NoBug - CBD车位管理系统<img alt="" src="images/logo.png" style="width:50px;heigth:40px;margin-left: 30px"></div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<!--此乃百度统计代码，请自行删除-->
<script src="js/SelectLogin.js"></script>

</body>
</html>