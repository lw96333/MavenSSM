<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../general/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../general/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../general/style/authority/common_style.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="../general/css/fileinput.min.css"/>
<script type="text/javascript" src="../general/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../general/js/bootstrap.min.js"></script>

<title>外部合约管理系统</title>

</head>
<body>

		<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<div class="btn btn-info"  data-toggle="modal" data-target="#myModal2">新增外部合约</div>
					<table class="table table-hover" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>合同编号</th>
							<th>对方联系人</th>
							<th>对方联系电话</th>
							<th>合同失效日期</th>
							<th>操作</th>

						</tr>
						<tbody id="">
						<tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr>
						<tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr><tr>
							<td>2012110849</td>
							<td>张三</td>
							<td>18328564682</td>
							<td>2019-12-25</td>

							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">
									续约
								</button>
								<button type="button" class="btn btn-warning btn-sm" data-toggle="modal" >
									解约
								</button>
							</td>
						</tr>









						</tbody>

					</table>

					<!-- 模态框-->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel">外部合约续约</h4>
								</div>
								<div class="modal-body">
									<table>
										<tr>
											<td><span>原合同编号：</span></td>
											<td><input type="text"/></td>
											<td><span>对方联系电话：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>新续合同编号:</span></td>
											<td><input type="text"/></td>
											<td><span>合同生效期：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>对方联系人：</span></td>
											<td><input type="text"/></td>
											<td><span>成交价格：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>上传合同复印件：</span></td>
											<td><input class="file-pic1" name="uploadImgFile" type="file"  value="上传"  multiple/></td>
											<td></td>
										</tr>
									</table>


								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary">续约</button>
								</div>
							</div>
						</div>
					</div>



					<!-- 模态框-->
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel2">添加外部合约</h4>
								</div>
								<div class="modal-body">
									<table>
										<tr>
											<td><span>合同编号：</span></td>
											<td><input type="text"/></td>
											<td><span>合同生效日期：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>合同单位:</span></td>
											<td><input type="text"/></td>
											<td><span>合同截止时间：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>对方联系人：</span></td>
											<td><input type="text"/></td>
											<td><span>成交价格：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>对方联系人电话：</span></td>
											<td><input type="text"/></td>
											<td><span>车位地址：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>车位所属单位详细地址：</span></td>
											<td><input type="text"/></td>
											<td><span>车位编号：</span></td>
											<td><input type="text"/></td>
										</tr>
										<tr>
											<td><span>上传合同复印件：</span></td>
											<td><input class="file-pic1"  name="uploadImgFile" type="file"  value="上传"  multiple/></td>
											<td></td>
										</tr>
									</table>


								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary">新增</button>
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