$(function(){
		 
    	 /*获得前一个页面传来的id*/
    	 C1=window.location.href.split("?")[1]; //得到id
         C2=C1.split("=")[1]; //得到值
         
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#btn").click(function(){
    		var starttime = $("#datemin").val();
    		var endtime = $("#datemax").val();
    		var price = $("#price").val();
    		var privatecarsid = C2;
    		if(starttime ==  ""){
    			$("input[name=datemin]").css("border","1px red solid");
				$("input[name=datemin]").attr("placeholder","开始时间不能为空！");
    		}else if(endtime == ""){
    			$("input[name=datemax]").css("border","1px red solid");
				$("input[name=datemax]").attr("placeholder","结束时间不能为空！");
    		}else if(price == ""){
    			$("input[name=price]").css("border","1px red solid");
				$("input[name=price]").attr("placeholder","金额不能为空！");
    		}else if(/^[1-9]\d+$/.test(price)){
    			if(price.length > 4){
    				$("input[name=price]").css("border","1px red solid");
    				$("input[name=price]").attr("placeholder","出租金额必须小于一万元！");
    			}else{
		    		$.ajax({
		    			type : "post",
		    			url : "insertSentTime",
		    			data : {
		    				"starttime" : starttime,
		    				"endtime" : endtime,
		    				"price" : price,
		    				"privatecarsid" : privatecarsid
		    			},
		    			dataType : "json",
		    			success : function (data){
		    				layer.msg('添加成功!',{icon:1,time:1000});
		    				window.parent.location.href="jsp/fortend/personal/ParkingSpaceRental.jsp";
		    		    }
		    		});
    			}
    		}else{
    			$("input[name=price]").css("border","1px red solid");
				$("input[name=price]").attr("placeholder","金额只能输入正整数");
    		}
    	});
    });