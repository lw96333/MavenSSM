$(function(){
	$.ajax({
		type:"post",
		url:"selectAllSellCar",
		data:{
			"pageNum":1,
			"pageSize":4,
			"startPricte":$("#startpice").val(),
			"endPricte":$("#endpice").val()
		},
		dataType : 'json',
		success:function(data){
			console.log(data);
			if(data.data.allSellCar.pageData.length==0){
				layer.msg('暂无数据', {icon : 1,time : 1000});
			}
     		display(data.data.allSellCar);
     		pageJs(data.data.allSellCar.totalData,data.data.allSellCar.totalNum,data.data.allSellCar.pageSize);
			//page(currPage,pageSize);
		}
	});
	//pageJs(3,4,5);
	/* $('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	}); */
	function display(data){
    	var str = "";
    	var BuyCarParking = data.pageData;
    	//console.log(BuyCarParking);
    	for(var index = 0;index < BuyCarParking.length; index++){
    		str +="<li class='col-sm-3'>";
    		str +="<img src='images/carPage.jpg' style='width:200px;height: 200px;'/>";
    		str +="<h4>车位地址</h4>";
    		str +="<p>"+BuyCarParking[index].area+"</p>";
    		var complaintnumber = parseInt(BuyCarParking[index].complaintnumber);
    		var dealnumber = parseInt(BuyCarParking[index].dealnumber);
    		var xingyudu = 0;
    		if(dealnumber==0&&complaintnumber==0){
    			xingyudu = 91;
    		}else{
    			xingyudu = (dealnumber/(dealnumber+complaintnumber))*100;
    		}
    		var info = BuyCarParking[index].issuetime+"&"+BuyCarParking[index].realname+"&"+BuyCarParking[index].job+"&"+BuyCarParking[index].phone+"&"+xingyudu+"&"+BuyCarParking[index].price+"&"+BuyCarParking[index].userid;
    		str +="<a class='info' href='javascript:;'id='"+BuyCarParking[index].privatecarsid+"' style='color: red;' value='"+info+"'>查看详情</a>";
    		str += "</li>";
    	}
    	$(".row").html(str);
    }
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
					url:"selectAllSellCar",
					data:{
						"pageNum":currPage,
						"pageSize":4,
						"startPricte":$("#startpice").val(),
						"endPricte":$("#endpice").val()
					},
					dataType : 'json',
					success:function(data){
						display(data.data.allSellCar);
					}
				});
			}
		});
	}
	$(".row").on("click",".info",function(){
			var carid = $(this).attr("id");//车位id
			var info = $(this).attr("value")+"&"+carid;//车位出售人信息
			layer_show('查看详情','jsp/fortend/personal/Lookdetails.jsp?info='+info+'','500','450');
		
	})
	
	$("#shou").click(function(){
		var startpice = $("#startpice");
		var endpice = $("#endpice");
		if(!/^[0-9]{1,}$/.test(startpice.val())&&!/^[0-9]{1,}$/.test(endpice.val())){
			layer.msg('金额只能输入数字', {icon : 1,time : 1000});
		}else{
			$.ajax({
				type:"post",
				url:"selectAllSellCar",
				data:{
					"pageNum":1,
					"pageSize":4,
					"startPricte":$("#startpice").val(),
					"endPricte":$("#endpice").val()
				},
				dataType : 'json',
				success:function(data){
					console.log(data.data.allSellCar);
		     		display(data.data.allSellCar);
		     		pageJs(data.data.allSellCar.totalData,data.data.allSellCar.totalNum,data.data.allSellCar.pageSize);
					//page(currPage,pageSize);
				}
			});
		}
		
		
	})
});
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
function change_password(title,url,w,h){
     layer_show(title,url,w,h);
}