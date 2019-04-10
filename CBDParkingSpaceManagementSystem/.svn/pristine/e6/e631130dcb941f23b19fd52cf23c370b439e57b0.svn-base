 $(function(){
    	 $.ajax({
	         	type:"post",
	         	url:"getAllContract",
	         	data:{
	         		"curPage":1,
	         		"pageSize":5
	         	},
	         	dataType:"json",
	         	success:function(data){
	         		//console.log(data.data);
	         		display(data.data);
	         		//总页数，总条数，每页显示条数
	         		pageJs(data.data.pages.totalData,data.data.pages.totalNum,data.data.pages.pageSize);
	         	}
	         });
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
    	            	//alert(currPage+5);
    	                  $.ajax({
    	                    type:"post",
    	                    url:"getAllContract",
    	                    data:{
    	                        "curPage":currPage,
    	                        "pageSize":5,
    	                    },
    	                    dataType : 'json',
    	                    success:function(data){
    	                    	console.log(data.data);
    	                    	//console.log(data.data.pages.pageData);
    	                    	display(data.data);
    	                    }
    	                });
    	            }
    	        });
    	    }
    	
    	function display(data){
        	var str = "";
        	var enterprisecontracts = data.pages.pageData;
        	for(var index = 0;index < enterprisecontracts.length; index++){
        		str += "<tr class='text-c'>";
        		str += "<td>"+ enterprisecontracts[index].contractnumber +"</td>";
        		str += "<td>"+ enterprisecontracts[index].contactperson +"</td>";
        		str += "<td>"+ enterprisecontracts[index].phone +"</td>";
        		str += "<td>"+ enterprisecontracts[index].fromdate +"</td>";
        		str += "<td>"+ enterprisecontracts[index].deadline +"</td>";
        		str += "<td>"+ enterprisecontracts[index].price +"</td>";
        		str += "<td class='td-manage'>";
        		str += "<a title='租户续约' href='javascript:;' id='"+enterprisecontracts[index].enterprisecontractid+"'";
        		str += "class='ml-update' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a> ";
        		str += "<a title='租户解约' href='javascript:;' class='ml-del' id='"+enterprisecontracts[index].enterprisecontractid+"'";
        		str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
        		str += "</td>"
        		str += "</tr>";
        	}
        	$("#bodyTr").html(str);
        }
    	 /* $('.table-sort').dataTable({
             "aaSorting": [[ 1, "desc" ]],//默认第几个排序
             "bStateSave": true,//状态保存
             "aoColumnDefs": [
                 //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                 {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
             ]
         }); */
    });
    	
        //pageJs(1,2,3);
       
    $("#bodyTr").on("click",".ml-update",function(){
    	var id = $(this).attr("id");
    	var url = 'jsp/backstage/admin/lease/contract-renew.jsp?id='+id;
    	member_edit('租户续约',url,'4','','510');
    });
    $("#bodyTr").on("click",".ml-del",function(){
    	//alert($(this).attr("id"));
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
                url: 'deletContractById',
                data:{"id":id},
                dataType: 'json',
                success: function(data){
                    //$(obj).parents("tr").remove();
                   
                    if(data.message=="ok"){
                    	layer.msg('已解除!',{icon:1,time:1000});
                    	window.location.reload();
                    }     
                }          
            }); 
        });
    } 