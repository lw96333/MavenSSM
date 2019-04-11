<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导入springmvc标签库 -->
    <%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login"/></title>
</head>
<body>

	<form action="login" method="post">
		<spring:message code="username"/><input type="text" name="name"/><br/>
		<spring:message code="password"/><input type="password" name="password"/><br/>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>