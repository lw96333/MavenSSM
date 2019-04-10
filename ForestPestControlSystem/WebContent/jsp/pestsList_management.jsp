<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>虫害一览</title>
<link rel="stylesheet" href="css/style_all.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/pagination.css" />
</head>
<body>
<body>
	<div id="top">
		<div id="head">
			<h3 class="logo">
				<span>森</span>林病虫害防治系统
			</h3>
			<div class="head_memberinfo">
                  <div class="head_memberinfo_logo">
                      <img src="images/unreadmail.png" alt=""/>
                  </div>
                  <span class='memberinfo_span'>
                     	欢迎 <a href="">${LoginUser.name}</a>
                  </span>
               <span>
                   <a href="out">退出</a>
               </span>
          	</div>
			<!--end head_memberinfo-->

		</div>
		<!--end head-->

		<div id="bg_wrapper">
			<div id="main">
				<div id="content">

					<div class="">
						<ol class="breadcrumb">
							<li><a href="#">资料管理</a></li>
							<li class="active">虫害一览</li>
						</ol>
					</div>
					<!--虫害一览 表格信息-->
					<table class="table table-hover">
						<tr class="info">
							<th>名称</th>
							<th>寄主</th>
							<th>主要危害</th>

						</tr>
						<c:forEach var="li" items="${pageBean.pageData}">
							<tr>
								<td id="name" value="${li.pestisId}">${li.pestisName}</td>
								<td>${li.host }</td>
								<td>${li.mainHazards }</td>
							</tr>
						</c:forEach>
					</table>
					<div id="pagination_2"></div>
					<!-- 操作专家信息 按钮 -->
					<div class="panel panel-info col-md-5">
						<div class="panel-heading">管理虫害信息</div>
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-6">
									<button type="submit" class="btn btn-primary btn-all"
										id="addPestsInfo">添加虫害</button>
								</div>
								<div class="form-group col-md-6">
									<button type="submit" class="btn btn-primary btn-all"
										id="showPestsInfo">查看详细信息</button>
								</div>
							</div>
						</div>
					</div>
					<!--查询-->
					<div class="panel panel-info col-md-5 col-md-offset-2">
						<div class="panel-heading">查询虫害信息</div>
						<div class="panel-body">
							<form class="form-horizontal" action="QueryPestsList" method="post">
								<div class="form-group">
									<label for="" class="">害虫名</label>
									<div class="">
										<input type="text" class="form-control" name="queryName"
											placeholder="害虫名称">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="">寄主名</label>
									<div class="">
										<input type="text" class="form-control" name="queryHost"
											placeholder="寄主名称">
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-3 col-md-offset-9">
										<button type="submit" class="btn btn-primary" id="queryPests">查询</button>
									</div>
								</div>

							</form>
						</div>
					</div>

				</div>
				<!--end content-->

			</div>
			<!--end main-->

			<div id="sidebar">
				<ul class="nav">
					<li><a class="headitem item1" href="#">资料管理</a>
						<ul>
							<!-- ul items without this class get hiddden by jquery-->
							<li><a href="/ForestPestControlSystem/pestsList_management">虫害一览</a></li>
							<li><a href="/ForestPestControlSystem/diseasesList_management">病害一览</a></li>
							<li><a href="/ForestPestControlSystem/rodentpestsList_management">鼠害一览</a></li>
			
						</ul></li>
					<li><a class="headitem item2" href="#">灾情防治</a>
						<ul>
							<li><a href="areaIn">区域一览</a></li>
							<li><a href="smallClass">小班管理</a></li>
							<li><a href="incident">事件记录</a></li>
						</ul></li>
					<li><a class="headitem item3" href="#">专家会商</a>
						<ul>
							<li><a href="specialist">专家一览</a></li>
							<li><a href="instrumentManagement">会商灾情</a></li>
						</ul></li>
					<li><a class="headitem item4" href="#">药剂器械出库管理</a>
						<ul>
							<li><a href="pharmacy_management">药剂管理</a></li>
							<li><a href="consultation_management">器械管理</a></li>
							<li><a href="outgoing_management">出库管理</a></li>
						</ul></li>
					<li><a class="headitem item5" href="#">系统信息</a>
						<ul>
							<li><a href="user_management">用户管理</a></li>
							<li><a href="log">日志一览</a></li>
						</ul></li>
				</ul>
				<!--end subnav-->
			</div>
			<!--end sidebar-->

		</div>
		<!--end bg_wrapper-->

		<div id="footer" style="color: #fff; text-align: center">
			Copyright 2018 - 2019 One. All Rights Reserved
		</div>
		<!--end footer-->

	</div>
	<!-- end top -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script type='text/javascript' src='js/custom.js'></script>
	<script src="js/pagination.min.js"></script>
	<script type="text/javascript">
		 	var chonseId = 0;
		 	$(function(){
		 		
		 		$("#showPestsInfo").click(function(){
		 			
		 			if(chonseId == 0||chonseId ==undefined){
						alert("请选择要查看的数据");
					}
		 			else{
						$(location).prop('href', "showPestsInfo?chonseId="+chonseId);
						
					}
		 		});
              $("#addPestsInfo").click(function(){
						$(location).prop('href', "jsp/add_pests_informaation.jsp?");
		 		});
              
		 		chonse();
		 	});
	        $("#pagination_2").whjPaging({
	            css: 'css-2',
	            totalSize: ${pageBean.totalData},
	            totalPage: ${pageBean.totalNum},
	            showPageNum: ${pageBean.pageSize},
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
	                	url:"pestsList_managementPage",
	                	data:{
	                		"currPage":currPage,
	                		"pageSize":${pageBean.pageSize},
	                	},
	                	dataType : 'json',
	                	success:function(data){
	                		
	                		var str = "<tr class='info'><th>名称</th> <th>寄主</th><th>主要危害</th></tr>";
	                		for(var i=0;i<data.pageData.length;i++){
	                			str += "<tr>";
	                			str += "<td id='name' value='"+data.pageData[i].pestisId+"'>"+data.pageData[i].pestisName+"</td>";
	                			str += "<td>"+data.pageData[i].host+"</td>"
	                			str += "<td>"+data.pageData[i].mainHazards+"</td>"
	                			str += "</tr>";
	                		}
	                		$(".table").html(str);
	                		chonse();
	                	}
	                });
	            }
	        });
	        function chonse(){
	        	
        		$(".table tr").on("click",function(){
		 			$(".table tr").css({
		 				background: "white"
		 			});
		 			$(this).css({
		 				background: "#D8ECF7"
		 			});
		 			chonseId = $(this).first().find("#name").attr("value");
		 		});
	        }
	       </script>
</body>
</html>