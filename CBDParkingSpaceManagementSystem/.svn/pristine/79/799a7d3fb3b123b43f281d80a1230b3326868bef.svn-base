$(function() {
	var y = "☆"; 
    var x = "★"; 
	//查询所有出售车位信息
	$.ajax({
		type : "post",
		url : "selectAllShellPark",
		data : {
			"pageNum" : 1,
			"pageSize" : 5
		},
		dataType : 'json',
		success : function(data) {
			console.log(data.data.allSellCar);
			if(data.data.allSellCar.pageData.length==0){
				layer.msg('暂无数据', {icon : 1,time : 1000});
			}
			display(data.data.allSellCar);
     		pageJs(data.data.allSellCar.totalData,data.data.allSellCar.totalNum,data.data.allSellCar.pageSize);
		}
	});
	//pageJs(1,2,3);
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
    		if(xingyudu<=10){
   
    			str += y+y+y+y+y;
    		}
    		if(xingyudu>10&&xingyudu<=20){
    			str += x+y+y+y+y;
    		}
    		if(xingyudu>20&&xingyudu<=40){
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
    		str += "<td>"+ admin[index].price+"</td>";
    		str += "<td class='td-manage'>";
    		if("查看合同"==admin[index].buyState||admin[index].buyState=="交易完成"){
    			str += "<a title='查看合同 '   href='javascript:;' id='"+admin[index].privatecarsid+"' value='"+admin[index].userid+"'";
        		str += "class='lookinfo' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6df;</i></a> ";
    		}else if("同意出售"==admin[index].buyState){
    			str += "<a title='等待合同'  href='javascript:;'  class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe69c;</i></a>";
    		}else if(admin[index].buyState=='等待出售人回复'){
    			var info = admin[index].realname+"&"+admin[index].job+"&"+admin[index].phone+"&"+xingyudu+"&"+admin[index].message+"&"+admin[index].userid;
    			str += "<a title='查看预订人信息'  id='"+admin[index].privatecarsid+"' value='"+info+"' style='text-decoration:none'  class='lookpersoninfo'><i class='Hui-iconfont'>&#xe60c;</i></a>"
    		}else{
    			str += "<a title='等待对方同意'  href='javascript:;'  class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe69c;</i></a>";
    		}
    		str += "</td>"
    		str += "</tr>";
    	}
    	
    	$("#tbody").html(str);
    }
	$("#tbody").on("click",".lookpersoninfo",function(){
		var id = $(this).attr("id");
		var info = $(this).attr("value")+"&"+id;
		member_change('查看预定人信息','jsp/fortend/personal/LookPreson.jsp?info='+info+'','500','450');
    });
	$("#tbody").on("click",".lookinfo",function(){
		var id = $(this).attr("id");
			id = id+"&"+$(this).attr("value");
		member_change('查看合同' ,'jsp/fortend/personal/contractPersonBuy.jsp?carid='+id+'','','510');
    });
	
	
});

function pageJs(totalSize, totalPage, showPageNum) {
	$("#pagination_2").whjPaging({
		css : 'css-2',
		totalSize : totalSize,
		totalPage : totalPage,
		showPageNum : 3,
		firstPage : '首页',
		previousPage : '上一页',
		nextPage : '下一页',
		lastPage : '尾页',
		skip : '',
		confirm : '跳转',
		refresh : '刷新',
		totalPageText : '总共 {} 页',
		totalSizeText : "总共 {} 条",
		isShowFL : true,
		isShowSkip : true,
		isResetPage : false,
		isShowRefresh : false,
		isShowTotalPage : true,
		isShowTotalSize : true,
		isShowPageSizeOpt : false,
		callBack : function(currPage, pageSize) {
			$.ajax({
				type : "post",
				url : "selectAllShellPark",
				data : {
					"pageNum" :currPage,
					"pageSize" :5
				},
				dataType : 'json',
				success : function(data) {
					console.log(data.data.allSellCar);
					//display(data.data.allSellCar.pageData);
				}
			});
		}
	});
}
/* 确认通过 */
function member_change(title, url, w, h) {
	layer_show(title, url, w, h);
}