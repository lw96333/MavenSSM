$(function(){

	 $("#submit").click(function(){
		      $.ajax({
				url:"insertEnterpriseUser",
			    type:"post",
			    dataType:"json",
				data:{
					  "name":$("#name").val().trim(),
					  "password":$("#enterpriepwd").val().trim(),
					  "enterpriename":$("#enterpriename").val().trim(),
					  "contactperson":$("#contactperson").val().trim(),
					  "floor":$("#floor").val().trim(),
					  "phone":$("#phone").val().trim()
					 },
	
			    success:function(Data){
			   
			    	console.log(Data.code);
			    	if(Data.code==400){
			    		layer.msg('请根据提示完整并正确填写! ', {
							icon : 1,
							time : 2000
						});
		
			    	}
			    	if(Data.code==438){
			    		layer.msg('该企业登录名已存在,请换一个登录名试试!! ', {
							icon : 1,
							time : 2000
						});
			    		
			    	}
			    	if(Data.code==200){
			    		layer.msg('添加成功! ', {
							icon : 1,
							time : 1000
						});
			    		setInterval(function() {
			    			window.location.href="jsp/backstage/admin/lease/enterpriseShow.jsp";
					    }, 1000);

			    		
			    	}
			    },
			});
			
		});
});