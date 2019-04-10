$(function(){
    	$.ajax({
    		type:"post",
    		url:"getAllEnterpriseNameAndID",
    		success:function(data){
    			if(data.message=="ok"){
    				var datas = data.data.name;
    				var str = "";
    				$.each(datas,function(i,data){
    					str+="<option onclick='selectClick()' value="+data.enterpriseid+">"+data.enterpriename+"</option>"
    				})
    				$("#sid").append(str);
    			}
    			var t=new Date();
            	var y=t.getFullYear();
            	var m=t.getMonth()+1;
            	if(m<10){
            	m="0"+m;
            	}
            	var d=t.getDate();
            	var No="KF-"+y+m+d+t.getHours()+t.getMinutes()+t.getMilliseconds();
    			$("#contractNO").val(No);
    			
    		}
    	});
    	$("#stallprice").blur(function(){

			if($(this).val() == ""){
				$("#stallprice").css("border","1px red solid");
				$("#stallprice").attr("placeholder","成交价格不能为空！");
			}else{
				$("#stallprice").css("border","1px #DCDCDC solid");
				$("#stallprice").attr("placeholder","成交价格");
			}
		});

    	$("#btn").click(function(){
    		var aaid = $("#sid").val();
    		var starTime = $("#datemin").val();
    		var endTime = $("#datemax").val();
    		var price = $("#stallprice").val();
    		var contractNO=$("#contractNO").val();
    		var infoid=$("#infoid").text();
    		var flag = true;
    		if(price==""){
    			$("#stallprice").blur();
    			flag=false;
    		}; 
    		if(!/^[1-9]\d+$/.test(price)){
    			layer.msg('价格输入格式错误',{icon:1,time:1500});
    			flag=false;
    		};
    		if(infoid==""){
    			layer.msg('请选择车位!',{icon:1,time:1000});
    			flag=false;
    		}
    		if(contractNO==""){
    			layer.msg('合同编号未获取，请刷新页面',{icon:1,time:1000});
    			flag=false;
    		}
    		if(endTime==""){
    			layer.msg('请选择合同失效日期!',{icon:1,time:1000});
    			flag=false;
    		};
    		if(starTime==""){
    			layer.msg('请选择合同生效日期!',{icon:1,time:1000});
    			flag=false;
    		};
    		if(aaid=="-1"){
    			layer.msg('请选择企业!',{icon:1,time:1000});
    			flag=false;
    		};
    		if(starTime>endTime){
    			layer.msg('合同生效日期不能小于合同失效日期!',{icon:1,time:1000});
    			flag=false;
    		};
    		if(flag){
    			$.ajax({
    				url:"insertContract",
    				type:"post",
    				data:{
    					"enterpriseid":aaid,
    					"fromdate":$("#datemin").val(),
    					"deadline":$("#datemax").val(),
    					"price":$("#stallprice").val(),
    					"contractnumber":$("#contractNO").val(),
    					"areanumber":$("#infoid").html()
    				},
    				success:function(data){
    					if(data.message=="ok"){
    						window.location.href="jsp/backstage/admin/lease/contract-list.jsp";
    					}else{
    						layer.msg('添加失败!',{icon:1,time:1000});
    						setTimeout(function () { 
    							window.location.reload();
    							}, 1500); 
    						
    					}
    				}
    		});
    		}
    		
    	});
    });
	
	
	function member_edit(title,url,id,w,h){   
            layer_show(title,url,w,h);
        }; 
