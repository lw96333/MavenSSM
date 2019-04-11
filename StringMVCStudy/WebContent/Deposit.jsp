<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>存款</title>
</head>
<body>

	<form action="deposit" method="post">
		账号：<input type="text" name="account" value="${ dispositBean.account}"/><span>${account }</span><br/>
		用户名：<input type="text" name="name" value="${ dispositBean.name}"/><span>${name }</span><br/>
		密码：<input type="password" name="password" value="${ dispositBean.password}"/><span>${password }</span><br/>
		身份证：<input type="text" name="id" value="${ dispositBean.id}"/><span>${id }</span><br/>
		存款金额：<input type="text" name="amount" value="${ dispositBean.amount}"/><span>${amount }</span><br/>
		年限：<input type="text" name="duration" value="${ dispositBean.duration}"/><span>${duration }</span><br/>
		电话号码：<input type="text" name="phone" value="${ dispositBean.phone}"/><span>${phone }</span><br/>
		
		<input type="submit" value="存款"/>
	</form>
</body>

</html>