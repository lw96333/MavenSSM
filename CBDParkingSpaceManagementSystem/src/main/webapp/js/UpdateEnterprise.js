
   $(function(){
	
	   $("#submit").click(function(){
		   
		   $.ajax({
			   
		   
			   type:"post",
			   url:"updateEnterpriseUser",
			   data:{
				   "name":$("#name").val().trim(),
				   "phone":$("#phone").val().trim(),
				   "password":$("#enterpriepwd").val().trim(),
				   "contactperson":$("#contactperson").val().trim()
			   },
		       dataType:"json",
		       success:function(data){
		    	 
		    	  console.log(data);
		    	 
		    	  if(data.code==200){
		    		   layer.msg('修改成功',{icon:1,time:1500});
						setTimeout(function () { 
							parent.location.href="jsp/FortendLogin.jsp";
							}, 1500);
		    	   }else if(data.code==401){
		    		  
		    		   layer.msg('请根据提示正确并完整输入您的信息',{icon:1,time:1000});
		    		  
		    	   }
		    	   
		       }
		   })
	   })
   })



