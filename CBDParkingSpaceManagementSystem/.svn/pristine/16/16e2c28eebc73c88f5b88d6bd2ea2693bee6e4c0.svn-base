$(function() {
	ajax(1);
});
/* 确认通过 */
function ajax(pageNum) {
	$.ajax({
		type : "post",
		url : "showInfo",
		data : {
			"pageNum" : 1
		},
		dataType : 'json',
		success : function(data) {
			//console.log(data);
			var totalData = data.data.parkingInfo.totalData;
			var totalNum = data.data.parkingInfo.totalNum;
			tableData(data);
			pageJs(totalData, totalNum, 5);
		}
	});
}
function change_password(obj, id, privatecarsid,purchaseUserid,sellUserid,pageNum) {
	layer.confirm('确认通过吗？', function(index) {
		$.ajax({
			type : 'POST',
			url : 'auditPass',
			dataType : 'json',
			data : {
				"purchasecarsid" : id,
				"privatecarsid" : privatecarsid
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('已通过!', {
						icon : 1,
						time : 1000
					});
					ajax(pageNum);
					//推送消息
					 $.ajax({
							type : "post",
							url : "ContractPush",
							data : {
							"guserid" :purchaseUserid,
							"cuserid":sellUserid
							}
						}); 
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
function member_del(obj, id,privatecarsid,sellUserId,purchaseUserid, pageNum) {
	layer.confirm('确认不通过吗？', function(index) {
		$.ajax({
			type : 'POST',
			url : 'auditFailed',
			dataType : 'json',
			data : {
				"purchasecarsid" : id,
				"privatecarsid" : privatecarsid
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('已驳回!', {
						icon : 1,
						time : 1000
					});
					$.ajax({
						type : 'POST',
						url : 'noContractPush',
						dataType : 'json',
						data : {
								"guserid" : sellUserId,
								"cuserid" : purchaseUserid
						}
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
				url : "showInfo",
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
	if (pageInfo.length == 0) {
		layer.msg('暂无数据!', {
			icon : 1,
			time : 1000
		});
	} else {
		for (var i = 0; i < pageInfo.length; i++) {
			console.log(pageInfo[i]);
			str += "<tr  class='text-c'>";
			str += "<td>" + pageInfo[i].equitiesid + "</td>";
			str += "<td>" + pageInfo[i].area + "</td>";
			str += "<td>" + pageInfo[i].purchaseRealname + "</td>";
			str += "<td>" + pageInfo[i].purchasePhone + "</td>";
			str += "<td>" + pageInfo[i].realname + "</td>";
			str += "<td>" + pageInfo[i].phone + "</td>";
			str += "<td>" + pageInfo[i].identitynumber + "</td>";
			str += "<td class='td-manage'>  "
					+ "<a style='text-decoration:none' "
					+ "onclick='change_password(this,"
					+ pageInfo[i].purchasecarsid + ","
					+ pageInfo[i].privatecarsid + ","
					+ pageInfo[i].purchaseUserid + ","
					+ pageInfo[i].sellUserid + ","
					+ data.data.parkingInfo.pageNum + ")' "
					+ "class='ml-5' href='javascript:;' title='通过'>"
					+ "<i class='Hui-iconfont'>&#xe6e1;</i>"
					+ "</a> <a title='删除' href='javascript:;'"
					+ " onclick='member_del(this," 
					+ pageInfo[i].purchasecarsid + ","
					+ pageInfo[i].privatecarsid  + ","
					+ pageInfo[i].sellUserid + ","
					+ pageInfo[i].purchaseUserid + ","
					+ data.data.parkingInfo.pageNum + ")' "
					+ "class='ml-5' style='text-decoration:none'>"
					+ "<i class='Hui-iconfont'>&#xe6dd;</i></a></td>";
			str += "</tr>";
		}
	}

	$("#tbody").html(str);
}