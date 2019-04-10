var chonseId = 0;
function tableData(data) {
	var str = "<tr class='info'><th>小班名称</th> <th>负责人</th><th>负责人电话</th><th>负责区域</th></tr>";
	for (var i = 0; i < data.pageData.length; i++) {
		str += "<tr>";
		str += "<td id='name' value='" + data.pageData[i].id + "'>"
				+ data.pageData[i].name + "</td>";
		str += "<td>" + data.pageData[i].personName + "</td>";
		str += "<td>" + data.pageData[i].personPhone + "</td>";
		str += "<td>" + data.pageData[i].areaIn.name + "</td>";
		str += "</tr>";
	}
	chonse();
	$(".table").html(str);
}
function ajaxData(currPage, pageSize) {
	$.ajax({
		type : "post",
		url : "smallClassPage",
		data : {
			"currPage" : currPage,
			"pageSize" : pageSize,
			"smallClassName" : $('#smallClassName').val(),
			"areaIn" : $('#areaIn').val()
		},
		dataType : 'json',
		success : function(data) {
			tableData(data)
		}
	});
}
$(function() {
	var totalSize = $("input[name=totalData]").val();
	var totalPage = $("input[name=totalNum]").val();
	var showPageNum = $("input[name=pageSize]").val();
	pageJs(totalSize, totalPage, showPageNum);
	chonse();
	$("#showUpdataSmallClass")
			.click(
					function() {
						$("#name").click(function() {
							chonseId = $(this).attr("value");
						});
						if (chonseId == 0 || chonseId == undefined) {
							alert("请选择要修改的小班");
						} else {
							var form = $("<form action='showUpdataSmallClass' method='post'></form>");
							var input = $("<input type='hidden' name='smallClassId'>");
							input.val(chonseId);
							form.append(input);
							form.appendTo(document.body);
							form.submit();
						}
					});
	$("#showSmallClass")
			.click(
					function() {
						if (chonseId == 0 || chonseId == undefined) {
							alert("请选择要查看的小班");
						} else {
							var form = $("<form action='Check_Small_Class_Information' method='post'></form>");
							var input = $("<input type='hidden' name='smallClassId'>");
							input.val(chonseId);
							form.append(input);
							form.appendTo(document.body);
							form.submit();
						}
					});
	$("#querySmallClass").click(function() {
		var smallClassName = $('#smallClassName').val();
		var areaName = $('#areaName').val();
		$.ajax({
			type : "post",
			url : "smallClassPage",
			data : {
				"currPage" : 1,
				"pageSize" : $("input[name=pageSize]").val(),
				"smallClassName" : smallClassName,
				"areaName" : areaName
			},
			dataType : 'json',
			success : function(data) {
				if (data.pageData.length > 0) {

					pageJs(data.totalData, data.totalNum, data.pageSize);
					tableData(data);
				}else{
					var str = "<h3 style='text-align: center;'>没有找到的查询数据</h3>";
					$(".table").html(str);
					pageJs(0,0,0);
				}
			}
		});
	});

});
function pageJs(totalSize, totalPage, showPageNum) {
	$("#pagination_2").whjPaging({
		css : 'css-2',
		totalSize : totalSize,
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

function chonse() {

	$("#smallClassTable").on("click","tr", function() {
		$("#smallClassTable tr").css({
			background : "white"
		});
		$(this).css({
			background : "#D8ECF7"
		});
		chonseId = $(this).first().find("#name").attr("value");
	});
}