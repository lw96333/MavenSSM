<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
   <link rel="stylesheet" type="text/css" href="share/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="share/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="share/h-ui.admin/css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/pagination.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>后台管理员</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="javascript:void(0)">CBD停车管理系统-后台管理员</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>管理员</li>
                    <li class="dropDown dropDown_hover">
                        <a href="javascript:void(0)" class="dropDown_A" id="admin"><i class="Hui-iconfont">&#xe6d5;</i></a>
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
		<shiro:hasPermission name="admin:super">
	    	<dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i>超级管理员<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/backstage/spuer/AddAdmin.jsp" data-title="新增管理员" href="javascript:void(0)">新增管理员</a></li>
	                    <li><a data-href="jsp/backstage/spuer/ShowAdmin.jsp" data-title="查看管理员" href="javascript:void(0)">查看管理员</a></li>
	                	<li><a data-href="jsp/backstage/spuer/billingSystem.jsp" data-title="租赁费用" href="javascript:void(0)">租赁费用</a></li>
	                </ul>
	            </dd>
	        </dl>

	   	</shiro:hasPermission>
		
	   		<dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i> 后台管理员模块<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/backstage/admin/adnim-updata.jsp" data-title="修改管理员信息" href="javascript:;">修改个人信息</a></li>
	                </ul>
	            </dd>
            </dl>
		
	   	<shiro:hasPermission name="admin:personal">
		   	<dl>
	            <dt><i class="Hui-iconfont">&#xe60c;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
	            <dd>
	                <ul>
	                    <li><a data-href="jsp/backstage/admin/lease/enterpriseShow.jsp" data-title="查看企业用户" href="javascript:void(0)">查看企业用户</a></li>
	                    <li><a data-href="jsp/backstage/admin/lease/enterpriseAdd.jsp" data-title="新增企业用户" href="javascript:void(0)">新增企业用户</a></li>
	                    <li><a data-href="jsp/backstage/admin/userPrivileges/ApprovalPersonalAddParking.jsp" data-title="审批个人添加车位" href="javascript:void(0)">审批个人添加车位</a></li>
	                    <li><a data-href="jsp/backstage/admin/userPrivileges/ApprovalPersonBusinessParking.jsp" data-title="审批个人买卖车位" href="javascript:void(0)">审批个人买卖车位</a></li>
	                    <li><a data-href="jsp/backstage/Complaint-page.jsp" data-title="投诉管理" href="javascript:void(0)">投诉管理</a></li>
	                </ul>
	            </dd>
	        </dl>
		</shiro:hasPermission>
       	<shiro:hasPermission name="admin:lease">
        <dl>
            <dt><i class="Hui-iconfont">&#xe6b9;</i> 车位管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="jsp/backstage/admin/parkingManagement/TruckSpace-add.jsp" data-title="添加车位" href="javascript:void(0)">添加车位</a></li>
                    <li><a data-href="jsp/backstage/admin/parkingManagement/TruckSpace-show.jsp" data-title="查看车位" href="javascript:void(0)">查看车位</a></li>
                </ul>
            </dd>
        </dl>
		</shiro:hasPermission>
		<shiro:hasPermission name="admin:carpaking">
        <dl>
            <dt><i class="Hui-iconfont">&#xe6b7;</i> 合约管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="jsp/backstage/admin/externalContact/RenewalExternalContracts.jsp" data-title="新增外部合约" href="javascript:void(0)">新增外部合约</a></li>
                    <li><a data-href="jsp/backstage/admin/externalContact/ViewExternalContracts.jsp" data-title="查看外部合约" href="javascript:void(0)">查看外部合约</a></li>
                </ul>
            </dd>
        </dl>
        </shiro:hasPermission>
        <shiro:hasPermission name="admin:external">
        <dl>
            <dt><i class="Hui-iconfont">&#xe6b7;</i> 租户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="jsp/backstage/admin/lease/contract-add.jsp" data-title="租户签约" href="javascript:void(0)">租户签约</a></li>
                    <li><a data-href="jsp/backstage/admin/lease/contract-list.jsp" data-title="租户合约" href="javascript:void(0)">租户合约</a></li>
                </ul>
            </dd>
        </dl>

        </shiro:hasPermission>

        <dl>
            <dt><i class="Hui-iconfont">&#xe6b7;</i> 性能统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                <li><a data-href="jsp/backstage/LogRecord.jsp" data-title="日志显示" href="javascript:void(0)">日志显示</a></li>
                    <li><a data-href="jsp/backstage/PerformanceStatistics.jsp" data-title="在线人数" href="javascript:void(0)">在线人数</a></li>
                    <li><a data-href="jsp/backstage/PerformanceStatistics2.jsp" data-title="性能统计" href="javascript:void(0)">性能统计</a></li>
                </ul>
            </dd>
        </dl>

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
<script type="text/javascript" src="share/h-ui.admin/js/H-ui.admin.js"></script>  <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="js/admin-index.js"></script>


</body>
</html>