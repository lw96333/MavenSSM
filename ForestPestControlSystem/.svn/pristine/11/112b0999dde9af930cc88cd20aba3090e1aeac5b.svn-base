            $(function(){
			$("#button").click(function(){
			var	name = $("#name").val().trim();
			var	tree = $("#tree").val().trim();
				if(name == "" || tree == ""){
					alert("请输入完整的添加信息");
				}else{
					 $.ajax({
			                type: "POST",//方法
			                url: "../additive" ,//表单接收url
			                data: $('#form').serialize(),
			                success: function () {
			                  //提交成功的提示词或者其他反馈代码
			                   /* alert("fsd"); */
			                    $(location).prop("href","../pharmacy_management");
			                },
			                error : function() {
			                  //提交失败的提示词或者其他反馈代码
			                    var result=document.getElementById("success");
			                    result.innerHTML="失败!";
			                }
			            });
				} 
			});
		});