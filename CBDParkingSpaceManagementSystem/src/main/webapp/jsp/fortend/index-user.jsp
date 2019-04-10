<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="./lib/html5shiv.js"></script>
    <script type="text/javascript" src="./lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="css/news.css"/>
    <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/pagination.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="./lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>个人用户</title>
</head>
<body>
<span id="id" style="display: none;">${user.userid}</span>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="javascript:void(0)">CBD停车管理系统-用户</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>用户你好！</li>
                    <li class="dropDown dropDown_hover">
                        <a href="javascript:void(0)" class="dropDown_A" id="admin"> <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                  
                            <li><a href="javascript:void(0)" id="out">退出</a></li>
                        </ul>
                    </li>
                    
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
    	<shiro:hasPermission name="user:person">
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i> 信息修改<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/Alter.jsp" data-title="修改个人信息" href="javascript:;">修改个人信息</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i> 车位信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/personal/CarRentalFrontPage.jsp" data-title="出租车位" href="javascript:void(0)">出租车位</a></li>
	                    <li><a data-href="jsp/fortend/personal/SaleOfParkingSpaceHomePage.jsp" data-title="卖车车位" href="javascript:void(0)">出售车位</a></li>
	                    <li><a data-href="jsp/fortend/personal/AddParking.jsp" data-title="添加车位" href="javascript:void(0)">添加车位</a></li>
	                    <li><a data-href="jsp/fortend/personal/ShowPersonageAddCarport.jsp" data-title="查看车位" href="javascript:void(0)">查看车位</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe6b9;</i> 车位租赁<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/personal/ParkingSpaceRental.jsp" data-title="查看出租车位" href="javascript:void(0)">查看出租车位</a></li>
	                    <li><a data-href="jsp/fortend/personal/RentalParkingSpace.jsp" data-title="查看租赁车位" href="javascript:void(0)">查看租赁车位</a></li>
	                    
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe6b8;</i> 车位卖买<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/personal/ParkingDetails.jsp" data-title="查看出售车位" href="javascript:;">查看出售车位</a></li>
	                    <li><a data-href="jsp/fortend/personal/parBuyShow.jsp" data-title="查看购买车位" href="javascript:;">查看购买车位</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe627;</i> 历史记录<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/personal/HistoryRentalParkingSpace.jsp" data-title="历史租赁记录" href="javascript:void(0)">历史租赁记录</a></li>
	                    <li><a data-href="jsp/fortend/personal/HistoryParkingSpaceRental.jsp" data-title="历史出租记录" href="javascript:void(0)">历史出租记录</a></li>
	                    <li><a data-href="jsp/fortend/personal/parkSellRecordShow.jsp" data-title="历史出售记录" href="javascript:void(0)">历史出售记录</a></li>
	                    <li><a data-href="jsp/fortend/personal/parkBuyRecordShow.jsp" data-title="历史购买记录" href="javascript:void(0)">历史购买记录</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe6b7;</i> 费用统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/personal/billingPerson.jsp" data-title="租赁费用" href="javascript:void(0)">租赁费用</a></li>
	                </ul>
	            </dd>
	        </dl>
       </shiro:hasPermission>
       <shiro:hasPermission name="user:enterprise">
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i> 信息修改<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/enterprise/EnterpriseInformation-update.jsp" data-title="修改企业信息" href="javascript:;">修改企业信息</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe6b9;</i> 车位租赁<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/enterprise/LeisureTruckSpace-show.jsp" data-title="查看空闲车位" href="javascript:void(0)">查看空闲车位</a></li>
	                    <li><a data-href="jsp/fortend/enterprise/AlreadyTakenCompany-show.jsp" data-title="查看已租赁车位" href="javascript:void(0)">查看已租赁车位</a></li>
	                </ul>
	            </dd>
	        </dl>
	        <dl>
	            <dt><i class="Hui-iconfont">&#xe6b7;</i> 费用统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/fortend/enterprise/billingEnterprise.jsp" data-title="交易费用" href="javascript:void(0)">交易费用</a></li>
	                </ul>
	            </dd>
	        </dl>
       </shiro:hasPermission>

    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="welcome.html">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <!-- 查询 -->
            <iframe scrolling="yes" frameborder="0" src=""></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="share/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="js/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="js/new.js"></script>
<script type="text/javascript" src="js/webSoket.js"></script>
<script type="text/javascript" src="js/index-user.js"></script>


</body>
</html>