	$(function(){
    //调用分页显示函数分页
		ajxa();
	//模糊查询按钮
	$("#submit").click(function(){
			
		$.ajax({
			type:"post",
			url:"selectEnterpriseUserbyname",
			data:{
				"floor":$("#floor").val(),
				"phone":$("#phone").val(),
				"contactperson":$("#contactperson").val(),
				"enterpriename":$("#enterpriename").val(),
				"pageNum":1,
				"pageSize":5
			},
		    dataType:"json",
		    success:function(data){
		    	//console.log(data.data.page.records);
		    	display(data.data); 
		    	pageJs(data.data.page.total,data.data.page.pages,data.data.page.size);
		    }
			
		})
	})
	$("#bodyTr").on("click",".member_del",function(){
		member_del(this,$(this).attr("id"));
	});
/* 	ajax(1);

 function ajax(pageNum) {
	
} */
});

function ajxa() {
	$.ajax({
		type:"post",
		url:"selectEnterpriseUserbyname",
		data:{
			"floor":$("#floor").val(),
			"phone":$("#phone").val(),
			"contactperson":$("#contactperson").val(),
			"enterpriename":$("#enterpriename").val(),
			"pageNum":1,
			"pageSize":5
			
		},
		dataType:"json",
		success:function(data){
			console.log(data);
			display(data.data);
			pageJs(data.data.page.total,data.data.page.pages,5);
		}
	});	
}
/* 分页 */
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
				url:"selectEnterpriseUserbyname",
				data:{
					"floor":$("#floor").val(),
					"phone":$("#phone").val(),
					"contactperson":$("#contactperson").val(),
					"enterpriename":$("#enterpriename").val(),
					"pageNum":currPage,
					"pageSize":5
				},
				dataType : 'json',
				success:function(data){
					 display(data.data); 
				}
			});
		}
	});
}

function display(data){
	var str="";
	var enterprise = data.page.records;
	if(enterprise.length==0){
		layer.msg('暂无数据!',{icon:1,time:1000});
		$("#bodyTr").html("");
	}else{
		$.each(enterprise,function(i,ent){
			str +="<tr class='text-c'><td>"+ ent.name
			+"</td><td>" + ent.enterpriename 
			+"</td><td>" + ent.contactperson
			+"</td><td>" + ent.phone
			+"</td><td>" + ent.floor
			+"</td><td class='td-manage'>" + "<a title='删除' href='javascript:;' onclick=member_del(this,"
			+ent.enterpriseid +"," + data.page.current +")" + " style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>"
			+"</td></tr>"
		});
		$("#bodyTr").html(str);
	}
} 

/*用户-删除*/
function member_del(obj,id,pageNum){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'post',
			url: 'deleteEnterpriseUser',
			dataType: 'json',
			data:{
				"enterpriseid":id
			},
			success: function(data){
				if(data.code == 200){
		            layer.msg('已删除!',{icon:1,time:1000});
		            
		            ajxa();
				}else{
					layer.msg('删除失败!',{icon:1,time:1000});	
				}
	        },
			error:function(data) {
				console.log(data);
			}
		});		
	});
}
