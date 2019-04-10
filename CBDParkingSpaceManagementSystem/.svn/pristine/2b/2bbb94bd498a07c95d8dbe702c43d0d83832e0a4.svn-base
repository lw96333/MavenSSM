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
<link href="css/styleLogin.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>个人用户注册</title>
</head>
<body>
<div class="loginWraper">
  <div id="loginform" class="loginBoxs" style="height:530px;position: relative;top: 100px;left:250px; ">
    <form class="form form-horizontal" method="post" class="form form-horizontal" id="form-member-add">
      <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用&nbsp; 户&nbsp; 名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="请输入2~8位英文和数字或中文" id="name" name="name"
                minlength="2" maxlength = "8"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" value="" placeholder="请输入2~12位英文字母和数字"  minlength="2" maxlength = "12"
                id="password" name="password"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>真实姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  name="realname" maxlength="5" minlength="2" id="realname" 
                placeholder="请输入2~5位字符"  >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>家庭地址：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  name="address" id="address" maxlength="15"
              minlength="2"  placeholder="请输入2~15位字符" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>电话号码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="phone" id="phone" placeholder="请输入11位手机号码"
                maxlength="11" minlength="11">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>身份证号码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"  name="identitynumber" id="identitynumber" 
                maxlength="18" minlength="18" placeholder="请输入18位身份证号码">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>职业描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="job" id="job" placeholder="请输入个人职业" maxlength = "10">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="请输入个人QQ邮箱" name="email" id="email" maxlength = "20">
            </div>
        </div><br>
        <div class="formControls col-xs-8 col-xs-offset-3" style="position: relative;left: 40px; ">
          <input name="login" id="btn_enroll" type="button" class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;" >
        </div>
    </form>
  </div>
</div>
<div class="footer">CBD车位管理系统</div>
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
<script type="text/javascript" src="js/Enroll.js"></script>
</body>
</html>