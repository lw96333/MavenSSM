$(function(){
		$("#tbody").on("click",".ml-complaint",function(){
			member_edit('投诉','jsp/fortend/personal/ComplaintInfo.jsp?id=' +$(this).attr("id") ,'350','250');
		});
		
		ajax(1,$("#userId").val())
	})
	
	function member_edit(title,url,w,h){
		layer_show(title,url,w,h);
	}
    
    function ajax(pageNum,userId){
		$.ajax({
			type : "post",
			url : "showHistoricalLeaseParking",
			data : {
				"pageNum" : pageNum,
				"userId" : userId
				
			},
			dataType : "json",
			success : function(data){
				if(data.code == 200){
					var totalData = data.data.pageInfo.totalData;
					var totalNum = data.data.pageInfo.totalNum;
					tableData(data);
					pageJs(totalData,totalNum,5);
				}
					console.log(data)
			}
		});	
	}
    
    
    function pageJs(totalSize, totalPage, showPageNum) {
        $("#pagination_2").whjPaging({
            css: 'css-2',
            totalSize: totalSize,
            totalPage: totalPage,
            showPageNum: 3,
            firstPage: '首页',
            previousPage: '上一页',
            nextPage: '下一页',
            lastPage: '尾页',
            skip: '',
            confirm: '跳转',
            refresh: '刷新',
            totalPageText: '总共 {} 页',
            totalSizeText: "总共 {} 条",
            isShowFL: true,
            isShowSkip: true,
            isResetPage: false,
            isShowRefresh: false,
            isShowTotalPage: true,
            isShowTotalSize: true,
            isShowPageSizeOpt: false,
            callBack: function (currPage, pageSize) {
                $.ajax({
                    type: "post",
                    url: "showHistoricalLeaseParking",
                    data: {
                        "pageNum": currPage,
                        "userId": $("#userid").val
                    },
                    dataType: 'json',
                    success: function (data) {
                    	tableData(data);
                    }
                });
            }
        });
    }
    
    function tableData(data){
    	var pageInfo = data.data.pageInfo.pageData;
    	var str = "";
		if(pageInfo.length == 0){
			layer.msg('暂无信息', {
				icon : 1,
				time : 1000
			});
		}else {
			for (var i = 0;i <pageInfo.length; i++){
				str += "<tr class='text-c'>";
				str += "<td>" + pageInfo[i].equitiesid + "</td>";
				str += "<td>" + pageInfo[i].area + "</td>";
				str += "<td>" + pageInfo[i].startime + "</td>";
				str += "<td>" + pageInfo[i].endtime + "</td>";
				str += "<td>" + pageInfo[i].realname + "</td>";
				str += "<td>" + pageInfo[i].phone + "</td>";
				str += "<td class='td-manage'> <a title='投诉' href='javascript:;' pageNum='"
					+ data.data.pageInfo.pageNum
					+ "' id='"
					+ pageInfo[i].userid + "'";
				str += "class='ml-complaint' style='text-decoration: none'><i class='Hui-iconfont'>&#xe66e;</i></a> </td> ";
				
			}
		}
		$("#tbody").html(str);
    }