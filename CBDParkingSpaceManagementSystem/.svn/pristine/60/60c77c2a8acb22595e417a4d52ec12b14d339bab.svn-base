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

    <title>租户签约</title>
    
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 租户管理<span class="c-gray en">&gt;</span> 租户签约 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
<span  id="infoid" style="display:none"></span>
    <div class="mt-20" style="margin-top: 100px">
        <form action="" method="post" class="form form-horizontal" id="form-member-add">
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>企业用户名称：</label>
                <div class="formControls col-xs-8 col-sm-4 form-group">
                    <select class="selectpicker"  name="sid" id="sid"  style="width: 200px;font-size: 16px;" >
			   			<option onclick="selectClick()" value="-1">请选择企业名称</option>
			   		</select>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>合同编号：</label>
                <div class="formControls col-xs-8 col-sm-4">
                    <input type="text" style="width: 200px" class="input-text" readonly="readonly" placeholder="" id="contractNO" name="mobile">
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>合同生效日期：</label>
                <div class="formControls col-xs-5 col-sm-4">
                    <input type="text" name="datemin" style="width: 200px" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;"/>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>合同截止日期：</label>
                <div class="formControls col-xs-8 col-sm-4">  
                    <input type="text" name="datemax" style="width: 200px" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemax" class="input-text Wdate" style="width:120px;"/>
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>成交价格：</label>
                <div class="formControls col-xs-8 col-sm-4">
                    <input type="text" name="price" style="width: 200px" class="input-text" minlength="3" maxlength="6"  value="" placeholder="" id="stallprice" name="mobile">
                </div>
            </div>
            <div class="row cl col-md-offset-3">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>添加车位：</label>
                <div class="formControls col-xs-8 col-sm-4">
                    <td class="td-manage"> <input value="添加车位"  readonly="true" title="添加车位" href="javascript:;" onclick="member_edit('添加车位','jsp/backstage/admin/lease/contract-newcbd.jsp','4','','510')" class="btn btn-primary radius" style="text-decoration:none"></td>
                </div>
            </div>
           
            <div class="row cl col-md-offset-3" style="margin-top: 20px">
                <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                    <input class="btn btn-primary radius" readonly="true" type="button" id="btn" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
                </div>
            </div>
        </form>
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
<script type="text/javascript" src="js/contract-add.js"></script>
<script type="text/javascript">
/* function selectFocus(){
    document.getElementById("sid").setAttribute("size","6");
}
function selectClick(){
    document.getElementById("sid").removeAttribute("size");
    document.getElementById("sid").blur();
    this.setAttribute("sid","");
} */
</script>
</body>
</html>