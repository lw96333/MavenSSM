$(function(){
    	 $("#bodyTr").on("click",".ml-add",function(){
         	member_add(this,$(this).attr("id"),$(this).attr("value"));
         });
    	 $("#bodyTr").on("click",".ml-del",function(){
         	member_del(this,$(this).attr("id"));
         });
    	 $.ajax({
         	type:"post",
         	url:"showAllComplaint",
         	data:{
         		"curPage":1,
         		"pageSize":5
         	},
         	dataType:"json",
         	success:function(data){
         		 console.log(data);
         		display(data.data);
         		pageJs(data.data.Page.total,data.data.Page.pages,data.data.Page.size);
         	}
         });	
    	 /* 显示数据 */
    	    function display(data){
    	    	var str = "";
    	    	var admin = data.Page.records;
    	    	var user = data.ComplaintBean;
    	    	for(var index = 0;index < admin.length; index++){
    	    		str += "<tr class='text-c'>";
    	    		str += "<td>"+ user[index].buser +"</td>";
    	    		str += "<td>"+ user[index].btUser +"</td>";
    	    		str += "<td>"+ admin[index].complaintime +"</td>";
    	    		str += "<td>"+ admin[index].content +"</td>";
    	    		str += "<td class='td-manage'>";
    	    		str += "<a title='投诉成功'href='javascript:;' id='"+admin[index].complaintid+"' value='"+admin[index].btid+"'";
    	    		str += "class='ml-add' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a> ";
    	    		str += "<a title='投诉失败'href='javascript:;' class='ml-del' id='"+admin[index].complaintid+"'";
    	    		str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
    	    		str += "</td>"
    	    		str += "</tr>";
    	    	}
    	    	
    	    	$("#bodyTr").html(str);
    	    	
    	    	
    	    }
        $('.table-sort').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
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
                    $.ajax({
                        type:"post",
                        url:"showAllComplaint",
                        data:{
                            "curPage":currPage,
                            "pageSize":5,
                        },
                        dataType : 'json',
                        success:function(data){

                        	display(data.data);
                        }
                    });
                }
            });
        }

    });
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认投诉失败？',function(index){
            $.ajax({
                type: 'POST',
                url: 'updateComplaint',
                data:{
                	"complaintid":id,
                	"state":'未处理'
                },
                dataType:'json',
                success: function(data){
                    //$(obj).parents("tr").remove();
                	 layer.msg('已删除!',{icon:1,time:1000});
        			setTimeout(function(){
        				 window.location.reload();
        			},1500);

                }
                
            });
        });
    }
    /*用户-投诉成功*/
    function member_add(obj,id,btid){
        layer.confirm('确认投诉成功？',function(index){
        	//alert(btid)
             $.ajax({
                type: 'POST',
                url: 'updateComplaint',
                data:{
                	"complaintid":id,
                	"btid":btid,
                	"state":'已处理'
                },
                dataType:'json',
                success: function(data){
                    //$(obj).parents("tr").remove();
                	layer.msg('投诉已处理!',{icon:1,time:1000});
        			setTimeout(function(){
        				window.location.reload();
        			},1500);
  
                }
                
            }); 
        });
    }