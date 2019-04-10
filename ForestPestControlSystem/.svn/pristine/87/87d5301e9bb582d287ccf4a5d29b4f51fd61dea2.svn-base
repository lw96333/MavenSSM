<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 修改专家信息 -->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>首页</title>
    <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"  type="text/css" media="screen" />

</head>

<body>
<div id="top">
    <div id="head">
        <h3 class="logo"><span>森</span>林病虫害防治系统</h3>
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
                        <li><a href="#">专家会商</a></li>
                        <li class="active"><a href="#">专家会商</a></li>
                        <li class="active">修改专家信息</li>
                    </ol>
                </div>

                <div  class="panel panel-info col-md-10 col-md-offset-1">
                    <div class="panel-heading">修改专家信息</div>
                    <div class="panel-body">
                        <form class="form-horizontal"  method="post" >
                            <div class="form-group row">
                                <label  class="col-md-6">姓名</label>
                            </div>
                            <div class="form-group row">
                                <span  class="col-md-6">${specialist.name}</span>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-6">出生年月：</label>
                            </div>
                            <div class="form-group row">
                                <span  class="col-md-6">${specialist.bithday}</span>
                            </div>

                            <div class="form-group row">
                                <label  class="col-md-6">性别：</label>
                            </div>
                            <div class="form-group row">
                                <span  class="col-md-6">${specialist.gender?'男':'女'}</span>
                            </div>
                            <div style="outline: 1px red solid;width: 72px;height: 105px;position: absolute;left: 510px;top:70px">
                                <img src="${specialist.pic}">
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-5">专长：</label>
                                <label  class="col-md-5 col-md-offset-2">职务：</label>
                                <div class="col-md-5">
                                   	${specialist.expertise}
                                </div>
                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="newPost" value="${specialist.post}" maxlength="48">
                                </div>
                            </div><br/>
                            <div class="form-group row">
                                <label  class="col-md-5">电话：</label>
                                <label  class="col-md-5 col-md-offset-2">工作单位：</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="newPhone" value="${specialist.phone}" maxlength="11">
                                </div>
                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="newWorkUnit" value="${specialist.workUnit}" maxlength="48">
                                </div>
                            </div><br/>
                            <div class="form-group row">
                                <label  class="col-md-5">通讯地址：</label>
                                <label  class="col-md-5 col-md-offset-2">邮箱：</label>
                                <div class="col-md-5">
                                    	${specialist.path}
                                </div>
                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="newEmail" value="${specialist.email}" maxlength="48">
                                </div>
                            </div><br/>

                            <div class="form-group row">
                                <div class="col-md-2 col-md-offset-5">
                                    <button type="button" class="btn btn-primary" id="sure">确定修改</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>

            </div>
            <!--end content-->

        </div><!--end main-->

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

    </div><!--end bg_wrapper-->

    <div  id="footer" style="color: #fff;text-align: center">
        Copyright 2018 - 2019 One. All Rights Reserved
    </div><!--end footer-->
	<input type="hidden" name="id" id="id" value='${specialist.id}'>
</div><!-- end top -->
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script type='text/javascript' src='js/custom.js'></script>
<script type='text/javascript' src='js/modifier_specialist.js'></script>
</body>

</html>