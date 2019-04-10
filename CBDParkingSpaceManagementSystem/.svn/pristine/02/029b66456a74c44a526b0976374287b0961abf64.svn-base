$(function(){
        
    	$.ajax({
            type:"post",
            url:"showCbdLeisureCarport",
            data:{
                "pageNum":1,
                "pageSize":5
            },
            dataType:"json",
            success:function(data){
            	
                if (data.data.page.records == "") {
                    layer.msg('未查到数据',{icon:1,time:1000});
                }else {
                    display(data.data);
                    pageJs(data.data.page.total,data.data.page.pages,data.data.page.size);
                }
                
            }
        }); 

    });
    
    function display(data){
        var str = "";
        var cbdPages = data.page.records;
        
        for(var index = 0;index < cbdPages.length; index++){
            str += "<tr class='text-c'>";
            str += "<td>"+ cbdPages[index].address+ "</td>";
            str += "<td>"+ cbdPages[index].areanumber+"</td>";
            str += "<td>"+ cbdPages[index].sizetime +"</td>";
            str += "</tr>";
        }
        
        $("#show").html(str);
    }
    
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
   
    
    function pageJs(totalSize,totalPage,showPageNum){
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
            callBack: function (currPage,pageSize) {
                $.ajax({
                    type:"post",
                    url:"showCbdLeisureCarport",
                    data:{
                        "pageNum":currPage,
                        "pageSize":5
                    },
                    dataType : 'json',
                    success:function(data){

                    	display(data.data)
                    }
                });
            }
        });
    }