        var pageNames;
		var pageInsects;
		
		$(function(){
			$("#add_instruments").click(function(){
				$(location).prop('href', "jsp/add_instruments.jsp");
 		    });
		});
		/*$(function(){
			$("#butts").click(function(){
				$(location).prop('href', "../consultation_management?");
 		    });
		});*/
		
		function tableAjax(data){
			var str = "<tr class='info'><th>名称</th> <th>防止类型</th><th>主要用途</th></tr>";
    		for(var i=0;i<data.pageData.length;i++){
    			str += "<tr>";
    			str += "<td>"+data.pageData[i].name+"</td>";
    			str += "<td>"+data.pageData[i].insect.type+"</td>";
    			str += "<td>"+data.pageData[i].purpose+"</td>";
    			str += "</tr>";
    		}
    		$(".table").html(str);
		}
		
	 function page(currPage,pageSize) { 
	 	 var pageName;	
		 var pageInsect;
//		 	alert(pageNames);
//		 	alert(pageInsects);
		 	if(pageNames == "" || pageNames == null){
		 		pageName = "";
		 	}else{
		 		pageName = pageNames;
		 	}	
		 	if(pageInsects == "" || pageInsects == null){
		 		pageInsect = "";
		 	}else{
		 		pageInsect = pageInsects;
		 	}
	 		$.ajax({
            	type:"post",
            	url:"consultation_managementPage",
            	data:{
            		"currPage":currPage,
            		"pageSize":$("input[name=pageSize]").val(),
            		"pageName":pageName,
            		"pageInsect":pageInsect
            	},
            	
            	dataType : 'json',
            	success:function(data){
            		tableAjax(data);
            		
            	}
            });
        }
	   $(function(){
	 		$("#butt").click(function(){
	 			 pageNames = $("#pageName").val().trim();
	 			 pageInsects = $("#pageInsect").val().trim();
//	 			alert(2313123); 
//	 			alert(pageInsects);
	 			if(pageNames == "" & pageInsects == ""){
	 				alert("请输入要查询的条件");
	 			}else{
	 				$.ajax({
	 					type:"post",
	 					url:"consultation_managementPage",
	 					data:{
	 						"currPage":1,
	 						"pageSize":$("input[name=pageSize]").val(),
	 						"pageName":pageNames,
	 						"pageInsect":pageInsects,
	 					},
	 					dataType : 'json',
	 					success:function(data){
	 						falg= true;
	 						tableAjax(data);
//	 						alert(data);
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
	 								page(currPage,5);
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