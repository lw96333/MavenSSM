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

    <title>账单显示</title>

</head>
<body>
<div id="container">
    <div class="ui_content">
        <div class="ui_tb">
            <h2>账单记录</h2><br/>
            <div>
                起始日期：<input type="text" class="form-control" id="brithday" name="brithday" readonly="readonly"
                            value="" placeholder="请选择开始日期" onClick="WdatePicker()" style="height: 30px;width: 150px;display: inline-block">

                结束日期：<input type="text" class="form-control" id="brithday2" name="brithday" readonly="readonly"
                            value="" placeholder="请选择结束日期" onClick="WdatePicker()" style="height: 30px;width: 150px;display: inline-block">

                <button type="button" class="btn btn-info btn-sm" >搜索</button>
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">合计账单</button>
            </div>
            <br/>
            <table class="table table-hover" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                <tr>
                    <th>交易日期</th>
                    <th>交易时间</th>
                    <th>支出</th>
                    <th>收入</th>
                    <th>交易备注</th>
                </tr>
                <tbody id="">
                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼1-111</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼1-112</td>
                    <td>67.47㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼2-121</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼2-122</td>
                    <td>67.47㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼3-131</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼3-132</td>
                    <td>67.47㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼4-141</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼4-142</td>
                    <td>67.47㎡</td>
                    <td>一室一厅一卫</td>
                    <td>混凝土</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼5-151</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>公租房</td>
                </tr>

                <tr>
                    <td>城中区</td>
                    <td>瑞景河畔16号楼6-161</td>
                    <td>65.97㎡</td>
                    <td>一室一厅一卫</td>
                    <td>公租房</td>
                </tr>

                </tbody>

            </table>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">账单总计</h4>
                        </div>
                        <div class="modal-body">
                            <table class="table table-hover">
                                <tr>
                                    <td>交易总笔数</td>
                                    <td>30笔</td>
                                </tr>
                                <tr>
                                    <td>总收入</td>
                                    <td>￥25000.00</td>
                                </tr>
                                <tr>
                                    <td>总支出</td>
                                    <td>￥25000.00</td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">确定</button>
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