<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 专家会商信息 -->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>首页</title>
    <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"  type="text/css" media="screen" />
	<link rel="stylesheet" href="css/pagination.css" />
    <style>
        .col-md-4{
            width: 100%;
        }
    </style>
</head>

<body>
<div class='modal my-modal-alert' id='my-modal-alert'>
    <div class='modal-dialog boxBodySmall'>
        <div class='modal-content'>
            <div class='modal-header boxHeader'>
                <button type='button' class='close boxClose' data-dismiss='modal'>
                    <span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>
                </button>
                <h4 class='modal-title boxTitle' id='modal-title'>提示</h4>
            </div>
            <div class='modal-body' id='modal-body-alert'>
                <div id='modal_message'></div>
                <span id='num'></span>
            </div>
        </div>
    </div>
</div>
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
                        <li class="active"><a href="#">会商灾情</a></li>
                        <li class="active">专家会商</li>
                    </ol>
                </div>

                <div  class="panel panel-info col-md-10 col-md-offset-1">
                    <div class="panel-heading">专家会商信息</div>
                    <div style=" left: 550px;top: 85px;position: absolute">
                        <img src="${irb.pic }" alt="" style="width: 245px;height: 175px;"/>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="instrumentAdd" method="post">
                            <div class="form-group row">
                                <label  class="col-md-5" >事件名称</label>
                                <label  class="col-md-5 col-md-offset-2">灾区图片</label>
                                <div class="col-md-5" >
                                    	${irb.eventName }
                                </div>

                            </div>
                            <div class="form-group row">
                                <label  class="col-md-4">时间</label>
                                <div class="date col-md-5">
                                    <fmt:formatDate value="${irb.time }" pattern="yyyy-MM-dd" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-4">发生位置</label>
                                <div class="ardees col-md-5">
                                   	 ${irb.smallClass.areaIn.name }
                                </div>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-5">灾情描述</label>
                                <label  class="col-md-5 col-md-offset-2">影响面积</label>
                                <div class="col-md-5">
                                    	 ${irb.disaster }
                                </div>
                                <div class="col-md-5 col-md-offset-2">
                                    ${irb.influence }
                                </div>
                            </div>
                            <div class="form-group row">
                                <label  class="col-md-5">会商结果</label>
                                <label  class="col-md-5 col-md-offset-2">会商人员</label>
                                <div class="col-md-5 result">
                                    <textarea class="form-control " rows="3" name="result" maxlength="50"></textarea>
                                </div>
                                <div class="col-md-5 col-md-offset-2">
                                    <input type="text" class="form-control user" name = "persons" maxlength="30">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="btus"style="top: 420px;left: 550px;position:absolute;">
                                    <button type="button" class="btn btn-primary" id="add">添加会商信息</button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="button" class="btn btn-primary" id="back">返回</button>
                                </div>
                            </div>

                        </form>
                        <table class="table table-hover">
                            <tr class="info">
                                <th>日期</th>
                                <th>会商人员</th>
                                <th>会商结果</th>
                            </tr>
                            <c:forEach var="li" items="${pageBean.pageData}">
	                        	<tr>
	                        		<td >${li.date}</td>
	                        		<td>${li.persons }</td>
	                        		<td>${li.result }</td>
	                        	</tr>
	                        </c:forEach>
                        </table>
                        <!-- 表格 左右按钮 -->
						<div id="pagination_2" style="margin-left:0px;"></div>
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

</div><!-- end top -->
<input type="hidden" name="irbId" value='${irb.id}'>
<input type="hidden" name="pageSize" value='${pageBean.pageSize}'>
<input type="hidden" name="totalNum" value='${pageBean.totalNum}'>
<input type="hidden" name="totalData" value='${pageBean.totalData}'>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery-ui.js"></script>
<script type='text/javascript' src='js/custom.js'></script>
<script src="js/pagination.min.js"></script>
<script src="js/specialist_consult.js"></script>

</body>

</html>