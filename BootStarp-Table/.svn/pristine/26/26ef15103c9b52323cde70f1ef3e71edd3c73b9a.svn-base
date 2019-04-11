<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>前台模板</title>
<link rel="stylesheet" href="../assets/css/bootstrap.css"/>
  <link rel="stylesheet" href="../assets/css/amazeui.css" />
  <link rel="stylesheet" href="../assets/css/core.css" />
  <link rel="stylesheet" href="../assets/css/menu.css" />
  <link rel="stylesheet" href="../assets/css/index.css" />
  <link rel="stylesheet" href="../assets/css/admin.css" />
  <link rel="stylesheet" href="../assets/css/page/typography.css" />
  <link rel="stylesheet" href="../assets/css/page/form.css" />
  <link rel="stylesheet" href="../assets/css/component.css" />
</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
  <div class="am-topbar-left am-hide-sm-only">
    <a href="index.jsp" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
  </div>

  <div class="contain">
    <ul class="am-nav am-navbar-nav am-navbar-left">

      <li><h4 class="page-title">车位租赁</h4></li>
    </ul>

    <ul class="am-nav am-navbar-nav am-navbar-right">
      <li class="inform"></li>
      <li class="hidden-xs am-hide-sm-only">
        <input type="text" class="form-control" id="brithda" name="brithday" readonly="readonly" value="" placeholder="请选择日期" onClick="WdatePicker()" style="height: 30px;width: 150px;display: inline-block">&nbsp;<input type="text" class="form-control" id="brithday" name="brithday" readonly="readonly" value="" placeholder="请选择日期" onClick="WdatePicker()" style="height: 30px;width: 150px;display: inline-block">
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
              <i class="fa fa-cog" aria-hidden="true"></i>
            </a>
          </li>

          <li>
            <a href="#" class="text-custom">
              <i class="fa fa-cog" aria-hidden="true"></i>
            </a>
          </li>
        </ul>
      </div>
      <!-- End User -->

      <ul class="am-list admin-sidebar-list">
        <li><a href="index.jsp"><span class="am-icon-home"></span> 个人主页</a></li>
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
    <select id="showSize" style="width: 50px; height: 20px; text-align:center; display:inline-block">
      <option>5</option>
      <option selected="selected">10</option>
      <option>20</option>
    </select> <br/> <br/>
    <div class="content">

      <div class="card-box">

        <div class="am-g">
          <!--=====================表格和按钮格式==============-->
          <div class="bs-example" data-example-id="hoverable-table">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <table class="table table-hover">
                  <thead>
                  <tr>
                    <th class="table-title">用户名</th><th class="table-author am-hide-sm-only">待租车位信息</th><th class="table-author am-hide-sm-only">租借开始时间</th><th class="table-date am-hide-sm-only">租借结束时间</th><th class="table-date am-hide-sm-only">职业</th><th class="table-date am-hide-sm-only">电话</th><th class="table-date am-hide-sm-only">信誉度</th><th class="table-date am-hide-sm-only">留言</th><th class="table-title">出租价格</th><th class="table-set">操作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>

                    <td>我是租赁车位的</td>
                    <td>成都市天府一街12号中海兰亭小区E023车位</td>
                    <td>2014年11月25日18时4分</td>
                    <td>2015年11月25日18时4分</td>
                    <td>自由职业者</td>
                    <td>1354133099</td>
                    <td>100%</td>
                    <td>价格从工厂鬼畜眼镜</td>
                    <td>280元/月</td>
                    <td><a href="" class="btn btn-info" role="button">确认成交</a></td>

                  </tr>


                  </tbody>
                </table>
              </tr>
              </thead>
            </table>
          </div>
        </div>
      </div>
      <!--======================分页格式===================================-->

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
<script type="text/javascript" src="../assets/js/charts/echarts.min.js" ></script>
<script type="text/javascript" src="../assets/js/charts/indexChart.js" ></script>
<script language="javascript" type="text/javascript" src="../assets/My97DatePicker/WdatePicker.js"></script>
</body>

</html>