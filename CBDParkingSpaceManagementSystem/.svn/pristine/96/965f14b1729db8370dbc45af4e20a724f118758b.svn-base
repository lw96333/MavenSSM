<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--预定车位用户信息-->
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
    <!--/meta 作为公共模版分离出去-->

    <title>预定车位用户信息</title>
</head>
<body>
<article class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">租借开始时间：</label>
            <label id="stateTime" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">租借结束时间：</label>
            <label id="endTime" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">用户名：</label>
            <label id="userName" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">职业：</label>
            <label id="job" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">电话：</label>
            <label id="phone" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">信誉度：</label>
            <label id="credit" style="color: orange" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">留言：</label>
            <label id="message" class="form-label col-xs-4 col-sm-3"></label>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-5 col-xs-offset-2 col-sm-offset-3">
                <input class="btn btn-primary radius" id="lease" type="button" value="&nbsp;&nbsp;出租&nbsp;&nbsp;">
                <input class="btn btn-primary radius" id="noRent" type="button" value="&nbsp;不出租&nbsp;&nbsp;">
                <input class="btn btn-primary radius" id="cancel" type="button" value="&nbsp;取消&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>
<input type="hidden" id="userId" value='${user.userid}'>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/ViewReservationInformation.js"></script>
</body>
</html>