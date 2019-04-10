var ary = new Array();
		$(function() {
			/* 得到访问的url地址：http://localhost:9998/spring//jsp/backstage/spuer/UpdataAdmin.jsp?id=7 */
			var href = $(location).attr("href");
			/* 切割url地址得到id */
			var id = href.split("=")[1];
			$.ajax({
				type:"post",
				url:"selectOneAdmin",
				data:{
					"adminId":id
				},
				dataType:"json",
				success:function(data){
					console.log(data);
					var admin = data.data.admin;
					$("#name").val(admin.name);
					$("#number").val(admin.phone);
					$("#jobID").val(admin.jobnumber);
					var powers = data.data.power;
					console.log(powers);
					for(var index = 0;index < powers.length; index++){
							
								
						    $("input:checkbox").each(function(i){
						     	if ($(this).val() ==powers[index].jurisdictionid) { 
									
							        $(this).prop("checked",true)
							        ary.push(powers[index].jurisdictionid);
							    } 
						    });
					}
				}
			});
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-member-add").validate({
				rules : {
					jobID : {

						required : true,
						minlength : 1,
						maxlength : 16
					},
					password : {
						required : true
					},
					name : {
						required : true
						
					},
					number : {
						required : true

					}
				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function() {
					var ary2 = new Array();
					$("input:checkbox").each(function(i){
				     	
						if($(this).prop("checked")){
							ary2.push($(this).val());
						}	

				    });
					if(ary2.length == 0){
						layer.msg('请选择权限！',{icon:1,time:1000});
						return;
					}
					
					var delAry = new Array();
					var addAry = new Array();
					for(var index = 0; index < ary.length;index++){
						var falg = true;
						for(var index2 = 0;index2 < ary2.length;index2++){
							if(ary[index] == ary2[index2]){
								falg = false;
							}
						}
						if(falg){
							delAry.push(ary[index]);
						}
					}
					
					
					for(var index = 0; index < ary2.length; index++){
						var falg = true;
						for(var index2 = 0;index2 < ary.length;index2++){
							if(ary[index2] == ary2[index]){
								falg = false;
							}
						}
						if(falg){
							addAry.push(ary2[index]);
						}
					}
					var num = 0;
					var delPower;
					var addPower;
					if(addAry.length==0){
						num++;
						addPower = "";
					}else{
						addPower = addAry.join(",");
					}
					if(delAry.length==0){
						num++;
						delPower = "";
					}else{
						delPower = delAry.join(",");
					}
					if(num == 2){
	
						layer.msg('权限未改变！',{icon:1,time:1000});
						return;
					}
					
					$.ajax({
						type:"post",
						url:"super/updateAdmin",
						data:{
							"adminId":id,
							"delPower":delPower,
							"addPower":addPower
						},
						dataType:"json",
						success:function(data){

							layer.msg('修改成功！',{icon:1,time:1000});
							window.parent.location.reload(); 
						}
					});
					
					
				}
			});
		});