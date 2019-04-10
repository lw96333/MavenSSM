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
    		var price = $("#price").val();
    		var privatecarsid = C2;
    		if(price == "" || price.indexOf(" ") != -1){
    			$("input[name=price]").css("border","1px red solid");
    			$("input[name=price]").attr("placeholder","数据不能为空!或者带有空格");
    		}else if(/^[1-9]\d+$/.test(price)){
    			
    			if(price.length > 6){
    				$("input[name=price]").css("border","1px red solid");
        			$("input[name=price]").attr("placeholder","出售价格必须小于100万");
    			}else{
		    		$.ajax({
		    			type : "post",
		    			url : "insertSellTime",
		    			data : {
		    				"price" : price,
		    				"privatecarsid" : privatecarsid
		    			},
		    			dataType : "json",
		    			success : function (data){
		    				layer.msg('添加成功!',{icon:1,time:1000});
		    				window.parent.location.href="jsp/fortend/personal/parBuyShow.jsp";
		    		    }
		    		});
    			}
    		}else{
    			$("input[name=price]").css("border","1px red solid");
    			$("input[name=price]").attr("placeholder","金额只能输入正整数");
    		}
    	});
    });