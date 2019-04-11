<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>交易详情</title>
    <link rel="stylesheet" href="../assets/css/amazeui.css" />
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/css/core.css" />
    <link rel="stylesheet" href="../assets/css/menu.css" />
    <link rel="stylesheet" href="../assets/css/index.css" />
    <link rel="stylesheet" href="../assets/css/admin.css" />
    <link rel="stylesheet" href="../assets/css/page/typography.css" />
    <link rel="stylesheet" href="../assets/css/page/form.css" />
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
    <div class="am-topbar-left am-hide-sm-only">
        <a href="../index.jsp" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
    </div>

    <div class="contain">
        <ul class="am-nav am-navbar-nav am-navbar-left">

            <li><h4 class="page-title">交易记录</h4></li>
        </ul>

        <ul class="am-nav am-navbar-nav am-navbar-right">
            <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
        </ul>
    </div>
</header>
<!-- end page -->


<div class="admin">
    <!--<div class="am-g">-->
    <!-- ========== Left Sidebar Start ========== -->
    <!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
            <div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
    <!-- sidebar start -->
    <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <!-- User -->
            <div class="user-box am-hide-sm-only">
                <div class="user-img">
                    <img src="../assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
                    <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
                </div>
                <h5><a href="#">Mat Helme</a> </h5>
                <ul class="list-inline">
                    <li>
                        <a href="#">
                            <i class="am-icon-cog" aria-hidden="true"></i>
                        </a>
                    </li>

                    <li>
                        <a href="#" class="text-custom">
                            <i class="am-icon-cog" aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- End User -->

           <ul class="am-list admin-sidebar-list">
                <li><a href="../index.jsp"><span class="am-icon-home"></span> 个人主页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 车位管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="table_basic.jsp" class="am-cf"> 我的车位</a></li>
                        <li><a href="table_complete.jsp">车位租赁</a></li>
                        <li><a href="parking_space_purchase.jsp">车位购买</a></li>
                        <li><a href="treaty.jsp">网上签约</a></li>
                    </ul>
                </li>
                <li><a href="updateMessage.jsp" class="am-cf"> 修改信息</a></li>

                <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-adjust"></span> 交易记录 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2"  >
                        <li><a href="rendOwnerTransactionRecord.jsp" class="am-cf"> 招租记录</a></li>
                        <li><a href="rendTransactionRecord.jsp"> 租赁记录</a></li>
                        <li><a href="sellTransactionRecord.jsp" class="am-cf"> 购买记录</a></li>
                    </ul>
                </li>
                <li><a href="bill.jsp" class="am-cf"> <span class="am-icon-adn"></span> 计费功能</a></li>
                <li><a href="inform.jsp"><span class="am-icon-amazon"></span> 消息提醒</a></li>
                <li><a href="tousu.jsp" class="am-cf"> <span class="am-icon-archive"></span> 投诉</a></li>
                <li><a href=""><span class="am-icon-home"></span> 注销</a></li>
            </ul>
        </div>
    </div>
    <!-- sidebar end -->

    <!--</div>
</div>
</div>-->
    <!-- ========== Left Sidebar end ========== -->



    <!--	<div class="am-g">-->
    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content">

            <!-- row start -->
            <div class="am-g">
                <!-- col start -->
              <div class="bs-example" data-example-id="hoverable-table">
                    <div class="card-box"style="padding-right: 200px">
                        <h4 class="header-title m-t-0 m-b-30">出售交易记录详情</h4>
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="doc-ipt-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">出售者：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-3" value="zhangsan" disabled>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-2" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">购买者：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-2" value="llisi" disabled>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">联系电话：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-3" value="139821987248" disabled>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">身份证号：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-4" value="510131199610073425" disabled>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">用户职业：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-5" value="程序员" disabled>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">车位地址：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-6" value="成都市二郎山街道66号" disabled>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">车位编号：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-7" value="E-854"  disabled>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">车位出售价格：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-8" value="120000.00"  disabled>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">交易时间：</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="doc-ipt-pwd-9" value="2015-12-15" disabled >
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-10 am-u-sm-offset-3" style="padding-left: 50px">
                                    <a href="sellTransactionRecord.jsp">  <button type="button" class="btn btn-info" style="width: 200px">确定</button>
                                    </a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" style="width: 200px">投诉</button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="myModalLabel">请输入投诉内容：</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <textarea name="" id="" cols="10" rows="5"></textarea>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">提交</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </form>

                    </div>
                </div>
                <!-- col end -->
            </div>
            <!-- row end -->

        </div>
    </div>
    <!-- end right Content here -->
    <!--</div>-->

</div>

</div>



<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src="../assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="../assets/js/app.js" ></script>
<script type="text/javascript" src="../assets/js/blockUI.js" ></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>

</body>

</html>
