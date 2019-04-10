<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=<%=basePath %>/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" name="num">
	<input type="button" value="查询"/>
	<div id="display"></div>
</body>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[type=button]").click(function(){
			$.ajax({
				type:"post",
				url:"selectMobile",
				data:{
					"mobileNum":$("input[name=num]").val()
				},
				dataType:"json",
				success:function(data){
					console.log(data);
					var str = "<div>查询电话归属地:"+data.data.extendMobile.provice+"--"+data.data.extendMobile.city+"</div>";
					str += "<div>查询时间:"+data.data.time+"ms</div>";
					$("#display").html(str);
				}
			});
		});
	});
</script>
</html>