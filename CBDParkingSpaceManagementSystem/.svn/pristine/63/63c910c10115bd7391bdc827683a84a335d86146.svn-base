$(function() {
	
	queryAllParkingInfo(1, $("#logmin").val(), $("#logmax").val());
	$("#tbody").on(
			"click",
			".ml-change",
			function() {
				layer.msg('请您注册登录后即可查看详细信息', {icon : 1,time : 1000});
				/*member_change('查看车位信息',
						'jsp/fortend/personal/ParkingInfo.jsp?id='
								+ $(this).attr("id"), '500', '450');*/
			});

});

function queryAllParkingInfo(pageNum, stateTime, endTime){
	$.ajax({
		type : "post",
		url : "showAllParkingInfo",
		data : {
			"pageNum" : pageNum,
			"stateTime" :stateTime,
			"endTime" :endTime
		},
		dataType : 'json',
		success : function(data) {
			if (data.code == 200) {
				var totalData = data.data.pageInfo.totalData;
				var totalNum = data.data.pageInfo.totalNum;
				tableData(data);
				pageJs(totalData, totalNum, 8);
			} else {
				layer.msg('暂无出租车位!', {
					icon : 1,
					time : 1000
				});
			}

		}
	});
}

$("#query").click(function() {
	queryAllParkingInfo(1, $("#logmin").val(), $("#logmax").val());
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
				url : "showAllParkingInfo",
				data : {
					"pageNum" : currPage,
					"stateTime" :$("#logmin").val(),
					"endTime" :$("#logmax").val()
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
		layer.msg('暂无发布出租车位', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var i = 0; i < pageInfo.length; i++) {
			str += "<li class=' col-sm-3 '>";
			str += "<img src='images/timg.jpeg' style='width: 270px;height: 200px;' />";
			str += "<h3>车位 地址</h3>";
			str += "<p>" + pageInfo[i].area + pageInfo[i].areaid + "</p>";
			str += "<td class='td-manage'> <a title='查看车位信息'href='javascript:;' id='"
					+ pageInfo[i].privatecarsid + "'";
			str += "class='ml-change' style='text-decoration: none'><i class='Hui-iconfont' style='color: red;'>查看详情</i></a> </td> ";
		}
	}

	$("#tbody").html(str);
}
/* 确认通过 */
function member_change(title, url, w, h) {
	layer_show(title, url, w, h);
}