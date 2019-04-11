<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>企业信息管理系统 -
	<sitemesh:write property='title' /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
<sitemesh:write property='head' />
</head>


<body>
	<div align="center">
		<table height="108" background="images/banner.jpg" border="0"
			cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td></td>
			</tr>
		</table>
		<table width="100%">
			<tr>
				<td width="160" bgcolor="#EEEEEE" valign="top">
					<table width="100%" bgcolor="#EEEEEE">
						<tr>
							<td>
								<ul class="ulnotab">
									<li>
										<a href="#">首页面</a>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<ul class="ulnotab">
									<li>
										<a href="#">通讯工具</a>
									</li>
								</ul>
								<ul>
									<li>
										<a href="#">通讯录管理</a>
									</li>
									<li>
										<a href="#">短消息管理</a>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<ul class="ulnotab">
									<li>
										<a href="#">个人管理</a>
									</li>
								</ul>
								<ul>
									<li>
										<a href="#">日程安排</a>
									</li>
									<li>
										<a href="#">工作记录</a>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<ul class="ulnotab">
									<li>
										<a href="#">企业管理</a>
									</li>
								</ul>
								<ul>
									<li>
										<a href="#">公司公告</a>
									</li>
									<li>
										<a href="#">工作会议</a>
									</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<ul class="ulnotab">
									<li>
										<a href="#">退出</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</td>
				<td align="left" valign="top">
					<sitemesh:write property='body' />
				</td>
			</tr>
		</table>
		<hr>
		<font face="仿宋">
			Copyright
			<span class="fontArial">&copy;</span>
			朗沃培训  版权所有
		</font>
	</div>
</body>
</html>

