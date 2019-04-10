$(function(){
	
	$.ajax({
        type:"post",
        url:"showEnterpriseLeaseCarport",
        data:{
            "pageNum":1,
            "pageSize":5
        },
        dataType:"json",
        success:function(data){
        	console.log(data)
            console.log(data.data.page.pageData)
            if (data.data.page.pageData == "") {
                layer.msg('未查到数据',{icon:1,time:1000});
            }else {
                display(data.data);
                pageJs(data.data.page.totalData,data.data.page.totalNum,data.data.page.pageSize);
            }
            
        }
    }); 
	
});

function display(data){
    var str = "";
    var cbdLeaseCarport = data.page.pageData;
    for(var index = 0;index < cbdLeaseCarport.length; index++){
        str += "<tr class='text-c'>";
        str += "<td>"+ cbdLeaseCarport[index].address +"</td>";
        str += "<td>"+ cbdLeaseCarport[index].areanumber +"</td>";
        str += "<td>"+ cbdLeaseCarport[index].contractnumber +"</td>";
        str += "<td>"+ cbdLeaseCarport[index].fromdate +"</td>";
        str += "<td>"+ cbdLeaseCarport[index].deadline +"</td>";
        str += "</tr>";
    }
    $("#show").html(str);
}

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
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
				url:"showEnterpriseLeaseCarport",
				data:{
					"pageNum":currPage,
					"pageSize":5
				},
				dataType : 'json',
				success:function(data){
				    
					display(data.data)
				}
			});
		}
	});
}