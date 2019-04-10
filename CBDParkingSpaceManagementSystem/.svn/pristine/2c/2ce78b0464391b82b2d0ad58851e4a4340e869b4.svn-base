$(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-member-add").validate({
            rules:{
            	address:{
                    required:true,
                    minlength : 2,
					maxlength : 12
                },
                areanumber:{
                    required:true,
                    minlength : 1,
					maxlength : 5
                },
                number:{
                    required:true,
                    minlength : 1,
					maxlength : 4
                },
                fristnumbers:{
                    required:true,
                    minlength : 1,
					maxlength : 3
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                //$(form).ajaxSubmit();
                var index = parent.layer.getFrameIndex(window.name);
                //parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
    });
    //添加车位
    $(function(){
    	/* alert("ok"); */
    	$("#btn").click(function(){
    		 
    		var address = $("#address").val();
    		var areanumber = $("#areanumber").val();
    		var number = $("#number").val();
    		var fristnumbers = $("#fristnumbers").val();
    		if(address == ""){
    			layer.msg('车位区域地址输入不能为空，请重新输入',{icon:1,time:1500});
    		}else if(areanumber == ""){
    			layer.msg('区域编号输入不能为空，请重新输入',{icon:1,time:1500});
    		}else if(number == ""){
    			layer.msg('添加车位数量输入不能为空，请重新输入',{icon:1,time:1500});
    		}else if(fristnumbers == ""){
    			layer.msg('车位编号起始位输入不能为空，请重新输入',{icon:1,time:1500});
    		}else{
    		$.ajax({
    			type : "post",
    			url : "insertCbd",
    			data : {
    				"address" : address,
    				"areanumber" : areanumber,
    				"number" : number,
    				"fristnumbers" : fristnumbers
    			},
    			dataType : "json",
    			success : function (data){
    				
    				var aref = areanumber + fristnumbers;
    				var areff = data.data.areanumbers;
    				 if(aref == areff){
    					 layer.msg('车位编号已存在，请重新输入',{icon:1,time:1500});
    				 setTimeout(function () { 
    					 $(location).attr("href","jsp/backstage/admin/parkingManagement/TruckSpace-add.jsp");
							}, 1500); 
    				}else{ 
 						 layer.msg('添加成功',{icon:1,time:2000});
					setTimeout(function () { 
						$(location).attr("href","jsp/backstage/admin/parkingManagement/TruckSpace-show.jsp");
							}, 1500); 
    				} 
    		    }
    		
    		});
    		}
    	});
    });