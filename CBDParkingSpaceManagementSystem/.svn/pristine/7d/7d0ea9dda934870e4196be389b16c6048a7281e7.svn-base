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
    <!-- 日志  -->
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
    <title>性能统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统性能统计 <span class="c-gray en">&gt;</span> 日志记录 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="">
        
	 <span class="select-box inline">
		<select id="select" name="" class="select">
            <option value="0">全部用户</option>
            <option value="前台">前台用户</option>
            <option value="后台">后台用户</option>
        </select>
		</span> 日期范围：
        <input type="text"  onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:180px;">
        -
        <input type="text" readonly="readonly" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'3000-12-31' })" id="logmax" class="input-text Wdate" style="width:180px;">
        <button name="" id="query" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="80">用户名</th>
                <th width="100">操作时间</th>
                <th width="50">登陆IP</th>
                <th width="50">日志内容</th>
                <th width="50">日志级别</th>
                <th width="50">日志操作</th>
            </tr>
            </thead>
			<tbody id="bodyTr">
			</tbody>
        </table>
        <div id="pagination_2" style="margin-left:300px;margin-top: 50px"></div>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script> 
	<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="js/pagination.min.js"></script>
<script type="text/javascript" src="js/LogRecord.js"></script>
</body>
</html>