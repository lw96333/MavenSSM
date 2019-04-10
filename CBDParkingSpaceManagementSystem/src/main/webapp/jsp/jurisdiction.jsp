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
<title>后台登录 - CBD车位管理系统</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="index.html" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <label style="font-size:28px;color:red">你没有权限！</label>
        </div>
      </div>

      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="login" type="button" class="btn btn-success radius size-L" value="&nbsp;去&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;" maxlength="16" >
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="loginOut" type="button" class="btn btn-success radius size-L" value="登录不了请点我" maxlength="16" >
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">CBD车位管理系统</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript"src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	$("input[name=login]").click(function(){
		$(location).attr("href","jsp/SelectLogin.jsp");
	});
	
	$("input[name=loginOut]").click(function(){
		$.ajax({
			type:"post",
			url:"loginOut",
			dataType:"json",
			success:function(data){
				$(location).attr("href","jsp/SelectLogin.jsp");
			}
		});
		
	});
</script>

</body>
</html>