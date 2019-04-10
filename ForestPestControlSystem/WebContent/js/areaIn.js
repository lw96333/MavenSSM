var chonseId = 0;
function tableData(data) {
	var str = "<tr class='info'><th>区域名称</th><th>林种</th><th>地类</th><th>优势树种</th><th>负责小班</th></tr>";
	for (var i = 0; i < data.pageData.length; i++) {
		str += "<tr>";
		str += "<td id='name' value='" + data.pageData[i].areaId + "'>"
				+ data.pageData[i].name + "</td>";
		str += "<td>" + data.pageData[i].forest + "</td>";
		str += "<td>" + data.pageData[i].linDi.name + "</td>";
		str += "<td>" + data.pageData[i].advantage + "</td>";
		str += "<td>" + data.pageData[i].small.name + "</td>";
		str += "</tr>";
	}
	$(".table").html(str);
}
function ajaxData(currPage, pageSize) {
	$.ajax({
		type : "post",
		url : "areaInPage",
		data : {
			"currPage" : currPage,
			"pageSize" : pageSize,
			"forest" : $('#forest').val(),
			"areaName" : $('#areaName').val()
		},
		dataType : 'json',
		success : function(data) {
			tableData(data);
		}
	});
}
$(function() {
	var totalSize =$("input[name=totalData]").val();
	var totalPage = $("input[name=totalNum]").val();
	var showPageNum = $("input[name=pageSize]").val();
	pageJs(totalSize,totalPage,showPageNum);
	$("#queryArea").click(function() {
		var name = $('#areaName').val();
		var forest = $('#forest').val();
		$.ajax({
			type : "post",
			url : "areaInPage",
			data : {
				"currPage" : 1,
				"pageSize" :  $("input[name=pageSize]").val(),
				"forest" : forest,
				"areaName" : name
			},
			dataType : 'json',
			success : function(data) {
				if( data.pageData.length > 0){
					
					pageJs(data.totalData, data.totalNum,data.pageSize);
					tableData(data);
				}else{
					var str = "<h3 style='text-align: center;'>没有找到查询的数据</h3>";
					$(".table").html(str);
					pageJs(0,0,0);
				}
			}
		});
	});
	
	$("#addArea").click(function() {
		$(location).prop('href', "jsp/add_area.jsp?");
	});
	
});
function pageJs(totalSize,totalPage,showPageNum){
	$("#pagination_2").whjPaging({
		css : 'css-2',
		totalSize :totalSize,
		totalPage : totalPage,
		showPageNum : showPageNum,
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
			ajaxData(currPage, 5);
		}
	});
}

