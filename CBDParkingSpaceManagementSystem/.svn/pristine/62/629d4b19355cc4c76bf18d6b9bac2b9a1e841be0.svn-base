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
	<link rel="stylesheet" type="text/css" href="css/fileinput.min.css" />
    
    <title>续约外部合约信息</title>
    
</head>
<body>


<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>原合同编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="tel" class="input-text" value="" placeholder="" readonly="readonly" id="oldcontractnumber" name="oldcontractnumber" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>新续合同编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" readonly="readonly" id="contractnumber" name="contractnumber" style="width: 200px">
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>联系人：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="不能为空" name="contactperson" id="contactperson" style="width: 200px"><span id="three"></span>
			</div>
		</div>
	
	      <div class="row cl col-md-offset-3">
	          <label class="form-label col-xs-4 col-sm-3" /><span class="c-red"></span>联系人电话</label>
	          <div class="formControls col-xs-8 col-sm-9">
	              <input type="text" class="input-text" placeholder="不能为空" name="phone" id="phone" style="width: 200px"><span id="four"></span>
	          </div>
	      </div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同生效日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<!-- WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' }) -->
			      <input type="text" readonly="readonly"  onfocus="" id="datemin" style="width: 200px" class="input-text Wdate" />
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同截止日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
			      <input type="text" placeholder="不能为空" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'3000-12-31' })" id="datemax" class="input-text Wdate" style="width:200px;"/>	
			</div>
		</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>成交价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="只能输入正整数" id="price" name="price" style="width: 200px"><span id="five"></span>
			</div>
		</div>
		 <div class="row cl col-md-offset-3">
	           <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同单位</label>
	           <div class="formControls col-xs-8 col-sm-9">
	               <input type="text" class="input-text" value="" placeholder=""不能为空"" readonly="readonly" id="contractcompany" name="contractcompany" style="width: 260px"><span id="six"></span>
	           </div>
	      	</div>
		<div class="row cl col-md-offset-3">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>上传合同复印件：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input id="fileinput" name="uploadImgFile" class="input-text" type="file" value="上传" multiple name="mobile" style="width: 200px;">
			</div>
		</div>
		<div class="row cl col-md-offset-3" style="margin-top: 20px">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input id="button"  class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;新增&nbsp;&nbsp;">
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
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/fileinput.min.js"></script>
<script type="text/javascript" src="js/AddExternalContracts.js"></script>
<script type="text/javascript" src="js/zh.js"></script>

</body>
</html>