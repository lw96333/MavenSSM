var chonseId = 0;
$(function() {
	var totalSize =$("input[name=totalData]").val();
	var totalPage = $("input[name=totalNum]").val();
	var showPageNum = $("input[name=pageSize]").val();
	pageJs(parseInt(totalSize),parseInt(totalPage),parseInt(showPageNum));
	chonse();
	function pageAjax(data) {
			var str = "<tr class='info'><th>事件名称</th> <th>日期</th><th>发生位置</th><th>防治方案</th><th>灾情状态</th></tr>";
			for (var i = 0; i < data.pageData.length; i++) {
				var time = new Date(data.pageData[i].time);
				str += "<tr>";
				str += "<td id='name' value='" + data.pageData[i].id + "'>"
						+ data.pageData[i].eventName + "</td>";
				str += "<td>" + time.toLocaleDateString() + "</td>";
				str += "<td>" + data.pageData[i].area.name + "</td>";
				str += "<td>" + data.pageData[i].controlMethod + "</td>";
				str += "<td>" + data.pageData[i].stage.typeName + "</td>";
				str += "</tr>";
			}
			$(".table").html(str);
	}
	
	function ajax(currPage, pageSize) {
		$.ajax({
			type : "post",
			url : "incidentPage",
			data : {
				"currPage" : currPage,
				"pageSize" : pageSize,
				"incidentName" : $('#incidentName').val(),
				"areaName" : $('#areaName').val(),
				"disasterStageType" : $('#stage option:selected').val()
			},
			dataType : 'json',
			success : function(data) {
				pageAjax(data);
			}
		});
	}
	
	$("#checkIncident").click(function() {
		if (chonseId == undefined || chonseId == 0) {
			alert("请选择要查看的事件");
		} else {
			var form = $("<form action='checkIncident' method='post'></form>");
			var input = $("<input type='hidden' name='incidentId'>");
			input.val(chonseId);
			form.append(input);
			form.appendTo(document.body);
			form.submit();
		}
	});

	$("#updateIncident").click(
			function() {
				$("#name").click(function() {
					chonseId = $(this).attr("value");
				});
				if (chonseId == undefined) {
					alert("请选择要修改的事件");
				} else {
					$(location).prop('href',"showUpdataIncident?chonseId=" + chonseId);
				}
			});
	$("#applyFor").click(function() {
		$("#name").click(function() {
			chonseId = $(this).attr("value");
		});
		if (chonseId == undefined || chonseId == 0) {
			alert("请选择要申请的事件");
		} else {

			$(location).prop('href', "applyFor?chonseId=" + chonseId);
		}
	});
	$("#queryIncident").click(function() {
			$.ajax({
				type : "post",
				url : "incidentPage",
				data : {
					"currPage" : 1,
					"pageSize" : $("input[name=pageSize]").val(),
					"incidentName" : $('#incidentName').val(),
					"areaName" : $('#areaName').val(),
					"disasterStageType" :  $('#stage option:selected').val()
				},
				dataType : 'json',
				success : function(data) {
					if( data.pageData.length > 0){
						pageJs( data.totalData,data.totalNum,data.pageSize);
						pageAjax(data);
					}else{
						var str = "<h3 style='text-align: center;'>没有找到查询的数据</h3>";
						$(".table").html(str);
						pageJs(0,0,0);
					}
				}
			});
			 chonse();
	});
	
	function pageJs(totalSize,totalPage,showPageNum){
		$("#pagination_2").whjPaging({
			css : 'css-2',
			totalSize :totalSize,
			totalPage : totalPage,
			showPageNum :showPageNum,
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
				ajax(currPage, 5);
			}
		});
		
	}
});

function chonse() {

	$(".table").on("click","tr",function() {
		$(".table tr").css({
			background : "white"
		});
		$(this).css({
			background : "#D8ECF7"
		});
		chonseId = $(this).first().find("#name").attr("value");
	});
}