$(function() {
	queryAllParkingInfo(1, $("#select").val(),$("#logmin").val(), $("#logmax").val());
	$("#query").click(function() {
		queryAllParkingInfo(1, $("#select").val(),$("#logmin").val(), $("#logmax").val());
	});
});

function queryAllParkingInfo(curPage,permission ,stateTime, endTime){
	$.ajax({
		type : "post",
		url : "showLog",
		data : {
			"curPage" : curPage,
			"permission":permission,
			"stateTime" :stateTime,
			"endTime" :endTime
			
		},
		dataType : 'json',
		success : function(data) {
			if (data.code == 200) {
				var totalData = data.data.pageInfo.totalData;
				var totalNum = data.data.pageInfo.totalNum;
				tableData(data);
				pageJs(totalData, totalNum, 5);
			} else {
				layer.msg('暂无日志!', {
					icon : 1,
					time : 1000
				});
			}

		}
	});
}
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
				url : "showLog",
				data : {
					"curPage" : currPage,
					"stateTime" :$("#logmin").val(),
					"endTime" :$("#logmax").val(),
					"permission":$("#select").val()
				},
				dataType : 'json',
				success : function(data) {
					debugger;
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
		layer.msg('暂无日志!', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var index = 0; index < pageInfo.length; index++) {
    		str += "<tr class='text-c'>";
    		str += "<td>"+ pageInfo[index].name +"</td>";
    		str += "<td>"+ pageInfo[index].operatetime	 +"</td>";
    		str += "<td>"+ pageInfo[index].ip +"</td>";
    		str += "<td>"+ pageInfo[index].operatecontent +"</td>";
    		str += "<td>"+ pageInfo[index].rank +"</td>";
    		str += "<td>"+ pageInfo[index].operation +"</td>";
    		str += "</tr>";
		}
	}

	$("#bodyTr").html(str);
}