<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>登录</title>

		<link rel="stylesheet" href="../assets/css/core.css" />
		<link rel="stylesheet" href="../assets/css/menu.css" />
		<link rel="stylesheet" href="../assets/css/amazeui.css" />
		<link rel="stylesheet" href="../assets/css/component.css" />
		<link rel="stylesheet" href="../assets/css/page/form.css" />

	</head>
	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	             <!--   <a href="index.jsp" class="logo"><span>Admin<span>to</span></span></a>-->
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">登录</h4>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="email" class="am-radius"  placeholder="用户名">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius"  placeholder="密码">
							    </div>

								<div>
									<input type="text" id="code_input" class="am-radius"  placeholder="验证码">
								</div>
								<div id="v_container"style="width: 320px;height: 50px;" class="am-form-group form-horizontal m-t-20">

							    </div>
							    <div class="am-form-group ">
		                           	<label style="font-weight: normal;color: #999;">
								        <input type="checkbox" class="remeber"> 自动登录
								    </label>
		                        </div>
		                        
		                        <div class="am-form-group ">
		                        	<button id="my_button" type="button" class="am-btn am-btn-primary am-radius" style="width: 45%;height: 100%;">登录</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="register.jsp"><button id="register" type="button" class="am-btn am-btn-primary am-radius" style="width: 45%;height: 100%;">注册</button>
									</a>
								</div>
		                        
		                        <div class="am-form-group ">
		                        <a href="#" class="text-muted"><i class="fa fa-lock m-r-5"></i> Forgot your password?</a>
		                        </div>
	                		</div>

	                	</form>
							
	                </div>
	            </div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/gVerify.js"></script>
	<script>
		var verifyCode = new GVerify("v_container");

		document.getElementById("my_button").onclick = function(){
			var res = verifyCode.validate(document.getElementById("code_input").value);
			if(res){
				alert("验证正确");
			}else{
				alert("验证码错误");
			}
		}
	</script>
</html>
