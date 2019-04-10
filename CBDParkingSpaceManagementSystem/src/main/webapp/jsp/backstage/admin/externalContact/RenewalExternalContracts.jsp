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
    <meta charset="UTF-8">
    
    <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagination.css" />
    <link rel="stylesheet" type="text/css" href="css/fileinput.min.css" />
    
    <title>新增外部合约</title>
    
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 合约管理 <span class="c-gray en">&gt;</span> 新增外部合约 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-member-add">
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同编号</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" readonly="readonly"  id="contractnumber" name="contractnumber" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同单位</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value=""  placeholder="不能为空"  id="contractcompany" name="contractcompany" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>联系人</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="不能为空" name="contactperson" id="contactperson" style="width: 260px">
            </div>
        </div>

        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3" /><span class="c-red"></span>联系人电话</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="不能为空" name="phone" id="phone" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位地址</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="不能为空" id="stalladdress" name="stalladdress" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位所属单位详细地址</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="不能为空" id="address" name="address" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同生效日期</label>
            <div class="formControls col-xs-8 col-sm-9">
            	<input type="text" placeholder="不能为空"  onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:260px;"/>
                <!-- <input type="date"  class="input-text" placeholder="" name="starttime" id="starttime" style="width: 260px"><span id="seven"></span> -->
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>合同截止日期</label>
            <div class="formControls col-xs-8 col-sm-9">
            <input type="text" placeholder="不能为空" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'3000-12-31' })" id="datemax" class="input-text Wdate" style="width:260px;"/>
               
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位编号</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="最大输入是3个字符" maxlength="3" id="stallnumber" name="stallnumber" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位起始位置</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="最大输入是3个字符" maxlength="3" id="startnumber" name="startnumber" style="width: 260px">
            </div>
        </div>
         <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>车位数量</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="最大输入是3个字符" maxlength="3" id="number" name="number" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>成交价格</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="只能输入正整数" name="price" id="price" style="width: 260px">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <label class="form-label col-xs-4 col-sm-3" /><span class="c-red"></span>合同复印件</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input id="fileinput" name="uploadImgFile" class="input-text" type="file" value="上传" multiple name="mobile" style="width: 80px;">
            </div>
        </div>
        <div class="row cl col-md-offset-3">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3" style="margin-top: 20px">
                <input id="button"  class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;新增&nbsp;&nbsp;">
            </div>
        </div>
	</form>
</div>

<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<script type="text/javascript" src="../lib/html5shiv.js"></script>
<script type="text/javascript" src="../lib/respond.min.js"></script>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="js/fileinput.min.js"></script>
<script type="text/javascript" src="js/zh.js"></script>
<script type="text/javascript" src="js/RenewalExternalContracts.js"></script>

</body>
</html>