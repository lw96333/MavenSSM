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

<title>个人用户车位审批</title>

</head>
<body>
		<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<h2>个人用户新增车位申请信息</h2>
					<table class="table table-hover" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>用户名</th>
							<th>真实姓名</th>
							<th>电话号码</th>
							<th>身份证号码</th>
							<th>申请时间</th>
							<th>车位审核状态</th>
							<th>操作</th>
						</tr>
						<tbody id="">
						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼1-111</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">查看</button>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼1-112</td>
							<td>67.47㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>已配租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458625716623" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼2-121</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼2-122</td>
							<td>67.47㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼3-131</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼3-132</td>
							<td>67.47㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼4-141</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼4-142</td>
							<td>67.47㎡</td>
							<td>一室一厅一卫</td>
							<td>混凝土</td>
							<td>已配租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼5-151</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>公租房</td>
							<td>建成待租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
							</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼6-161</td>
							<td>65.97㎡</td>
							<td>一室一厅一卫</td>
							<td>公租房</td>
							<td>已配租</td>
							<td>
								<a href="house_edit.jsp?fyID=14458579642011" class="edit">查看</a>
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
									<h4 class="modal-title" id="myModalLabel">审批个人新增车位信息</h4>
								</div>
								<div class="modal-body">
									<table class="table table-hover">
										<tr>
											<th>个人用户信息</th>
											<th>申请发布车位信息</th>
										</tr>
										<tr>
											<td>用户名：张三</td>
											<td>车位地址：成华区</td>
										</tr>
										<tr>
											<td>真实姓名：张二娃</td>
											<td>车位编号：CF303</td>
										</tr>
										<tr>
											<td>身份证号：5201254521545214</td>
											<td>车位产权编号：1524542545</td>
										</tr>
										<tr>
											<td>职业信息：教师</td>
											<td>车位产权复印件</td>
										</tr>
										<tr>
											<td>家庭地址：成华区成华大道</td>
											<td>
												<img src="../images/huge.jpg" alt="" style="height: 60px;width: 40px;"/>
											</td>
										</tr>


									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success">审核通过</button>
									<button type="button" class="btn btn-default" >审核未通过</button>
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
