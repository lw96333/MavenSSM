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

<title>信息管理系统</title>

</head>
<body>
		<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
						单车位添加
					</button>

					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
						批量添加车位
					</button>
					<br/>
					<br/>
					<table class="table table-hover" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>车位所在位置</th>
							<th>车位编号</th>
							<th>车位状态</th>
						</tr>
						<tbody id="">
						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼1-111</td>
							<td>65.97㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼1-112</td>
							<td>67.47㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼2-121</td>
							<td>65.97㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼2-122</td>
							<td>67.47㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼3-131</td>
							<td>65.97㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼3-132</td>
							<td>67.47㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼4-141</td>
							<td>65.97㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼4-142</td>
							<td>67.47㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼5-151</td>
							<td>65.97㎡</td>
						</tr>

						<tr>
							<td>城中区</td>
							<td>瑞景河畔16号楼6-161</td>
							<td>65.97㎡</td>
						</tr>

						</tbody>

					</table>

					<!-- 模态框-->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="myModalLabel">单车位添加</h4>
								</div>
								<div class="modal-body">
									<table  class="table table-hover">
										<tr>
											<td>车位所在地址</td>
											<td><input type="text "/></td>
										</tr>
										<tr>
											<td>车位编号</td>
											<td><input type="text "/></td>
										</tr>
									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
									<button type="button" class="btn btn-primary"  data-dismiss="modal">取消</button>
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
									<h4 class="modal-title" id="myModalLabel2">批量添加车位</h4>
								</div>
								<div class="modal-body">
									<table  class="table table-hover">
										<tr>
											<td>车位所在地址</td>
											<td><input type="text "/></td>
										</tr>
										<tr>
											<td>车位区域编号</td>
											<td><input type="text "/></td>
										</tr>
										<tr>
											<td>车位起始号</td>
											<td><input type="text "/></td>
										</tr>
										<tr>
											<td>车位总数</td>
											<td><input type="text "/></td>
										</tr>
									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
									<button type="button" class="btn btn-primary"  data-dismiss="modal">取消</button>
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