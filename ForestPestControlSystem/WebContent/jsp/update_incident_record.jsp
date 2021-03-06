<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--修改事件信息-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改事件信息</title>
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
					<img src="images/unreadmail.png" alt="" />

				</div>

				<span class='memberinfo_span'> 欢迎 <a href="">${LoginUser.name}</a>
				</span> <span> <a href="out">登出</a>
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
							<li class="active"><a href="incident">事件记录</a></li>
							<li class="active">修改事件信息</li>
						</ol>
					</div>

					<div class="panel panel-info col-md-10 col-md-offset-1">
						<div class="panel-heading">修改事件信息</div>
						<div class="panel-body">
							<form class="form-horizontal">
								<div class="form-group row">
									<label class="col-md-5">事件名称</label> <label
										class="col-md-5 col-md-offset-2">影响面积</label>

									<div class="col-md-5">
										<span>${incident.eventName }</span>
									</div>

									<div class="col-md-5 col-md-offset-2">
										<span>${incident.influence }</span>
									</div>

								</div>

								<div class="form-group row">
									<label class="col-md-5">时间</label> <label
										class="col-md-5 col-md-offset-2">灾害类型</label>

									<div class="col-md-5">
										<span><fmt:formatDate value="${incident.time }"
												pattern="yyyy-MM-dd" /></span>
									</div>

									<div class="col-md-5 col-md-offset-2">
										<span>${incident.pestType.type }</span>
									</div>

								</div>

								<div class="form-group row">
									<label class="col-md-5">防治方案</label> <label
										class="col-md-5 col-md-offset-2">发现途径</label>

									<div class="col-md-5">
										<input type="text" class="form-control" id="controlMethod"
											maxlength="50" placeholder="防治方案"
											value="${incident.controlMethod }">
									</div>

									<div class="col-md-5 col-md-offset-2">
										<span>${incident.discovery.pathName }</span>
									</div>

								</div>

								<div class="form-group row">
									<label class="col-md-5">发生位置</label> <label
										class="col-md-5 col-md-offset-2">所在小班</label>

									<div class="col-md-5">
										<span>${incident.area.name }</span>
									</div>

									<div class="col-md-5 col-md-offset-2">
										<span>${incident.smallClass.name }</span>
									</div>
								</div>

								<div class="form-group row">
									<label class="col-md-5">初步损失</label> <label
										class="col-md-5 col-md-offset-2">灾情阶段</label>

									<div class="col-md-5">
										<span>${incident.initialloss }</span>
									</div>

									<div class="col-md-5 col-md-offset-2">
										<select id="stageId" class="form-control">
											<option value="1">已得到控制</option>
											<option value="2">防治中</option>
											<option value="3">无法解决，申请专家会商</option>
										</select>
									</div>

								</div>

								<div class="form-group row">
									<label class="col-md-5">灾情描述</label> <label
										class="col-md-5 col-md-offset-2">灾区图片</label>

									<div class="col-md-5">
										<span>${incident.disaster }</span>
									</div>

									<div class="col-md-5 col-md-offset-2">
										<img class="img-responsive" src="${incident.pic }" />
									</div>
								</div>


								<div class="form-group row">
									<div class="col-md-5 col-md-offset-5">
										<button type="button" id="update" class="btn btn-primary">修改</button>
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
			More Templates <a href="http://www.cssmoban.com/" target="_blank"
				title="模板之家">模板之家</a> - Collect from <a
				href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
		</div>
		<!--end footer-->

	</div>
	<select style="display: none" id="incidentId"><option
			value="${incident.id }"></option></select>
	<!-- end top -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script type='text/javascript' src='js/custom.js'></script>
	<script src="js/update_incident.js"></script>

</body>

</html>