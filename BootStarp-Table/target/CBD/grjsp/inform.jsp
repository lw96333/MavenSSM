<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

      <li><h4 class="page-title">基本表格</h4></li>
    </ul>

    <ul class="am-nav am-navbar-nav am-navbar-right">
      <li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
      <li class="hidden-xs am-hide-sm-only">
        <form role="search" class="app-search">
          <input type="text" placeholder="Search..." class="form-control">
          <a href=""><img src="../assets/img/search.png"></a>
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
            <li><a href="table_basic.jsp" class="am-cf"> 我的车位</span></a></li>
            <li><a href="table_complete.jsp">车位租赁</a></li>
            <li><a href="table_complete.jsp">车位购买</a></li>
          </ul>
        </li>
        <li><a href="table_basic.jsp" class="am-cf"> 修改信息</span></a></li>
        <li><a href="table_complete.jsp">交易记录</a></li>
        <li><a href="table_basic.jsp" class="am-cf"> 计费功能</span></a></li>
        <li><a href="inform.jsp">消息提醒</a></li>
        <li><a href="tousu.jsp" class="am-cf"> 投诉</span></a></li>
        <li><a href="login.jsp">注销</a></li>

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
    </select> &nbsp;&nbsp;&nbsp;
    <br/> <br/>
    <div class="content">
      <div class="card-box">
        <div class="am-g">


          <!--=====================表格和按钮格式==============-->
          <div class="bs-example" data-example-id="hoverable-table">
            <table class="table table-hover">
              <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-title">内容</th><th class="table-type">类别</th><th class="table-date am-hide-sm-only">修改日期</th><th class="table-set">状态</th><th class="table-set">操作</th>              </tr>
              </thead>
              <tbody>
              <tr>
                <td>1</td>
                <td style="max-width: 50px;overflow: hidden; text-overflow:ellipsis;white-space: nowrap"  ><a href="#" data-toggle="modal" data-target="#myModal"  >Business management11111111111111111111111111111</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>2</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: red">未读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              </tr>
              <tr>
                <td>3</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>4</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: red">未读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>5</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>6</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>7</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>8</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: red">未读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td>9</td>
                <td><a href="#" data-toggle="modal" data-target="#myModal" >Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td class="am-hide-sm-only" style="color: lawngreen">已读</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">
                      <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#myModal" >查看</button>
                      <!--<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 复制</button>-->
                      <!--<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only " ><span class="am-icon-trash-o"></span> 删除</button>-->
                    </div>
                  </div>
                </td>
              </tr>
              </tr>
              </tbody>
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
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">消息详细信息</h4>
        </div>
        <div  style="width: 600px;  height: 450px;">

          <h1 style="margin: 20px 220px;">消息标题</h1>
          <div style="width: 500px;height: 500px;position: absolute;">
            <label style="position: relative;left: 40px;" >接收用户：张三</label>
            <label style="position: relative;left: 255px;" >消息类型：个人</label><br/><br/>
            <label style="position: relative;left: 40px" >消息内容：</label>
            <div class="modal-body">
              <label style="position: relative;left: 100px;width: 80%;height: 200px;">One fine body&hellip;</label>
            </div>
            <label style="position: relative;left: 40px;"  >接收时间：2019.1.22  12:15:33</label>
            <label style="position: relative;left: 155px;"  >是否已读：已读</label>

          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal" >确定</button>
        </div>
      </div>
    </div>
  </div>


</div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" data-dismiss="modal" >确定</button>
        </div>
      </div>
    </div>



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
<script type="text/javascript" src="../assets/js/bootstrap.min.js" ></script>
</body>

</html>
