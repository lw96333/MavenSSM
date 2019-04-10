<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 查看虫害信息 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看鼠害信息</title>
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
							<li><a href="#">资料管理</a></li>
							<li class="active"><a href="rodentpestsList_management">鼠害一览</a></li>
							<li class="active">查看鼠害详细信息</li>
						</ol>
					</div>

					<div class="panel panel-info col-md-10 col-md-offset-1">
						<div class="panel-heading">鼠害信息</div>
						<div class="panel-body">
							<form class="form-horizontal">
								<div class="form-group row">
									<label class="col-md-5">名称</label> <label
										class="col-md-5 col-md-offset-2">繁殖</label>
									<div class="col-md-5 ">
										<span>${RodentpestsBean.mouseName}</span>
									</div>
									<div class="col-md-5 col-md-offset-2">
										<span>${RodentpestsBean.reproduction}</span>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-md-5">食物</label> <label
										class="col-md-5 col-md-offset-2">天敌</label>
									<div class="col-md-5 ">
										<span>${RodentpestsBean.mouseFoot}</span>
									</div>
									<div class="col-md-5 col-md-offset-2">
										<span>${RodentpestsBean.naturalEnemy}</span>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-5">主要危害</label> <label
										class="col-md-5 col-md-offset-2">防止措施</label>
									<div class="col-md-5 ">
										<span>${RodentpestsBean.mainHazards}</span>
									</div>
									<div class="col-md-5 col-md-offset-2">
										<span>${RodentpestsBean.preventiveMeasures}</span>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-md-5">图片</label><br />
									<br />
									<div class="col-md-5" style="position: relative">
										<img src="${RodentpestsBean.mousePic}" style="width: 250px;" alt="" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-md-2 col-md-offset-5">
										<button type="button" class="btn btn-primary" id="back">返回</button>
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
	<script>
	$(function(){
		$("#back").click(function(){
			$(location).prop('href', "rodentpestsList_management");
		});
	})
</script>
</body>
</html>