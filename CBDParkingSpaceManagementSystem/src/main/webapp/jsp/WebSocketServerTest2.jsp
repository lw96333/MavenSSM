<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    　　
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href=<%=basePath %>/>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.7.2.min.js"></script>
</head>
<body>
<div>	发送人:<div id="userno">4567</div>
   		 接收人：<input type="text" id="usernoto"><br>
		<input type="text" id="info"/><button id="btnSend">发送消息</button>
		<button id="btnClose">关闭</button>
		<div id="message"></div>
</div>
</body>
<script>
$(function(){
	//alert("ok")
	var userno=document.getElementById('userno').innerHTML;
	var socket;
	if(typeof(WebSocket) == "undefined") {
	    console.log("您的浏览器不支持WebSocket");
	}else{
	    console.log("您的浏览器支持WebSocket");

	//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
	   socket = new WebSocket("ws://localhost:9998/spring/websocket/"+userno);
	    //打开事件
	    socket.onopen = function() {
	        console.log("Socket 已打开");
	        //socket.send("ok"); 
	    };
	    //获得消息事件
	    socket.onmessage = function(msg) {
	    	setMessageInnerHTML(msg.data);
	        console.log("收到服务器响应的信息："+msg.data);
	        //发现消息进入    调后台获取
	        //getCallingList();
	    };
	    //关闭事件
	    socket.onclose = function() {
	        console.log("Socket已关闭");
	    };
	    //发生了错误事件
	    socket.onerror = function() {
	        alert("Socket发生了错误");
	    }

	    //关闭连接
	    function closeWebSocket() {
	        socket.close();
	    }

	  //发送消息
	    function send() {
	    	var message = $("#info").val();//要发送的消息内容
	    	var now=getNowFormatDate();//获取当前时间
	    	document.getElementById('message').innerHTML += (now+"发送人："+userno+'<br/>'+"---"+message) + '<br/>';
	    	document.getElementById('message').style.color="red";
	    	var ToSendUserno=document.getElementById('usernoto').value; //接收人编号：4567
	    	message=message+"|"+ToSendUserno//将要发送的信息和内容拼起来，以便于服务端知道消息要发给谁 
	        socket.send(message); 
	    } 
	    
	    $("#btnSend").click(function() {
	    	send();
		}); 
	    
	    $("#btnClose").click(function() {
	    	 socket.close();
		}); 
	    function setMessageInnerHTML(sendMessage) {
	    	
	        $("#message").append(sendMessage + '<br/>');
	    }
	  //获取当前时间
	        function getNowFormatDate() {
	            var date = new Date();
	            var seperator1 = "-";
	            var seperator2 = ":";
	            var month = date.getMonth() + 1;
	            var strDate = date.getDate();
	            if (month >= 1 && month <= 9) {
	                month = "0" + month;
	            }
	            if (strDate >= 0 && strDate <= 9) {
	                strDate = "0" + strDate;
	            }
	            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	                    + " " + date.getHours() + seperator2 + date.getMinutes()
	                    + seperator2 + date.getSeconds();
	            return currentdate;
	    } 
	    
	}	
});

</script>
</html>