<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 添加专家信息 -->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>首页</title>
    <link rel="stylesheet" href="../css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/fileinput.min.css"/>
    <link rel="stylesheet" href="../css/style.css"  type="text/css" media="screen" />
</head>

<body>
<div id="top">
    <div id="head">
        <h3 class="logo"><span>森</span>林病虫害防治系统</h3>

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
                        <li><a href="#">专家会商</a></li>
                        <li class="active"><a href="#">专家一览</a></li>
                        <li class="active">添加专家</li>
                    </ol>
                </div>

                <div  class="panel panel-info col-md-10 col-md-offset-1">
                    <div class="panel-heading">添加专家信息</div>
                    <div class="panel-body">
                        <form class="form-horizontal" enctype="multipart/form-data" action="../specialistAdd" method="post">
                            <div class="form-group row">
                                <label  class="col-md-5">姓名</label>

                                <label  class="col-md-5 col-md-offset-2">性别</label>

                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="name" placeholder="姓名" maxlength="48">
                                </div>

                                <div class="col-md-5 col-md-offset-2">
                                    <select class="form-control" name="gender">
                                        <option value="1">男</option>
                                        <option value="0">女</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label  class="col-md-5">出生年月</label>

                                <label  class="col-md-5 col-md-offset-2">照片</label>

                                <div class="col-md-5">                 
                                    <input class="form-control Wdate" name="bithday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})" />
                                </div>

                                <div class="col-md-5 col-md-offset-2">
                                    <input id="file-pic1" name="uploadImgFile" type="file" value="上传"  multiple/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label  class="col-md-5">专长</label>

                                <label  class="col-md-5 col-md-offset-2">职务</label>

                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="expertise" placeholder="专长" maxlength="48">
                                </div>

                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="post" placeholder="职务" maxlength="48">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label  class="col-md-5">电话</label>

                                <label  class="col-md-5 col-md-offset-2">工作单位</label>

                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="phone" placeholder="电话号码" maxlength="11">
                                </div>

                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="workUnit" placeholder="工作单位" maxlength="48">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label  class="col-md-5">通讯地址</label>

                                <label  class="col-md-5 col-md-offset-2">邮箱</label>

                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="path" placeholder="通讯地址" maxlength="48">
                                </div>

                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control" name="email" placeholder="邮箱" maxlength="48">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-2 col-md-offset-5">
                                    <button type="button" class="btn btn-primary" id="add">添加</button>
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

    </div><!--end bg_wrapper-->

    <div  id="footer" style="color: #fff;text-align: center">
        Copyright 2018 - 2019 One. All Rights Reserved
    </div><!--end footer-->

</div><!-- end top -->
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/jquery-ui.js"></script>
<script type='text/javascript' src='../js/custom.js'></script>
<script src="../js/fileinput.min.js"></script>
<script src="../js/zh.js"></script>
<script language="javascript" type="text/javascript"
	src="../js/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript"
	src="../js/addspecialist.js"></script>
</body>

</html>