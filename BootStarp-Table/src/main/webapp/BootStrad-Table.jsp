<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap-table.min.css">
	<!--按照下面顺序引用jquery必须先引用 -->
	 <script src="jquery-3.3.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="bootstrap-table.min.js"></script>
    <script src="bootstrap-table-zh-CN.min.js"></script>
 
<script type="text/javascript" src="BootStrad-Table.js"></script>



<title>学生管理管理系统</title>

</head>
<body>
<span>姓名:</span><input id="name" class=""  type="text"  />
		
					<table id="bootstarp" class="table table-hover">
					
					</table>
	
					<!-- 模态框-->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel">学生详情信息</h4>
								</div>
								<div class="modal-body">
									<table>
										<tr>
											<td><span>学号：</span></td>
											<td><input id="id" class="form-control" readonly="readonly"  type="text" readonly="readonly"/></td>
											
											<td><span>姓名：</span></td>											
     										<td><input type="text" class="form-control"  id="name" name="starttimes" readonly="readonly">
     										</td>
										</tr>
										<tr>
											<td><span>电话：</span></td>
											<td><input  id="phone" class="form-control"   type="text"  readonly="readonly" /></td>
     										<td><span>住址：</span></td>
											<td><input id="address" class="form-control"   type="text"  readonly="readonly"  /></td>
										</tr>
									
									</table>


								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									
								</div>
							</div>
						</div>
					</div>
				
</body>



</html>