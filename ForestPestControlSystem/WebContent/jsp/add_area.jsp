<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--添加区域-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加区域</title>
<link rel="stylesheet" href="../css/style_all.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/style.css" type="text/css"
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
                        <img src="../images/unreadmail.png" alt=""/>
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
							<li><a href="#">灾情防治</a></li>
							<li class="active"><a href="../areaIn">区域一览</a></li>
							<li class="active">添加区域</li>
						</ol>
					</div>

					<div class="panel panel-info col-md-10 col-md-offset-1">
						<div class="panel-heading">添加区域</div>
						<div class="panel-body">
							<form class="form-horizontal">

								<div class="form-group row" style="margin-top: 50px">
									<label class="col-md-6 col-md-offset-3">名称</label>
									<div class="col-md-6 col-md-offset-3">
										<input type="text" class="form-control " maxlength="6" minlength="2"  id="areaName"
											placeholder="名称">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">林种</label>
									<div class="col-md-6 col-md-offset-3">
										<input type="text" class="form-control " maxlength="10" id="areaForest"
											placeholder="林种">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">优势树种</label>
									<div class="col-md-6 col-md-offset-3">
										<input type="text" class="form-control " maxlength="10" id="areaAdvantage"
											placeholder="优势树种">
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-6 col-md-offset-3">地类</label>
									<div class="col-md-6 col-md-offset-3">
										<select class="form-control" id="linDi">
											<option value='1'>林地</option>
											<option value='2'>疏林地</option>
											<option value='3'>灌木林</option>
											<option value='4'>苗圃地</option>
										</select>
									</div>
								</div>

								<div class="form-group row" style="margin-top: 50px">
									<div class="col-md-2 col-md-offset-5">
										<a id="addArea"  class="btn btn-primary">添加</a>
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
							<li><a href="../pestsList_management">虫害一览</a></li>
							<li><a href="../diseasesList_management">病害一览</a></li>
							<li><a href="../rodentpestsList_management">鼠害一览</a></li>
			
						</ul></li>
					<li><a class="headitem item2" href="#">灾情防治</a>
						<ul>
							<li><a href="../areaIn">区域一览</a></li>
							<li><a href="../smallClass">小班管理</a></li>
							<li><a href="../incident">事件记录</a></li>
						</ul></li>
					<li><a class="headitem item3" href="#">专家会商</a>
						<ul>
							<li><a href="../specialist">专家一览</a></li>
							<li><a href="../instrumentManagement">会商灾情</a></li>
						</ul></li>
					<li><a class="headitem item4" href="#">药剂器械出库管理</a>
						<ul>
							<li><a href="../pharmacy_management">药剂管理</a></li>
							<li><a href="../consultation_management">器械管理</a></li>
							<li><a href="../outgoing_management">出库管理</a></li>
						</ul></li>
					<li><a class="headitem item5" href="#">系统信息</a>
						<ul>
							<li><a href="../user_management">用户管理</a></li>
							<li><a href="../log">日志一览</a></li>
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
	<script src="../js/jquery-1.7.2.min.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script type='text/javascript' src='../js/custom.js'></script>
	<script type='text/javascript' src="../js/add_areaIn.js"></script>
</body>

</html>