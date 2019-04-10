$(function() {
	var userId =  $("#userId").val();
	ajax(1, userId);
	$("#tbody").on("click", ".ml-delete", function() {
		var id = $(this).attr("id");
		var pageNum = $(this).attr("pageNum");
		layer.confirm('取消预约？', function(index) {
			$.ajax({
				type : 'POST',
				url : 'deleteDeal',
				data : {
					"dealId" : id
				},
				dataType : 'json',
				success : function(data) {
					if (data.code == 200) {
						layer.msg('成功取消!', {
							icon : 1,
							time : 1000
						});
						ajax(pageNum, userId);
					} else {
						layer.msg('好像出了点问题!', {
							icon : 1,
							time : 1000
						});
					}

				},
				error : function(data) {
					console.log(data.msg);
				}
			});
		});
	});
});
function ajax(pageNum, userId) {
	$.ajax({
		type : "post",
		url : "showUserRentalInfo",
		data : {
			"pageNum" : pageNum,
			"userId" : userId
		},
		dataType : 'json',
		success : function(data) {
			if (data.code == 200) {
				var totalData = data.data.pageInfo.totalData;
				var totalNum = data.data.pageInfo.totalNum;
				tableData(data);
				pageJs(totalData, totalNum, 5);
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
				url : "showUserRentalInfo",
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
	var herf = "查看预定人信息";
	if (pageInfo.length == 0) {
		layer.msg('暂无预定车位', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var i = 0; i < pageInfo.length; i++) {
			str += "<tr  class='text-c'>";
			str += "<td>" + pageInfo[i].equitiesid + "</td>";
			str += "<td>" + pageInfo[i].area + "</td>";
			str += "<td>" + pageInfo[i].startime + "</td>";
			str += "<td>" + pageInfo[i].endtime + "</td>";
			str += "<td>" + pageInfo[i].name + "</td>";
			str += "<td class='td-manage'>等待对方同意 <a title='取消预约' href='javascript:;' pageNum='"
					+ data.data.pageInfo.pageNum
					+ "' id='"
					+ pageInfo[i].privatecarsid + "'";
			str += "class='ml-delete' style='text-decoration: none'><i class='Hui-iconfont'>&#xe6dd;</i></a> </td> ";
		}
	}

	$("#tbody").html(str);
}