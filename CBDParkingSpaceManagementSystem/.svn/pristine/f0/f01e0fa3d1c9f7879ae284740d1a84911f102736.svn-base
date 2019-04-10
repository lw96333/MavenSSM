$(function() {
	
	$.ajax({
		type : "post",
		url : "showMyParkingSpaceInfo",
		data : {
			"pageNum" : 1,
			"userId" : $("#userId").val()
		},
		dataType : 'json',
		success : function(data) {
			if(data.code == 200) {
				var totalData = data.data.pageInfo.totalData;
				var totalNum = data.data.pageInfo.totalNum;
				tableData(data);
				pageJs(totalData, totalNum, 5);
			} else {
				layer.msg('暂无数据!', {
					icon : 1,
					time : 1000
				});
			}
			
		}
	});
	$("#tbody").on("click",".ml-change",function(){
		member_change('查看预定人信息','jsp/fortend/personal/ViewReservationInformation.jsp?id='+$(this).attr("id"),'500','450');
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
				url : "showMyParkingSpaceInfo",
				data : {
					"pageNum" : currPage,
					"userId" : $("#userId").val()
				},
				dataType : 'json',
				success : function(data) {
					tableData(data);
				}
			});
		}
	});
}
function tableData(data) {
	var pageInfo = data.data.pageInfo.pageData;
	var str = "";
	if (pageInfo.length == 0) {
		layer.msg('暂无出租车位', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var i = 0; i < pageInfo.length; i++) {
			if (pageInfo[i].userid == 0) {
				str += "<tr  class='text-c'>";
				str += "<td>" + pageInfo[i].equitiesid + "</td>";
				str += "<td>" + pageInfo[i].area + "</td>";
				str += "<td>" + pageInfo[i].startime + "</td>";
				str += "<td>" + pageInfo[i].endtime + "</td>";
				str += "<td></td>";
				str += "<td class='td-manage'>等待出租</td>";
			} else {
				str += "<tr  class='text-c'>";
				str += "<td>" + pageInfo[i].equitiesid + "</td>";
				str += "<td>" + pageInfo[i].area + "</td>";
				str += "<td>" + pageInfo[i].startime + "</td>";
				str += "<td>" + pageInfo[i].endtime + "</td>";
				str += "<td>" + pageInfo[i].message + "</td>";
				str += "<td class='td-manage'> <a title='查看预定人'href='javascript:;' id='"+pageInfo[i].privatecarsid +"'";
	    		str += "class='ml-change' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a> </td> ";
			}
		}
	}

	$("#tbody").html(str);
}
/* 确认通过 */
function member_change(title, url, w, h) {
	layer_show(title, url, w, h);
}