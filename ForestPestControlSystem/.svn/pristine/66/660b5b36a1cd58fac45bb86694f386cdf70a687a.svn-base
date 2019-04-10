<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--主页 -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>主页</title>
    <link rel="stylesheet" href="../css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="../css/style.css"  type="text/css" media="screen" />
    <link href="../css/loginStyle.css" rel="stylesheet" type="text/css" media="all" />

</head>

<body>
<div id="top">
    <div id="head">
        <h3 class="login_logo"><span>森</span>林病虫害防治系统</h3>
    </div>
    <!--end head-->

    <div style="height: 580px;">

        <div class="message warning">
                <div class="inset">
                    <div class="login-head">
                        <h1>登录</h1>
                    </div>
                    <form action="../login" method="post" class="formLogin">
                        <li>
                            <input type="text" class="text" placeholder="请输入账号" name="username"><a href="#" class=" icon user"></a>
                        </li>
                        <div class="clear"> </div>
                        <li>
                            <input type="password" placeholder="请输入密码" name="password"> <a href="#" class="icon lock"></a>
                        </li>
                        <div class="clear"> </div>
                        <div class="submit">
                            <input type="submit" value="登录" name="login">
                            <div class="clear">  </div>
                        </div>
                        	<br/>
                        	<br/>
						<c:if test="${isLogin=='f' }">
	                    	<span style="color:red">账号或密码错误</span>
	                    </c:if>
                    </form>
                    
                </div>
            </div>



    </div><!--end bg_wrapper-->

    <div  id="footer" style="color: #fff;text-align: center">
        Copyright 2018 - 2019 One. All Rights Reserved
    </div><!--end footer-->

</div><!-- end top -->
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/jquery-ui.js"></script>
<script type='text/javascript' src='../js/custom.js'></script>
<script type='text/javascript' src='../js/login.js'></script>
</body>

</html>