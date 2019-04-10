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
	<link rel="stylesheet" type="text/css" href="css/fileinput.min.css" />
	
	<title>租户续约</title>
	
</head>
<body>
<!-- <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 租户管理<span class="c-gray en">&gt;</span> 租户续约 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav> -->
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<input type="hidden" id="enterprisecontractid"/>
		<input type="hidden" id="enterpriseid"/>	
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>原合同编号：</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" readonly="readonly" id="contractNO" name="contractNO" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新合同编号：</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" readonly="readonly" placeholder="" id="newcontractNO" name="newcontractNO" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>合同生效日期:</label>
			<div class="formControls col-xs-9 col-sm-8">
				<input type="text" style="width: 200px" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;"/>
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>合同失效日期:</label>
			<div class="formControls col-xs-9 col-sm-8">
				<input type="text" style="width: 200px" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemax" class="input-text Wdate" style="width:120px;"/>
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>对方联系人：</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="linkman" name="mobile" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>成交价格:</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text"  minlength="3" maxlength="6"  value="" placeholder="" id="price" name="mobile" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>对方联系人电话：</label>
			<div class="formControls col-xs-8 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="personuser" name="mobile" style="width: 200px">
			</div>
		</div>
		
		
		  <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3" /><span class="c-red">*</span>合同复印件</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input id="fileinput" name="uploadImgFile" class="input-text" type="file" value="上传" multiple name="mobile" style="width: 80px;">
            </div>
        </div>
<!-- 		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新合同复印件：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="fileinput" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file-2" class="input-file">
				</span> </div>
		</div> -->
		<div class="row cl col-md-offset-3" style="margin-top: 20px">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" id="button" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp">
			</div>
		</div>
	</form>
</article>


<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer ä½ä¸ºå¬å±æ¨¡çåç¦»åºå»-->


<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="js/contract-renew.js"></script>
<script type="text/javascript" src="js/fileinput.min.js"></script>
<script type="text/javascript" src="js/zh.js"></script>
</body>
</html>
