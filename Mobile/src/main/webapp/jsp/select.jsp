<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<html>
<base href=<%=basePath %>/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-table.min.css">
	<!--按照下面顺序引用jquery必须先引用 -->
	 
<body>
	<table id="bootstarp" class="table table-hover">
					
	</table>

	<a href="javascript:void(0)" id="down">下载当前页数据</a>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.min.js"></script>
    <script src="js/bootstrap-table-zh-CN.min.js"></script>
<script>
$(function () {
	var pageNum = -1;
	var pageSize = -1;
	$("#down").click(function(){

		 $("body")
		 .append("<form action='down' method='post'><input type='hidden' name='pageNum' value="+pageNum+"><input type='hidden' name='pageSize' value="+pageSize+"></form>");
		$("form").submit();
	});

	/*alert("进来了")*/
    $('#bootstarp').bootstrapTable({
        url: 'selectAllMobile',         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        contentType: "application/x-www-form-urlencoded",//post请求的话就加上这个句话
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: false,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
       // queryParams: oTableInit.queryParams,//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 20],        //可供选择的每页的行数（*）
        //search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
			console.log(params);
            return {
                pageSize: params.limit, // 每页要显示的数据条数 （params.limit）不可变表示开始数据位置 size可以变 对应后台的取值
                pageNum: params.offset, // 每页显示数据的开始行号 （params.offset）不可变表示结束数据位置 cur可以变 对应后台的取值
                
                //上面两个参数后端分页不能少
                //可以加自己的参数
            }
        },
        responseHandler: function(data) {//请求得到参数处理 res是服务器返回的参数 （可以取任何变量名（和AJAX一样））
           console.log(data);
           /* alert("回来了哦")*/
           pageNum = data.data.page.current;
           pageSize = data.data.page.size;
            return {
                "total": data.data.page.total,//总条数 （"total"）不能变 插件特定解析字段 后面的值可根据实际情况做变化
                "rows": data.data.page.records //数据  （"rows"）不能变 插件特定解析字段 后面的值可根据实际情况做变化
               
            };
        },
        columns: [ {                            // table所要显示的列
        	checkbox: true
        }, {
            field: 'pre', //对象属性字段 与java对象类中字段一致
            title: '手机号码',
            align: 'center'
        }, {
            field: 'provice',
            title: '所在省',
            align: 'center'
        }, {
            field: 'city',
            title: '所在市',
            align: 'center'
        }, {
            field: 'code',
            title: '地区编号',
            align: 'center'

        },{
            field: 'postcode',
            title: '邮编',
            align: 'center'

        },{
            field: 'operators',
            title: '所属运营商',
            align: 'center',
           
        }]
    });


    function addFunctionAlty(value, row, index) {
        return [
      	"<button id='info' type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#myModal'>查看</button>"
        ].join('');
        
    }

 
    
    })

</script>
</html>