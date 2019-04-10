<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" href="css/style_all.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/pagination.css" />
</head>

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
							<li><a href="#">系统信息</a></li>
							<li class="active">用户管理</li>
						</ol>
					</div>

					<table class="table table-hover">
						<tr class="info">
							<th>用户名</th>
							<th>真实姓名</th>
							<th>等级</th>
						</tr>
						<c:forEach var="li" items="${pageBean.pageData}">
							<tr>
								<td id="name" value="${li.userId}">${li.userName}</td>
								<td>${li.name }</td>
								<td>${li.privileges.privilegesName }</td>
							</tr>
						</c:forEach>
					</table>
				<input type="hidden" name="upid" value="${LoginUser.privileges.privilegesId}">
<div id="pagination_2"></div>
					<div class="panel panel-info col-md-5">
						<div class="panel-heading">操作机械信息</div>
						<div class="panel-body">
							<div class="row">
								<div class="form-group col-md-5">
									<button type="submit" class="btn btn-primary btn-all" id="add">添加用户</button>
								</div>
								<div class="form-group col-md-5 col-md-offset-2">
									<button type="submit" class="btn btn-primary btn-all" id="delete">删除用户</button>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-5">
									<button type="submit" class="btn btn-primary btn-all"
										id="showUserInfo">修改用户信息</button>
								</div>
							</div>
						</div>
					</div>
					<!--查询-->
					<div class="panel panel-info col-md-5 col-md-offset-2">
						<div class="panel-heading">查询用户信息</div>
						<div class="panel-body">
							<form class="form-horizontal" action="QueryUserInfo" method="post">
								<div class="form-group">					
									<div class="">
										<select class="form-control" name="queryId">
											<option value='1'>超级管理员</option>
											<option value='2'>资料管理员</option>
											<option value='3'>灾情管理员</option>
											<option value='4'>专家管理员</option>
											<option value='5'>库房管理员</option>
										</select>
									</div>
								</div>

							
								<div class="form-group">
									<div class="col-md-2 col-md-offset-8">
										<button type="submit" class="btn btn-primary">查询</button>
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
							<li><a href="pestsList_management">虫害一览</a></li>
							<li><a href="diseasesList_management">病害一览</a></li>
							<li><a href="rodentpestsList_management">鼠害一览</a></li>
			
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
		 		
		 		$("#showUserInfo").click(function(){
		 			
		 			if(chonseId == 0||chonseId ==undefined){
						alert("请选择要修改的用户");
					}else{
						$(location).prop('href', "showUserInfo?chonseId="+chonseId);
						
					}
		 		});
              $("#add").click(function(){
						$(location).prop('href', "jsp/add_user.jsp?");
		 		});
              
              $("#delete").click(function(){
					if(chonseId == 0||chonseId ==undefined){
						alert("请选择要删除的数据");
					}else{
						if(confirm("确定删除吗")){
							$(location).prop('href', "deleteUserBean?chonseId="+chonseId);
						}
					}
					});
              var upid = $("input[name=upid]").val();
              if(upid!="1"){
            	//  console.log("*****upid="+upid);
            	  $("#add").attr("disabled",true);
            	  $("#delete").attr("disabled",true);
            	  $("#showUserInfo").attr("disabled",true);
            	
              }
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
	                	url:"user_managementPage",
	                	data:{
	                		"currPage":currPage,
	                		"pageSize":${pageBean.pageSize},
	                	},
	                	dataType : 'json',
	                	success:function(data){
	                		
	                		var str = "<tr class='info'><th>用户名</th><th>等级</th><th>真实姓名</th></tr>";
	                		for(var i=0;i<data.pageData.length;i++){
	                			str += "<tr>";
	                			str += "<td id='name' value='"+data.pageData[i].userId+"'>"+data.pageData[i].userName+"</td>";
	                			str += "<td>"+data.pageData[i].privileges.privilegesName+"</td>"
	                			str += "<td>"+data.pageData[i].name+"</td>"
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