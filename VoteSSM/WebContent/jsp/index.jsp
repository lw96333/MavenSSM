<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/indexCSS.css"/>
    <link rel="stylesheet" href="../css/reset.css"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body>
    <div>
           <div class="left">
               <div class="col-md-10 col-md-offset-1 topPanels">
                   <div class="panel panel-primary">
                       <div class="panel-heading">
                           <h3 class="panel-title">时间信息</h3>
                       </div>
                       <div class="panel-body">
                           <p>现在的时间是：</p>
                           <div  id="current_time"></div>
                       </div>
                   </div>
               </div>

               <div class="col-md-10 col-md-offset-1">
                   <div class="panel panel-primary">
                       <div class="panel-heading">
                           <h3 class="panel-title">欢迎信息</h3>
                       </div>
                       <div class="panel-body">
                           <p>欢迎你：${admin.name}<a href="javascript:void(0)" id="end">注销</a></p>
                           <p>您上次登录的时间是：</p>
                           <p>${admin.logintime}</p>
                       </div>
                   </div>
               </div>

               <div class="col-md-10 col-md-offset-1">
                   <div class="panel panel-primary">
                       <div class="panel-heading">
                           <h3 class="panel-title">统计信息</h3>
                       </div>
                       <div class="panel-body">
                           <p id="total"></p>
                           <p>其中：</p>
                           <p id="siginle"></p>
                           <p id="check"></p>
                       </div>
                   </div>
               </div>
           </div>
            <div class="rightTop" >
                    <img src="../image/toupiao.jpg" width="100%">
                    <div class="row rightTopNume" style="margin-top: 50px">
                        <div class="btn-group col-md-offset-1 col-md-1">
                            <button class="btn btn-primary btn-lg voteIndex">投票主页</button>
                        </div>
                        <div class="btn-group col-md-offset-1 col-md-1">
                            <button class="btn btn-primary btn-lg manage">管理投票</button>
                        </div>
                        <div class="btn-group col-md-offset-1 col-md-1">
                            <button class="btn btn-primary btn-lg new">创建投票</button>
                        </div>
                        <div class="btn-group col-md-offset-1 col-md-1">
                            <button class="btn btn-primary btn-lg select">查找投票</button>
                        </div>
                        <div class="btn-group col-md-offset-1 col-md-1 account">
                            <button class="btn btn-primary btn-lg">管理员管理</button>
                        </div>
                    </div>
            </div>
            <div class="rightMiddle">
                <iframe id="conent" width="100%" height="100%" src="voteIndex.jsp"></iframe>
            </div>
    </div>
</body>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/index.js"></script>
</html>