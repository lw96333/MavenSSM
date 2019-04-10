  $(function(){
    	 $.ajax({
	         	type:"post",
	         	url:"showPageExternalcontract",
	         	data:{
	         		"curPage":1,
	         		"pageSize":5
	         	},
	         	dataType:"json",
	         	success:function(data){
	         		var number = data.data.page.records.length;
	         		if(number==0){
	         			layer.msg('暂无数据',{icon:1,time:1000});
	         		}else{
	         			display(data.data); 
		         		//总条数，总页数，每页显示条数
		         		pageJs(data.data.page.total,data.data.page.pages,data.data.page.size);
	         		}
	         		
	         	}
	         });
    	 
    	//下一页和上一页的调用刷新
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
    	                    url:"showPageExternalcontract",
    	                    data:{
    	                        "curPage":currPage,
    	                        "pageSize":5,
    	                    },
    	                    dataType : 'json',
    	                    success:function(data){
    	                    	//console.log(data.data.pages.pageData);
    	                    	display(data.data);
    	                    }
    	                });
    	            }
    	        });
    	    }
    	//当前页面显示的数据
    	function display(data){
        	var str = "";
        	var externalcontract = data.page.records;
        	for(var index = 0;index < externalcontract.length; index++){
        		str += "<tr class='text-c'>";
        		str += "<td>"+ externalcontract[index].contractnumber +"</td>";
        		str += "<td>"+ externalcontract[index].contractcompany +"</td>";
        		str += "<td>"+ externalcontract[index].contactperson +"</td>";
        		str += "<td>"+ externalcontract[index].phone +"</td>";
        		str += "<td>"+ externalcontract[index].starttime +"</td>";
        		str += "<td>"+ externalcontract[index].endtime +"</td>";
        		str += "<td>"+ externalcontract[index].price +"</td>";
        		str += "<td class='td-manage'>";
        		str += "<a title='租户续约' href='javascript:;' id='"+externalcontract[index].id+"'";
        		str += "class='ml-update' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a> ";
        		str += "<a title='租户解约' href='javascript:;' class='ml-del' id='"+externalcontract[index].id+"'";
        		str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
        		str += "</td>"
        		str += "</tr>";
        	}
        	$("#bodyTr").html(str);
        }
    });
       
    $("#bodyTr").on("click",".ml-update",function(){
    	var id = $(this).attr("id");
    	var url = 'jsp/backstage/admin/externalContact/AddExternalContracts.jsp?id='+id;
    	member_edit('租户续约',url,'4','','510');
    });
    $("#bodyTr").on("click",".ml-del",function(){
    	
    	member_del(this,$(this).attr("id"));
    });
    /*用户-编辑*/
     function member_edit(title,url,id,w,h){
   
        layer_show(title,url,w,h);
    } 

    /*用户-删除*/
   function member_del(obj,id){
        layer.confirm('确认要解除合约吗？',function(index){
            $.ajax({
                type: 'POST',
                url: 'deleteExternalcontract',
                data:{"id":id},
                dataType: 'json',
                success: function(data){
                    if(data.message=="ok"){
                    	layer.msg('已解除!',{icon:1,time:1000});
                    	window.location.reload();
                    }
                }
               
            }); 
        });
    } 