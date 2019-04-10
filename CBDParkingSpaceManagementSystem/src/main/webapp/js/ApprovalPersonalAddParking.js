$(function() {
	ajax(1);
});
/* 确认通过 */
function ajax(pageNum) {
	$.ajax({
		type : "post",
		url : "showPersonalAddedParkingInfo",
		data : {
			"pageNum" : 1
		},
		dataType : 'json',
		success : function(data) {
			var totalData = data.data.parkingInfo.totalData;
			var totalNum = data.data.parkingInfo.totalNum;
			tableData(data);
			pageJs(totalData, totalNum, 5);
		}
	});
}
function change_password(obj, id, pageNum) {
	layer.confirm('确认通过吗？', function(index) {
		$.ajax({
			type : 'POST',
			url : 'auditPassPerson',
			dataType : 'json',
			data : {
				"privatecarsid" : id,
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('已通过!', {
						icon : 1,
						time : 1000
					});
					ajax(pageNum);
				} else {
					layer.msg('失败!', {
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
}
/* 用户-删除 */
function member_del(obj, id, pageNum) {
	layer.confirm('确认不通过吗？', function(index) {
		$.ajax({
			type : 'POST',
			url : 'auditFailedPerson',
			dataType : 'json',
			data : {
				"privatecarsid" : id,
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('已驳回!', {
						icon : 1,
						time : 1000
					});
					ajax(pageNum);
				} else {
					layer.msg('失败!', {
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
				url : "showPersonalAddedParkingInfo",
				data : {
					"pageNum" : currPage
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
	var pageInfo = data.data.parkingInfo.pageData;
	var str = "";
	if(pageInfo.length == 0) {
		layer.msg('暂无数据!', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var i = 0; i < pageInfo.length; i++) {
			str += "<tr  class='text-c'>";
			str += "<td>" + pageInfo[i].equitiesid + "</td>";
			str += "<td>" + pageInfo[i].area + "</td>";
			str += "<td>" + pageInfo[i].name + "</td>";
			str += "<td>" + pageInfo[i].realname + "</td>";
			str += "<td>" + pageInfo[i].identitynumber + "</td>";
			str += "<td>" + pageInfo[i].phone + "</td>";
			str += "<td class='td-manage'>  " + "<a style='text-decoration:none' "
					+ "onclick='change_password(this," + pageInfo[i].privatecarsid
					+","+ data.data.parkingInfo.pageNum + ")' "
					+ "class='ml-5' href='javascript:;' title='通过'>"
					+ "<i class='Hui-iconfont'>&#xe6e1;</i>"
					+ "</a> <a title='不通过' href='javascript:;'"
					+ " onclick='member_del(this," + pageInfo[i].privatecarsid
					+","+ data.data.parkingInfo.pageNum + ")' "
					+ "class='ml-5' style='text-decoration:none'>"
					+ "<i class='Hui-iconfont'>&#xe6dd;</i></a></td>";
			str += "</tr>";
		}
	}
	
	$("#tbody").html(str);
}