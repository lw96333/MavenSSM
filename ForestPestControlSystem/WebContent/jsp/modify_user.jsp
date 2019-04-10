<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 查看虫害信息 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改用户信息</title>
<link rel="stylesheet" href="css/style_all.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
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
							<li><a href="#">信息系统</a></li>
							<li class="active"><a href="#">用户管理</a></li>
							<li class="active">修改用户信息</li>
						</ol>
					</div>

					<div class="panel panel-info col-md-10 col-md-offset-1">
						<div class="panel-heading">修改用户信息</div>
						<div class="panel-body">
							<form class="form-horizontal" action="updateUserBeanInfo" method="post">
								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">用户名</label>
									<div class="col-md-6 col-md-offset-3">
										<span>${UserBean.userName}</span>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">密码</label>
									<div class="col-md-6 col-md-offset-3">
										<input type="text" class="form-control "name="pass1" placeholder="密码">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">确认密码</label>
									<div class="col-md-6 col-md-offset-3">
										<input type="text" class="form-control " name="pass2" placeholder="确认密码">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">真实姓名</label>
									<div class="col-md-6 col-md-offset-3">
										<span>${UserBean.name}</span>
										<input type="hidden" name="id" value="${UserBean.userId}">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">用户等级</label>
									<div class="col-md-6 col-md-offset-3">
										<select class="form-control" name = "choice">
											<option value="1">超级管理员</option>
											<option value="2">资料管理员</option>
											<option value="3">灾情管理员</option>
											<option value="4">专家管理员</option>
											<option value="5">库房管理员</option>
										</select>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-2 col-md-offset-5">
										<button type="submit" class="btn btn-primary"id="update">修改</button>
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
	<!--
<script>
	$(function(){
		$("#update").click(function(){
			$(location).prop('href', "updateUserBeanInfo");
		});
	})
</script>-->
</body>

</html>