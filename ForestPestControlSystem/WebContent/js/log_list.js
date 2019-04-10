var startLog="";
			var endLog="";
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
			function judgeTrue(obj){
				obj.css({
					"border": "1px solid gainsboro"
				});
			}
			$(function(){
				var totalSize = $("input[name=totalData]").val();
	            var totalPage = $("input[name=totalNum]").val();
	            var showPageNum = $("input[name=pageSize]").val();
				pageJs(parseInt(totalSize),parseInt(totalPage),parseInt(showPageNum));
				$("input[name=startDate]").on("blur",function(){
					var end = $("input[name=endDate]").val();
					if($(this).val()==""||$(this).val()==null||end==null||end==""){
						falg=false;
					}
				});
				$("input[name=endDate]").on("blur",function(){
					var end = $("input[name=stratDate]").val();
					if($(this).val()==""||$(this).val()==null||end==null||end==""){
						falg=false;
					}
				});
				$("#query").click(function(){
		
					var bol = true;
					falg=true;
					startLog = $("input[name=startDate]").val();
		 			endLog = $("input[name=endDate]").val();
		 			
					if(endLog < startLog && (endLog!=""&&endLog!=null)){
						alert("開始時間必須小於結束時間");
						bol = false;
					}
					if(bol){
						$.ajax({
		                	type:"post",
		                	url:"logPage",
		                	data:{
		                		"currPage":1,
		                		"pageSize":$("input[name=pageSize]").val(),
		                		"stratDate":startLog,
		                		"endDate":endLog
		                	},
		                	dataType : 'json',
		                	success:function(data){
		                		pageJs(parseInt(data.totalData),parseInt(data.totalNum),parseInt(data.pageSize));
		                		tableAjax(data);	
		                	}
		                });
					}
					
				});
			});
			
			function tableAjax(data){
				var str = "<tr class='info'><th>日志内容</th> <th>日期</th></tr>";
	    		for(var i=0;i<data.pageData.length;i++){
	    			str += "<tr>";
	    			str += "<td>"+data.pageData[i].content+"</td>";
	    			str += "<td>"+data.pageData[i].date+"</td>"
	    			str += "</tr>";
	    		}
	    		$(".table").html(str);
			}
			function page(currPage,pageSize) { 
				var stratDate = "";
	 			var endDate = "";
		 		if(endLog!=""||startLog!=""){
		 			stratDate = startLog;
		 			endDate = endLog;
		 		}else{
		 			stratDate = $("input[name=startDate]").val();
		 			endDate = $("input[name=endDate]").val();
		 		}
		
		 		$.ajax({
                	type:"post",
                	url:"logPage",
                	data:{
                		"currPage":currPage,
                		"pageSize":$("input[name=pageSize]").val(),
                		"stratDate":stratDate,
                		"endDate":endDate
                	},
                	dataType : 'json',
                	success:function(data){
                		tableAjax(data);
                	
                	}
                });
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
			            	url:"diseasesList_managementPage",
			            	data:{
			            		"currPage":currPage,
			            		"pageSize":5,
			            	},
			            	dataType : 'json',
			            	success:function(data){
			            		
			            		page(currPage,pageSize);
			            	}
			            });
			        }
			    });
			}
		