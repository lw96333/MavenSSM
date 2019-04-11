<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>

	<form action="user/fileupload" method="post" enctype="multipart/form-data">
		文件标题：<input type="text" name="title"/><br/>
		第一个文件<input type="file" name="upload"><br/>
		第二个文件<input type="file" name="upload2"><br/>
		第三个文件<input type="file" name="upload3"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>