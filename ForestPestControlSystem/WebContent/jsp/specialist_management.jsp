<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!--添加专家页面-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>添加专家</title>
        <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"  type="text/css" media="screen" />
		<link rel="stylesheet" href="css/pagination.css" />
		<link rel="stylesheet" href="css/demo.css" />
		<style type="text/css">
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
                <h3 class="logo" ><span>森</span>林病虫害防治系统</h3>
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
                                    <li class="active">专家一览</li>
                                </ol>
                            </div>
                            <!--专家一览 表格信息-->
                            <table class="table table-hover " >
                                <tr class="info">
                                	<th ><input type="checkbox" name="Allchonse"/></th>
                                    <th>姓名</th>
                                    <th>工作单位</th>
                                    <th>专长</th>
                                    <th>职务</th>
                                    <th>电话</th>
                                </tr>
                                <tbody class="tbody">
	                                <c:forEach var="li" items="${pageBean.pageData}">
	                                	<tr>
	                                		<td><input type="checkbox" name="chonse"/></td>
	                                		<td id="name" value="${li.id}">${li.name}</td>
	                                		<td>${li.workUnit }</td>
	                                		<td>${li.expertise }</td>
	                                		<td>${li.post }</td>
	                                		<td>${li.phone }</td>
	                                	</tr>
	                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- 表格 左右按钮 -->
                            
							<div id="pagination_2" style="margin-left: 0%;"></div>
                          
                            <!-- 操作专家信息 按钮 -->
                            <div class="panel panel-info col-md-5">
                                <div class="panel-heading">操作专家信息</div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <button type="button" class="btn btn-primary btn-all" id="addPerson">添加专家</button>
                                        </div>
                                        <div class="form-group col-md-6" >
                                            <button type="button" class="btn btn-primary btn-all" id="checkPerson">查看专家信息</button>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <button type="button" class="btn btn-primary btn-all" id="updatePerson">修改专家信息</button>
                                        </div>
                                        <div class="form-group col-md-6" >
                                            <button type="button" class="btn btn-primary btn-all" id="deletePerson">删除专家</button>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-md-6">
                                            <button type="button" class="btn btn-primary btn-all" id="company">公司人数统计</button>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <!--查询-->
                            <div class="panel panel-info col-md-5 col-md-offset-2">
                                <div class="panel-heading">查询专家信息</div>
                                <div class="panel-body">
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <label for="" class="">专家姓名</label>
                                            <div class="">
                                                <input type="text" class="form-control" id="queryName" placeholder="专家姓名" maxlength="20">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="" class="">专长</label>
                                            <div class="">
                                                <input type="text" class="form-control" id="queryExpertise" placeholder="专长" maxlength="20">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="" class="">工作单位</label>
                                            <div class="">
                                                <input type="text" class="form-control" id="queryWorkUnit" placeholder="工作单位" maxlength="20">
                                            </div>
                                        </div>
                                     
                                        <div class="form-group">
                                            <div class="col-md-3 col-md-offset-9">
                                                <button type="button" class="btn btn-primary" id="query">查询</button>
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
		<input type="hidden" name="add" value='${add}'>
        <script src="js/jquery-1.7.2.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type='text/javascript' src='js/custom.js'></script>
        <script src="js/pagination.min.js"></script>
		<script src="js/specialist_management.js"></script>
    </body>
    
</html>