<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>招租交易记录</title>
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
            <li class="hidden-xs am-hide-sm-only">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName2">查询信息</label>
                        <input type="text" class="form-control" id="exampleInputName2" placeholder="信息...">
                    </div>
                    <button type="submit" class="btn btn-info">查询</button>
                </form>
            </li>
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
                    <select id="showSize" style="width: 50px; height: 20px; text-align:center; display:inline-block">
                        <option>5</option>
                        <option selected="selected">10</option>
                        <option>20</option>
                    </select>
                    <div class="card-box">
                        <table class="table table-hover" >
                            <thead>
                            <tr>
                                <th>招租用户名</th>
                                <th>车位地址</th>
                                <th>车位区域</th>
                                <th>车位编号</th>
                                <th>车位状态</th>
                                <th>租借开始时间</th>
                                <th>租借结束时间</th>
                                <th>租赁用户名</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr><tr>
                                <td>Amaze UI</td>
                                <td>海澜庭小区</td>
                                <td>东边</td>
                                <td>E-548</td>
                                <td>已租</td>
                                <td>2015-12-25</td>
                                <td>2016-12-25</td>
                                <td>李四</td>
                                <td><a href="lookRendOwnerJransactionRecord.jsp"><button class="btn btn-info" type="button">查看详细信息</button></a>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                    <div style=" outline: 1px whitesmoke solid;">

                        <label f>总共</label>
                        <span id="tolNum"></span>
                        <label>条,总共</label>
                        <span id="tolSize"></span>
                        <label>页</label>

                        <span style="width: 190px;display: inline-block"> </span>
                        <a href="#" id="pre" class="btn btn-info btn-sm" role="button" style="width: 60px;height: 30px"><span aria-hidden="true">上一页</span></a>
                        &nbsp;<label>第</label>&nbsp;
                        <span id="curpage"></span>
                        &nbsp;<label>页,每页</label>&nbsp;
                        <span id="pagesize"></span>
                        &nbsp;<label>条,跳转到</label>&nbsp;
                        <input type="text" class="form-control" style="display: inline-block; width: 40px;height: 30px;" />
                        &nbsp;<label>页</label>&nbsp;

                        <a href="#;" id="next" class="btn btn-info btn-sm" role="button" style="width: 60px;height: 30px"><span aria-hidden="true">下一页</span></a>

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
