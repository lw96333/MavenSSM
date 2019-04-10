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
	
	<title>查看出售合同</title>
</head>
<body>
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 
	<span class="c-gray en">&gt;</span> 车位买卖
	 <span class="c-gray en">&gt;</span> 查看出售合同
	  <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
	
		<div class="mt-20">
			<table class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th >车位产权证编号</th>
						<th >所在小区</th>
						<th >开始时间</th>
						<th >结束时间</th>
						<th >留言</th>
						<th >状态</th>
					</tr>
				</thead>
				<tbody>
					<tr class="text-c">
						<td>2015-03-07</td>
						<td>18:33:23</td>
						<td>1600.00</td>
						<td>3200.00</td>
						<td>交易xxx车位</td>
						<td class="td-manage">
							<a title="等待出售" href="javascript:;" onclick="" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6a1;</i></a>
							<a title="预约中" href="javascript:;" onclick="" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe69c;</i></a>
							<a title="查看合同" href="javascript:;" onclick="" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe687;</i></a>
						</td>
					</tr>
				</tbody>
			</table>
			<div id="pagination_2" style="margin-left:400px;margin-top: 50px"></div>
		</div>
	</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="js/pagination.min.js"></script>
<script type="text/javascript">
$(function(){
	pageJs(10,100,10);
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	
});

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

function pageJs(totalSize,totalPage,showPageNum){
	$("#pagination_2").whjPaging({
		css: 'css-2',
		totalSize: totalSize,
		totalPage: totalPage,
		showPageNum: 3,
		firstPage: '首页',
		previousPage: '上一页',
		nextPage: '下一页',
		lastPage: '尾页',
		skip: '',
		confirm: '跳转',
		refresh: '刷新',
		totalPageText: '总共 {} 页',
		totalSizeText: "总共 {} 条",
		isShowFL: true,
		isShowSkip: true,
		isResetPage: false,
		isShowRefresh: false,
		isShowTotalPage: true,
		isShowTotalSize: true,
		isShowPageSizeOpt: false,
		callBack: function (currPage,pageSize) {
			$.ajax({
				type:"post",
				url:"diseasesList_managementPage",
				data:{
					"currPage":currPage,
					"pageSize":5,
				},
				dataType : 'json',
				success:function(data){

					page(currPage,pageSize);
				}
			});
		}
	});
}
</script> 
</body>
</html>