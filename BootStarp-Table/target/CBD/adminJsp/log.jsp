<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../general/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../general/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../general/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../general/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../general/js/bootstrap.min.js"></script>


<title>日志管理</title>

</head>
<body>
		<div id="container">
			<div id="box_center">
				前台/后台
				<select name="fangyuanEntity.fyXqCode" id="fyXq" class="ui_select01" onchange="getFyDhListByFyXqCode();">
					<option value="">--请选择--</option>
					<option value="6">前台</option>
					<option value="77">后台</option>
				</select>

				操作/登录
				<select name="fangyuanEntity.fyDhCode" id="fyDh" class="ui_select01">
					<option value="">--请选择--</option>
					<option value="">操作</option>
					<option value="">登录</option>
				</select>
				日期
				<input type="text" class="form-control" id="brithday" name="brithday" readonly="readonly"
					   value="" placeholder="请选择日期" onClick="WdatePicker()" style="height: 30px;width: 150px;display: inline-block">

				用户名
				<input type="text" value="" style="height: 30px">
				&nbsp;&nbsp;<button type="button" class="btn btn-primary">查询</button>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table table-hover" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>用户名</th>
							<th>何时何地（IP地址）</th>
							<th>日期</th>
							<th>操作</th>
						</tr>
						<tbody id="">
						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>

							<!--<td>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
									模态框
								</button>
							</td>-->
						</tr>

						<tr>
							<<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						<tr>
							<td>哈迪斯</td>
							<td>192.168.16.100</td>
							<td>2018-4-5</td>
							<td>退出系统</td>
						</tr>

						</tbody>

					</table>

					<!-- 模态框-->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel">Modal title</h4>
								</div>
								<div class="modal-body">
									模态框填充内容
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save changes</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						共有
						<span class="ui_txt_bold04">90</span>
						条记录，当前第
						<span class="ui_txt_bold04">1
						/
						9</span>
						页
					</div>
					<div class="ui_frt">
						<!--    如果是第一页，则只显示下一页、尾页 -->

							<input type="button" value="首页" class="ui_input_btn01" />
							<input type="button" value="上一页" class="ui_input_btn01" />
							<input type="button" value="下一页" class="ui_input_btn01"
								onclick="jumpNormalPage(2);" />
							<input type="button" value="尾页" class="ui_input_btn01"
								onclick="jumpNormalPage(9);" />



						<!--     如果是最后一页，则只显示首页、上一页 -->

						转到第<input type="text" id="jumpNumTxt" class="ui_input_txt01" />页
							 <input type="button" class="ui_input_btn01" value="跳转" onclick="jumpInputPage(9);" />
					</div>
				</div>
				<br/>
			</div>

		</div>
</body>

</html>