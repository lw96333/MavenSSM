function judge(obj,str){
			var my = obj;
			if(my.val() != "" && my.val() != null){
				my.css({
					"border": "1px solid gainsboro"
				});
				return true;
			}else{
				my.attr("placeholder",str);
				my.css({
					"border": "1px solid red"
				});
				return false;
			}
		}
		$("input[name=persons]").on("blur",function(){
			judge($(this),"请会商人员");
		});
		$("textarea[name=result]").on("blur",function(){
			judge($(this),"请输入会商意见");
		});

		function tableAjax(data){
			var str = "<tr class='info'><th>日期</th> <th>会商人员</th><th>会商结果</th></tr>";
			for(var i=0;i<data.pageData.length;i++){
				str += "<tr>";
				str += "<td>"+data.pageData[i].date+"</td>";
				str += "<td>"+data.pageData[i].persons+"</td>"
				str += "<td>"+data.pageData[i].result+"</td>"
				str += "</tr>";
			}
			$(".table").html(str);
		}
	 	function page(currPage,pageSize) { 
	 		
	 		
	 		$.ajax({
	        	type:"post",
	        	url:"instrumentPage",
	        	data:{
	        		"currPage":currPage,
	        		"pageSize":$("input[name=pageSize]").val(),
	        		"id":$("input[name=irbId]").val()
	        	},
	        	dataType : 'json',
	        	success:function(data){
	        		tableAjax(data);
	        		
	        	}
	        });
	    }
	 	$(function(){
	 		var totalSize= $("input[name=totalData]").val();
	         var totalPage =  $("input[name=totalNum]").val();
	         var showPageNum= $("input[name=pageSize]").val();
	         pageJs(parseInt(totalSize),parseInt(totalPage),parseInt(showPageNum));
	 		$("#back").click(function(){
	 			$(location).prop('href','instrumentManagement');
	 		});
	 		$("#add").click(function(){
	 			var chonse = $("input[name=irbId]").val();
	 			var falg = true;
	 			var persons = $("input[name=persons]").val();
	 			var result = $("textarea[name=result]").val();
	 			if(persons == "" || persons == null){
	 				falg = false;
	 				$("input[name=persons]").blur();
	 			}
	 			if(result == "" || result == null){
	 				falg = false;
	 				$("textarea[name=result]").blur();
	 			}
	 			if(falg){
	 				$.ajax({
	 		        	type:"post",
	 		        	url:"instrumentAdd",
	 		        	data:{
	 		        		"id":chonse,
	 		        		"persons":persons,
	 		        		"result":result
	 		        	},
	 		        	dataType : 'json',
	 		        	success:function(data){
	 		        		pageJs(parseInt(data.totalData),parseInt(data.totalNum),parseInt(data.pageSize));
	 		        		
	 		        		tableAjax(data);
	 		        		$("textarea[name=result]").val("");
	 		        		$("input[name=persons]").val("");
	 		        		$("#modal_message").html("添加成功！");
	                		showModal();
	 		        	}
	 		        });
	 			}
	 		});
	 		function pageJs(totalSize,totalPage,showPageNum){
	 			$("#pagination_2").whjPaging({
		 	         css: 'css-2',
		 	         pageSizeOpt: [
		 	             {value: 5, text: '5/page', selected: true},
		 	             {value: 10, text: '10/page'},
		 	             {value: 15, text: '15/page'},
		 	             {value: 20, text: '20/page'}
		 	         ],
		 	        	totalSize: totalSize,
		 	         totalPage: totalPage,
		 	         showPageNum: showPageNum,
		 	         firstPage: '首页',
		 	         previousPage: '上一页',
		 	         nextPage: '下一页',
		 	         lastPage: '尾页',
		 	         skip: '',
		 	         confirm: '跳转',
		 	         refresh: 'refresh',
		 	         totalPageText: '共 {} 页',
		 	         totalSizeText: "共 {} 条",
		 	         isShowFL: true,
		 	         isShowSkip: true,
		 	         isResetPage: false,
		 	         isShowRefresh: false,
		 	         isShowTotalPage: true,
		 	         isShowTotalSize: true,
		 	         isShowPageSizeOpt: false,
		 	         callBack: function (currPage, pageSize) {
		 	        	page(currPage,pageSize);
		 	         }
		 	     });
	 		}
	 			
	 	});
	 	var clearFlag = 0;
	 	var count = 1;//设置3秒后自动消失
	 	var showModal = function(){
	 	    $("#my-modal-alert").toggle();//显示模态框

	 	    $("#my-modal-alert").draggable({//设置模态框可拖动（需要引入jquery-ui.min.js）
	 	        handle: ".modal-header"
	 	    });

	 	    clearFlag = self.setInterval("autoClose()",1000);//每过一秒调用一次autoClose方法
	 	}

	 	var autoClose = function(){
	 	    if(count>0){
	 	        $("#num").html(count + "秒后窗口将自动关闭");
	 	        count--;
	 	    }else if(count<=0){
	 	        window.clearInterval(clearFlag);
	 	        $("#num").html("");
	 	        $("#my-modal-alert").fadeOut("slow");
	 	        count = 3;
	 	        $("#my-modal-alert").toggle();
	 	    }
	 	}