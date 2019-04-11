<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/LoginCSS.css"/>
</head>
<body>
    <div class="top"></div>
    <div class="middle">
        <div class="middleFrom">
                <div class="FromTopTop"></div>
                <div class="FromTop">
                    管理员登录
                </div>
                <div style="text-align: center">
                    <form style="margin-top: 30px">
                        <fieldset>
                            <label>输入用户名：</label>
                            <input type="text" placeholder="输入用户名…" name="name"><br/><br/>
                            <label>输入密码：</label>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="password" placeholder="输入密码…" name="password"><br/><br/>
                             <label>输入验证码：</label>
                            <input type="text" placeholder="输入验证码…"><br/><br/>
                            <br/><br/><br/>
                            <button type="button" id="btn">登录</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" id="clear">重置</button>
                        </fieldset>
                    </form>
                </div>
                <div class="Formfooter"></div>

        </div>
    </div>
    <div class="footer"></div>
</body>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
</html>