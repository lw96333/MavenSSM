$(function(){
	//alert("111");
	$.ajax({
        type:"post",
        url:"showEnterprisebilling",
        data:{
            "pageNum":1,
            "pageSize":5,
            //"enterpriseid":81
        },
        dataType:"json",
        success:function(data){
        	if (data.data.page.records == "") {
            	layer.msg('暂无交易数据',{icon:1,time:1000});
			}else{
        	console.log(data);
            play(data.data);
            pageJs(data.data.page.total,data.data.page.pages,data.data.page.size);
        }
        }
    }); 
	
	$("#search").click(function(){
       // alert("222")
        $.ajax({
            type:"post",
            url:"showEnterprisebilling",
            data:{
                "pageNum":1,
                "pageSize":5,
                "starttime":$("#datemin").val(),
                "endtime":$("#datemax").val(),
                //"enterpriseid":81
            },
            dataType:"json",
            success:function(data){
            	//alert("333");
                play(data.data);
               // alert("444");
                pageJs(data.data.page.total,data.data.page.pages,data.data.page.size);
            }
        }); 
        
    })
});

	function play(data){
		
	    var str = "";
	    var billingPages = data.page.records;
	   // alert(billingPages);
	   /* console.log(data)
	    console.log(data.page.comment)*/
	    for(var index = 0;index < billingPages.length; index++){
	        str += "<tr class='text-c'>";
	        str += "<td>"+ billingPages[index].endtime.split(" ")[0]+ "</td>";
	        str += "<td>"+ billingPages[index].endtime.split(" ")[1]+"</td>";
	        str += "<td>"+ billingPages[index].expend +"</td>";
	        str += "<td>"+ billingPages[index].income +"</td>";
	        if (billingPages[index].comment == null || billingPages[index].comment == ""){
	        	
	            str += "<td>-</td>";
	        }else {
	            str += "<td>"+ billingPages[index].comment +"</td>";
	        }
	        str += "</tr>"; 
	        
	    }
	    //alert(str);
	    $("#show").html(str);
	}
	function pageJs(totalSize,totalPage,showPageNum){
	    $("#pagination_2").whjPaging({
	        css: 'css-2',
	        totalSize: totalSize,
	        totalPage: totalPage,
	        showPageNum: showPageNum,
	        firstPage: '首页',
	        previousPage: '上一页',
	        nextPage: '下一页',
	        lastPage: '尾页',
	        skip: '',
	        confirm: '跳转',
	        refresh: '刷新',
	        totalPageText: '总共 {} 页',
	        totalSizeText: "总共 {} 条",
	        isShowFL: true,
	        isShowSkip: true,
	        isResetPage: false,
	        isShowRefresh: false,
	        isShowTotalPage: true,
	        isShowTotalSize: true,
	        isShowPageSizeOpt: false,
	        callBack: function (currPage,pageSize) {
	            $.ajax({
	                type:"post",
	                url:"showEnterprisebilling",
	                data:{
	                    "pageNum":currPage, 
	                    "pageSize":5,
	                    "starttime":$("#datemin").val(),
	                    "endtime":$("#datemax").val(),
	                    //"enterpriseid":81
	                },
	                dataType : 'json',
	                success:function(data){
	                	//alert("ok");
	                	 console.log(data);
	                	play(data.data);
	                    
	                }
	            });
	        }
	    });
	}
    


/*用户-查看*/
function member_show(title,url,id,w,h){
    layer_show(title,url,w,h);
}