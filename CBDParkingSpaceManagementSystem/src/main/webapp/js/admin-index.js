    $(function(){
    	$("#out").click(function(){

    		 $.ajax({
    	        	type:"post",
    	        	url:"loginOut",
    	        	dataType:"json",
    	        	success:function(data){
    	        		$(location).attr("href","jsp/SelectLogin.jsp");
    	        		
    	        	}
    	        });
    	});
        $.ajax({
        	type:"post",
        	url:"login",
        	dataType:"json",
        	success:function(data){
        		console.log(data);
        		$("#admin").html(data.data.admin.jobnumber);
        	}
        });
    });
    /*个人信息*/
    function myselfinfo(){
        layer.open({
            type: 1,
            area: ['300px','200px'],
            fix: false, //不固定
            maxmin: true,
            shade:0.4,
            title: '查看信息',
            content: '<div>1111</div>'
        });
    }

    /*资讯-添加*/
    function article_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-添加*/
    function picture_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*产品-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
