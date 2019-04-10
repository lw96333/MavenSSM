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

    <title>修改企业信息</title>
    
</head>
<body>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 信息修改<span class="c-gray en">&gt;</span> 修改企业信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <article class="page-container" style="margin-top: 100px">
        <form action="" method="post" class="form form-horizontal" id="form-member-add">
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>登录名：</label>
                <div class="formControls col-xs-8 col-sm-9">
               
                    <input type="text" id="name" class="input-text" value="" placeholder="请输入2-8位字母或数字"  name="username" style="width: 260px"><span id="nameYes"></span>
                </div>
            </div>
             <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>修改密码：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="password"  class="input-text" id="enterpriepwd" minlength="6"   maxlength='12' placeholder="密码为6-12位数字或字母" style="width: 260px"><span id="enterpriepwdYes"></span>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>修改电话：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" id="phone"  maxlength='11' class="input-text" value="" placeholder="请输入正确的11位电话" name="mobile" style="width: 260px"><span id="phoneYes"></span>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>联系人：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="text" id="contactperson" class="input-text" value="" placeholder="只能输入中文或英文"  name="username" style="width: 260px"><span id="contactpersonYes"></span>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                    <input id="submit" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
<script type="text/javascript" src="js/TheRegular.js"></script>
<script type="text/javascript" src="js/UpdateEnterprise.js"></script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>