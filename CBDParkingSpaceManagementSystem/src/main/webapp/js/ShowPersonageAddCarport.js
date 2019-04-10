$(function(){
   
	$("#showCarport").on("click",".ml-yes",function(){
    	member_show('后台管理员审核中',' ','4','','510');
    });
	$("#showCarport").on("click",".ml-out",function(){
		member_show1('等待出租',' ','4','','510');
	});
	$("#showCarport").on("click",".ml-sell",function(){
		member_show2('等待出售',' ','4','','510');
	});
	$("#showCarport").on("click",".ml-dataOut",function(){
		member_show3('已经预定',' ','4','','510');
	});
	$("#showCarport").on("click",".ml-dataSell",function(){
		member_show4('已出租',' ','4','','510');
	});
	
	$("#showCarport").on("click",".ml-add",function(){
    	member_edit('添加出租发布时间','jsp/fortend/personal/AddParkingTime-page.jsp?id='+$(this).attr("id"),'4','600','450');
    });
	$("#showCarport").on("click",".ml-adds",function(){
    	member_edit('添加出售发布时间','jsp/fortend/personal/AddParkingSellTime.jsp?id='+$(this).attr("id") ,'4','550','350');
    });
    $("#showCarport").on("click",".ml-del",function(){
    	member_del(this,$(this).attr("id"));
    });
   $.ajax({
	   type : "post",
	   url : "showPersonageAddCarport",
	   data :{
		   "pageNum" : 1,
	   },
	   dataType : "json",
	   success :function(data){
		   var sp = data.data.page2.records;
		   console.log(data);
		   if(sp == 0){
				layer.msg('暂无数据',{icon:1,time:1500});
			}else{
		   display(data.data);
		   pageJs(data.data.page2.total,data.data.page2.pages,5);
			}
	   }
   })

});

/* 分页显示*/
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
                url:"showPersonageAddCarport",
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

function display(data){
	var str = "";
	var spa = data.page2.records;
	var no = "审核不通过";
	var yes = "审核通过";
	var noOrYes = "待审核";
	var reserve = "已经预定";
	var out = "等待出租";
	var sell = "等待出售";
	var dataOut = "已经预定";
	var dataSell = "已出租";
		
		for(var index = 0;index < spa.length;index++){
			str += "<tr class='text-c'>";
			str += "<td>"+ spa[index].equitiesid +"</td>";
			str += "<td>"+ spa[index].area +"</td>";
			str += "<td>"+ spa[index].state +"</td>";
			if(no == spa[index].state){
				str += "<td class='td-manage'>";
				str += "<a title='删除'href='javascript:;' class='ml-del' id='"+spa[index].privatecarsid+"'";
				str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
				str += "</td>"
			}else if( yes == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='发布出租'href='javascript:;'  id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-add' style='text-decoration: none'><i class='Hui-iconfont'>&#xe603;</i></a>";
				str += "&nbsp;<a title='发布出售'href='javascript:;' id='" +spa[index].privatecarsid+"'";
				str += "class='ml-adds' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a>";
				str += "</td>"
			}else if( noOrYes == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='后台管理员审核中'href='javascript:;' id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-yes' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e0;</i></a>";
				str += "</td>"
			}else if( reserve == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "&nbsp;<a title='删除'href='javascript:;' class='ml-del' id='"+spa[index].privatecarsid+"'";
				str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
				str += "</td>"
			}else if( out == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='等待出租'href='javascript:;' id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-out' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e0;</i></a>";
				str += "</td>"
			}else if( sell == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='等待出售'href='javascript:;' id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-sell' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e0;</i></a>";
				str += "</td>"
			}else if( dataOut == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='已经预定'href='javascript:;' id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-dataOut' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e0;</i></a>";
				str += "</td>"
			}else if( dataSell == spa[index].state) {
				str += "<td class='td-manage'>";
				str += "<a title='已经出售'href='javascript:;' id='"+spa[index].privatecarsid+ "'";
				str += "class='ml-dataSell' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e0;</i></a>";
				str += "</td>"
			}                 
			str += "</tr>";
		}
		$("#showCarport").html(str);
}

/*用户-添加*/
function member_add(title,url,w,h){
    layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer.confirm('后台管理员审核中')
}
function member_show1(title,url,id,w,h){
	layer.confirm('等待出租')
}
function member_show2(title,url,id,w,h){
	layer.confirm('等待出售')
}
function member_show3(title,url,id,w,h){
	layer.confirm('已经预定')
}
function member_show4(title,url,id,w,h){
	layer.confirm('已出租')
}
/*用户-停用*/
function member_stop(obj,id){
    layer.confirm('确认审核不通过？',function(index){
        $.ajax({
            type: 'POST',
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                $(obj).remove();
                layer.msg('已停用!',{icon: 5,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            }
        });
    });
}

/*用户-启用*/
function member_start(obj,id){
    layer.confirm('确认审核通过？',function(index){
        $.ajax({
            type: 'POST',
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                $(obj).remove();
                layer.msg('已启用!',{icon: 6,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            }
        });
    });
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*用户-删除*/
function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
    	
        $.ajax({
            type: 'POST',
            url: 'deletePersonageAddCarport',
            dataType: 'json',
            data:{
            	"privatecarsid" : id
            },
            success: function(data){
                layer.msg('已删除!',{icon:1,time:1000});
                console.log(data);
                display(data.data);
     		    pageJs(data.data.page2.total,data.data.page2.pages,5);
            },
            error:function(data) {
                console.log(data.msg);
            }
        });
    });
}