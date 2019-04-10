$(function(){
	//send(123,'水电费大师 ');
	 	var y = "☆"; 
	    var x = "★"; 
	$.ajax({
		type:"post",
		url:"selectAllBuyPark",
		data:{
			"pageNum":1,
			"pageSize":5,
		},
		dataType : 'json',
		success:function(data){
			console.log(data.data.allSellCar);
			display(data.data.allSellCar);
     		pageJs(data.data.allSellCar.totalData,data.data.allSellCar.totalNum,data.data.allSellCar.pageSize);
		}
	});
	//pageJs(10,100,10);
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
    	var admin = data.pageData;
    	for(var index = 0;index < admin.length; index++){
    		var complaintnumber = parseInt(admin[index].complaintnumber);
    		var dealnumber = parseInt(admin[index].dealnumber);
    		var xingyudu = 0;
    		if(dealnumber==0&&complaintnumber==0){
    			xingyudu = 91;
    		}else{
    			xingyudu = (dealnumber/(dealnumber+complaintnumber))*100;
    		}
    		str += "<tr class='text-c'>";
    		str += "<td>"+ admin[index].equitiesid +"</td>";
    		str += "<td>"+ admin[index].area +"</td>";
    		str += "<td>"+ admin[index].realname +"</td>";
    		str += "<td id='xyd'>";
    		if(xingyudu<=20){
    			str += y+y+y+y+y;
    		}
    		if(xingyudu>20&&xingyudu<=30){
    			str += x+y+y+y+y;
    		}
    		if(xingyudu>30&&xingyudu<=40){
    			str += x+x+y+y+y;
    		}
    		if(xingyudu>40&&xingyudu<=60){
    			str += x+x+x+y+y;
    		}
    		if(xingyudu>60&&xingyudu<=80){
    			str += x+x+x+y+y;
    		}
    		if(xingyudu>80&&xingyudu<=90){
    			str += x+x+x+x+y;
    		}
    		if(xingyudu>90){
    			str += x+x+x+x+x;
    		}
    		str +="</td>";
    		str += "<td class='td-manage'>";
    		if("查看合同"==admin[index].sellState||admin[index].sellState=="交易完成"){
    			str += "<a title='查看合同 '   href='javascript:;' id='"+admin[index].privatecarsid+"'";
        		str += "class='lookinfo' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6df;</i></a> ";
    		}else if(admin[index].sellState=='同意出售'){
    			str += "<a title='等待合同'  href='javascript:;'  class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe69c;</i></a>";
    		}else{
    			str += "<a title='等待对方同意'  href='javascript:;'  class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe69c;</i></a>";
    		}
    		
    		str += "</td>"
    		str += "</tr>";
    	}
    	
    	$("#bodyTr").html(str);
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
					url:"selectAllBuyPark",
					data:{
						"pageNum":currPage,
						"pageSize":5,
					},
					dataType : 'json',
					success:function(data){
						display(data.data.allSellCar);
					}
				});
			}
		});
	}
	$("#bodyTr").on("click",".lookinfo",function(){
		var id = $(this).attr("id");//车位id
		layer_show('查看合同' ,'jsp/fortend/personal/contractPersonSell.jsp?carid='+id+'','','510');
	})
});