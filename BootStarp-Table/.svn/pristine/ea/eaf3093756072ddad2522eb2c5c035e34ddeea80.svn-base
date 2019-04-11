<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
	</head>
	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a href="index.jsp" class="logo"><span>Login<span>to</span></span></a>
	            </div>

	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">Sign In</h4>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="email" class="am-radius"  placeholder="Username" id="username">
							    </div>

							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius"  placeholder="Password" id="password">
							    </div>

                                <div class="am-form-group form-horizontal m-t-20">
                                    <select id="userType">
                                        <option value="个人">个人用户</option>
                                        <option value="企业">企业用户</option>
                                        <option value="后台">后台管理</option>
                                        <option value="系统">系统管理</option>
                                    </select>

                                </div>

							    <div class="am-form-group ">
                                    <div id="v_container" style="width: 100px;height: 40px;"></div>
                                    <input type="text" id="code_input" value="" placeholder="请输入验证码" id="res"/>
		                        </div>

								<div class="am-form-group ">
									<label style="font-weight: normal;color: #999;">
										<input type="checkbox" class="remeber" id="rememberMe"> Remember me
									</label>
								</div>

								<span id="verification" style="color: #ff4f4a;font-size: 14px"></span>
		                        <div class="am-form-group ">
		                        	<button type="button" class="am-btn am-btn-primary am-radius" id="my_button" style="width: 100%;height: 100%;">Log In</button>
		                        </div>

	                		</div>

	                	</form>

	                </div>
	            </div>
			</div>
		</div>
        <script type="text/javascript" src="assets/js/jquery-2.1.0.js"></script>
        <script type="text/javascript" src="assets/js/verification.js"></script>
        <script>
            $(function () {
                var verifyCode = new GVerify("v_container");
                document.getElementById("my_button").onclick = function () {



                    var res = verifyCode.validate(document.getElementById("code_input").value);
                    if (res) {
						$("#verification").html('');
                        $.ajax({
                            url: "login",
                            type: "post",
                            data: {
                                username: $("#username").val().trim(),
                                password: $("#password").val().trim(),
                                userType: $("#userType").val().trim(),
								rememberMe:$("#rememberMe").val()
                            },
                            dataType: "text",
                            success: function (data) {
                               if (data=="个人"){
								   location.href="grjsp/index.jsp";
							   }else if(data=="企业"){
								   location.href="company-jsp/companyindex.jsp";
							   }else if(data=="后台"){
								   location.href="adminJsp/personalManage.jsp";
							   }else if(data=="系统"){
								   location.href="superAdminJsp/superAdmin.jsp";
							   }else {
								   $("#verification").html(data);
							   }

                            }

                        });
                    } else {
                        $("#verification").html("验证码错误！")
                    }
                }
            })
        </script>
	</body>
</html>
