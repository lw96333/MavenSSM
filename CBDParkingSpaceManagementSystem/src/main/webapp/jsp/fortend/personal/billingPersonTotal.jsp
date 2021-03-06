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
    
    <title>计费统计</title>
</head>
<body>
    <article class="page-container" style="margin-top: 80px">
        
	    <div class="row cl col-md-offset-3">
	        <label class="form-label col-xs-4 col-sm-3">交易总笔数：</label>
	        <div class="formControls col-xs-8 col-sm-9">
	            <span id="dealSum" style="font-size: 20px"></span>
	            &nbsp;&nbsp;<label style="font-size: 20px">笔</label>
	        </div>
	    </div>
	    <div class="row cl col-md-offset-3">
	        <label class="form-label col-xs-4 col-sm-3">֧支出金额合计：</label>
	        <div class="formControls col-xs-8 col-sm-9">
	            <span id="expendSum" style="font-size: 20px"></span>
	            &nbsp;&nbsp;<label style="font-size: 20px">元</label>
	        </div>
	    </div>
	    <div class="row cl col-md-offset-3">
	        <label class="form-label col-xs-4 col-sm-3">收入金额合计：</label>
	        <div class="formControls col-xs-8 col-sm-9">
	            <span id="incomeSum" style="font-size: 20px"></span>
	            &nbsp;&nbsp;<label style="font-size: 20px">元</label>
	        </div>
	    </div>
	
	    <div class="row cl col-md-offset-3" style="margin-top: 30px">
	        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
	            <input id="close" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;确定&nbsp;&nbsp;">
	        </div>
	    </div>
        
    </article>


<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/billingPersonTotal.js"></script>
</body>
</html>