<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>springMVC ajax</title>
</head>
<body>

	<div>
		<p>评论</p>
		<p>姓名：<input type="text" name="name" id="name"></p>
		<p>内容：<textarea rows="2" cols="20" name="contenc" id="content"></textarea></p>
		<p><input type="button" id="send" value="提交"></p>
	</div>
	<div class="comment">已有评论：</div>
	<div id="result"></div>
	
</body>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
	$(function(){
		$("#send").on("click",function(){
			$.getJSON(
				"ajax",
				{
					name:$("#name").val(),
					content:$("#content").val()
				},
				getAjaxCommentData
			);
		});
	});
	
	function getAjaxCommentData(data){
		//解析获取的ajax数据
		var node = $("<div><div>");
		var content = data.name + "->" + data.content;
		node.append(content);
		$("#result").append(node);
	}
</script>
</html>