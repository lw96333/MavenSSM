$(function(){
	$.ajax({
		type:"post",
		url:"shellHistory",
		data:{
			"pageNum":1,
			"pageSize":5,
		},
		dataType : 'json',
		success:function(data){
			pageJs(data.data.shellHistory.totalData,data.data.shellHistory.totalNum,data.data.shellHistory.pageSize);
			console.log(data.data.shellHistory);
     		display(data.data.shellHistory);
			//page(currPage,pageSize);
		}
	});
	/* $('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	}); */
	//pageJs(10,100,10);
	 /* 显示数据 */
    function display(data){
    	var str = "";
    	var admin = data.pageData;
    	for(var index = 0;index < admin.length; index++){
    		str += "<tr class='text-c'>";
    		str += "<td>"+ admin[index].equitiesid +"</td>";
    		str += "<td>"+ admin[index].area +"</td>";
    		str += "<td>"+ admin[index].fromdate +"</td>";
    		str += "<td>"+ admin[index].realname +"</td>";
    		str += "<td>"+ admin[index].phone +"</td>";
    		str += "<td class='td-manage'>";
    		str += "<a title='投诉' href='javascript:;' id='"+admin[index].userid+"'";
    		str += "class='ml-5' style='text-decoration: none'><i class='Hui-iconfont'>&#xe65f;</i></a> ";
    		str += "</td>"
    		str += "</tr>";
    	}
    	
    	$("#bodyTr").html(str);
    }
	function pageJs(totalSize,totalPage,showPageNum){
		$("#pagination_2").whjPaging({
			css: 'css-2',
			totalSize: totalSize,
			totalPage: totalPage,
			showPageNum: 3,
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
					url:"shellHistory",
					data:{
						"pageNum":currPage,
						"pageSize":5
					},
					dataType : 'json',
					success:function(data){
						display(data.data.shellHistory);
						//page(currPage,pageSize);
					}
				});
			}
		});
	}
	
	
	$("#bodyTr").on("click",".ml-5",function(){
		var id = $(this).attr("id");
		layer_show('投诉','jsp/fortend/personal/ComplaintInfo.jsp?id='+id+'','350','250');
	/* layer.msg('投诉成功! ',{icon:1,time:1000}); */
	});
	
});