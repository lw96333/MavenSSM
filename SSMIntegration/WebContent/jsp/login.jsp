<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//获取绝对路径
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+
    		request.getServerName()+":"+request.getServerPort()+
    		path+"/";
    	out.print(basePath);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href=<%=basePath %>/>
<title>登录</title>
</head>
<body>

	<form action="../login" method="post">
		用户名：<input type="text" name="name"/><br/>
		密码：<input type="password" name="password"/><br/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>