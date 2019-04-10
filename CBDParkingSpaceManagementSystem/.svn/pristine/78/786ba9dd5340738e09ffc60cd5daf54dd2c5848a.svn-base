var message = "";
$(function(){
   
    $("#bodyTruck").on("click",".ml-add",function(){
    	member_edit('添加','jsp/backstage/admin/parkingManagement/TruckSpace-add.jsp','4','','510');
    });
   $.ajax({
	   type : "post",
	   url : "selectCbd",
	   data :{
		   "pageNum" : 1,
	   },
	   dataType : "json",
	   success :function(data){
		   console.log(data);
		   display(data.data);
		   pageJs(data.data.page2.total,data.data.page2.pages,5);
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
                url:"selectCbd",
                data:{
                    "pageNum":currPage,
                    "showCbds" : message
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
	var cbd = data.page2.records;
	var power = data.power;
	for(var index = 0;index < cbd.length;index++){
		str += "<tr class='text-c'>";
		str += "<td>"+ cbd[index].areanumber +"</td>";
		str += "<td>"+ cbd[index].address +"</td>";
    	str += "</tr>";
	}
	$("#bodyTruck").html(str);
}

$(function(){
	$("#showCbd").click(function(){
		var showCbds = $("#showCbds").val();
		if(showCbds == ""){
			message = "";
		}else{
			message = showCbds;
		}
		$.ajax({
			type : "post",
			url : "selectCbd",
			data : {
				"showCbds" : message,
				"pageNum" : 1,
				 "pageSize":5
			},
			dataType : "json",
			success : function(data){
				if(data.data.page2.records == ""){
					layer.msg('未查到数据',{icon:1,time:1000});
				}
					console.log(data);
					display(data.data);
					pageJs(data.data.page2.total,data.data.page2.pages,data.data.page2.size);
			}
		})
	})
})

/*用户-添加*/
function member_add(title,url,w,h){
    layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
    layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
    layer.confirm('确认要停用吗？',function(index){
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
    layer.confirm('确认要启用吗？',function(index){
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
            url: '',
            dataType: 'json',
            success: function(data){
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
            },
            error:function(data) {
                console.log(data.msg);
            }
        });
    });
}