<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户名：<input type="text" name="username" /><br /><br />
		密码：&nbsp;<input type="password" name="password" /><br /><br />
		<input type="button" name="btn" value="注册" />
</body>
<script src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[name=btn]").click(function(){
			var name = $("input[name=username]").val();
			var password = $("input[name=password]").val();
			$.ajax({
				type:"post",
				url:"../register",
				data:{
					"name":name,
					"password":password
				},
				dataType:"json",
				success:a
			});
		});
	});
	function a(data){
		alert(data.code);
		alert(data.message);
		$(location).attr("href","restOk.jsp");
	}
</script>
</html>