<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<!--添加药剂管理页面-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"  type="text/css" media="screen" />
<link rel="stylesheet" href="css/pagination.css" />

</head>
<body>

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
                                    <li><a href="#">药剂器械出库管理</a></li>
                                    <li class="active">药剂管理</li>
                                </ol>
                            </div>

                            <table class="table table-hover">
                                <tr class="info">
                                    <th>名称</th>
                                    <th>防治类型</th>
                                    <th>适合病虫害</th>
                                    <th>适合树种</th>
                                </tr>
                                <c:forEach var="li" items="${pageBean.pageData}">
                                	<tr>
                                		<td id="name" value="${li.id}">${li.name}</td>
                                		<td>${li.insect.type}</td>
                                		<td>${li.diseases.diseasesType }</td>
                                		<td>${li.tree }</td>
                                	</tr>
                                </c:forEach>
                                
                            </table>
							<div id="pagination_2" ></div>
							
                            <div class="panel panel-info col-md-5">
                                <div class="panel-heading">添加药剂信息</div>
                                <div class="panel-body">
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <button type="button" class="btn btn-primary btn-all" id="additive">添加药剂</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!--查询-->
                            <div class="panel panel-info col-md-5 col-md-offset-2">
                                <div class="panel-heading">查询药剂信息</div>
                                <div class="panel-body">
                                    <form class="form-horizontal"  >
                                        <div class="form-group">
                                            <label for="inputEmail3" class="">药剂名称</label>
                                            <div class="">
                                                <input onkeyup="value=value.replace(/[^0-9\u4E00-\u9FA5]/g,'')" type="text" class="form-control" id="names" name="name" placeholder="只能输入中文、数字">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail3" class="">防止类型</label>
                                            <div class="">
                                                <input onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" type="text" class="form-control" id="type" name="type" placeholder="只能输入中文">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword3" class="">适合病虫害</label>
                                            <div class="">
                                                <input onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" type="text" class="form-control" id="diseasesType" name="diseasesType" placeholder="只能输入中文">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-3 col-md-offset-9">
                                                <button id="butt"type="button" class="btn btn-primary ">查询</button>
                                                
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
                
        </div><!-- end top -->
        <input type="hidden" name="pageSize" value='${pageBean.pageSize}'>
		<input type="hidden" name="totalNum" value='${pageBean.totalNum}'>
		<input type="hidden" name="totalData" value='${pageBean.totalData}'>
        <script src="js/jquery-1.7.2.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type='text/javascript' src='js/custom.js'></script>
        <script src="js/pagination.min.js"></script>
        <script language="javascript" type="text/javascript"
			src="js/WdatePicker.js"></script>
		<script src="js/pharmacy_management.js"></script>
	
</body>
</html>