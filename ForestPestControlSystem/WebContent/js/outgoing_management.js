			$(function(){
			$("#addOutGoing").click(function(){
				$(location).prop('href', "addOutGoing");
 		    });
		});
			/*$(function(){
				$("#butts").click(function(){
					$(location).prop('href', "jsp/outgoing_management.jsp");
	 		 });
			});*/
			var stratLog;
		 	var endLog;
		
		 	function tableAjax(data){
		 		var str = "<tr class='info'><th>日期</th> <th>名称</th><th>主要用涂</th><th>领用数量</th><th>领用小班</th></tr>";
		 		for(var i=0;i<data.pageData.length;i++){
		 			str += "<tr>";
		 			str += "<td >"+data.pageData[i].date+"</td>";
		 			str += "<td>"+data.pageData[i].goods.goodsName+"</td>"
		 			str += "<td>"+data.pageData[i].purpoose+"</td>"
		 			str += "<td>"+data.pageData[i].num+"</td>"
		 			str += "<td>"+data.pageData[i].id.name+"</td>"
		 			str += "</tr>";
		 		}
		 		$(".table").html(str);
		 	
		 	}
		 	function page(currPage,pageSize) { 
		 		var stratDate;
		 		var endDate;
		 		if(stratLog == "" || stratLog == null){
		 			stratDate = "";
		 		}else{
		 			stratDate = stratLog;
		 		}
		 		if(endLog == "" || endLog == null){
		 			endDate = "";
		 		}else{
		 			endDate = endLog;
		 		}
		 		$.ajax({
		 	    	type:"post",
		 	    	url:"outgoing_managementPage",
		 	    	data:{
		 	    		"currPage":currPage,
		 	    		"pageSize":$("input[name=pageSize]").val(),
		 	    		"stratDate":stratDate,
		 	    		"endDate":endDate,
		 	    	},
		 	    	dataType : 'json',
		 	    	success:function(data){
		 	    		tableAjax(data);
		 	    	}
		 	    });
		 	}
		 	$(function(){
		 		$("#but").click(function(){
		 			stratLog = $("#stratDate").val();
		 			 endLog = $("#endDate").val();
		 			if(stratLog.trim() == "" & endLog.trim() == ""){
		 				alert("请输入查询条件");
		 			} if(stratLog.trim() > endLog.trim() & endLog.trim() != ""){
		 				alert("开始日期必须小于结束日期");
		 				
		 			}else {
		 				$.ajax({
		 					type:"post",
		 					url:"outgoing_managementPage",
		 					data:{
		 						"currPage":1,
		 						"pageSize":$("input[name=pageSize]").val(),
		 						"stratDate":stratLog,
		 						"endDate":endLog,
		 					},
		 					dataType : 'json',
		 					success:function(data){
		 						falg= true;
		 						tableAjax(data);
		 						$("#pagination_2").whjPaging({
		 							css: 'css-2',
		 							totalSize: data.totalData,
		 							totalPage: data.totalNum,
		 							showPageNum: data.pageSize,
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
		 							callBack: function(currPage,pageSize){
		 								page(currPage,pageSize);
		 							}
		 						});
		 						
		 					}
		 				});
		 			}
		 		});
		 	});
		 	$("#pagination_2").whjPaging({
		 	    css: 'css-2',
		 	    totalSize: $("input[name=totalData]").val(),
		 	    totalPage: $("input[name=totalNum]").val(),
		 	    showPageNum: $("input[name=pageSize]").val(),
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
		 	    callBack: function(currPage,pageSize){
		 	    	page(currPage,pageSize);
		 	    	
		 	    }
		 	});
		 