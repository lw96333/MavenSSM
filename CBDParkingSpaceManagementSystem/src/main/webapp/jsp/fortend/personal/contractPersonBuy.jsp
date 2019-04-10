<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<base href=<%=basePath %>/>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	
	<link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagination.css" />
	
	<title>车位出售合同</title>
    <style>
        @font-face { 
		  font-family: SketchRockwell; 
		  src: url(‘SketchRockwell.ttf’); 
		} 
    </style>	
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form-member-add">
	       <div class="panel">
               <div class="panel-body">
                   <table class="table" style="outline: 1px black solid; ">
                       <tbody>
                            <tr>
                                <td colspan="4"></td>
                            </tr>
                            <tr>
                                <td colspan="4" style="font-size: 2em;text-align: center;">车位出售合同</td>
                            </tr>
                            <tr>
                                <td colspan="4"></td>
                            </tr>
                            <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr >
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;border-color: gray;">合同编号:</td>
                               <td><span id="hetong" style="font-size: 1.2em;">CBDC-1300151</span></td>
                               <td></td>
                               <td></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">车位出售方信息:</td>
                               <td></td>
                               <td></td>
                               <td></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">用户名:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">真实姓名:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">身份证号:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">电话号码:</td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td><span id="cname" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="czname" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="csfz" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="cphone" style="font-size: 1.2em;">1111</span></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;" >车位购买方信息:</td>
                               <td></td>
                               <td></td>
                               <td></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">用户名:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">真实姓名:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">身份证号:</td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">电话号码:</td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td><span id="gname" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="gzname" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="gsfz" style="font-size: 1.2em;">1111</span></td>
                               <td><span id="gphone" style="font-size: 1.2em;">1111</span></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;" >车位信息:</td>
                               <td></td>
                               <td></td>
                               <td></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;" >车位地址:</td>
                               <td><span id="caddress" style="font-size: 1.2em;">1111</span></td>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">车位产权编号:</td>
                               <td><span id="cbianhao" style="font-size: 1.2em;">1111</span></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                           <tr>
                               <td style="font-size: 1.2em;font-family: Microsoft YaHei;">交易金额:</td>
                               <td><span id="pyjy" style="font-size: 1.2em;">9999</span>&nbsp;&nbsp;<strong>元</strong></td>
                               <td></td>
                               <td></td>
                           </tr>
                           <tr>
                                <td colspan="4"></td>
                            </tr>
                            <tr>
                                <td colspan="4"></td>
                            </tr>
                       </tbody>
                   </table>
                   <div class="" style="margin: 30px 270px">
                       <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;同意&nbsp;&nbsp;" id="btnt">
                       <input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;取消&nbsp;&nbsp;" id="btnq">
                   </div>
               </div>
           </div>
		</form>
	</article>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="js/contractPersonBuy.js"></script>
</body>
</html>