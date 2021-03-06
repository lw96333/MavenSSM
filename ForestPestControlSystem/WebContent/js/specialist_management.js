var chonseId = 0;
var falg = false;
var queryNameLog;
var queryExpertiseLog;
var queryWorkUnitLog;
function tableAjax(data){
	var str = "";
	for(var i=0;i<data.pageData.length;i++){
		str += "<tr>";
		str += "<td><input type='checkbox' name='chonse'/></td>";
		str += "<td id='name' value='"+data.pageData[i].id+"'>"+data.pageData[i].name+"</td>";
		str += "<td>"+data.pageData[i].workUnit+"</td>"
		str += "<td>"+data.pageData[i].expertise+"</td>"
		str += "<td>"+data.pageData[i].post+"</td>"
		str += "<td>"+data.pageData[i].phone+"</td>"
		str += "</tr>";
	}
	$(".tbody").html(str);
}
function page(currPage,pageSize) { 
	var queryName;
	var queryExpertise;
	var queryWorkUnit;
	if(queryNameLog == "" || queryNameLog == null){
		queryName = "";
	}else{
		queryName = queryNameLog;
	}
	if(queryExpertiseLog == "" || queryExpertiseLog == null){
		queryExpertise = "";
	}else{
		queryExpertise = queryExpertiseLog;
	}
	if(queryWorkUnitLog == "" || queryWorkUnitLog == null){
		queryWorkUnit = "";
	}else{
		queryWorkUnit = queryWorkUnitLog;
	}
	
	$.ajax({
    	type:"post",
    	url:"specialistPage",
    	data:{
    		"currPage":currPage,
    		"pageSize":$("input[name=pageSize]").val(),
    		"queryName":queryName,
    		"queryExpertise":queryExpertise,
    		"queryWorkUnit":queryWorkUnit,
    		"falg":""
    	},
    	dataType : 'json',
    	success:function(data){
    		tableAjax(data);
    		
    	}
    });
}
$(function(){
	$("#company").click(function(){
		
		$(location).prop("href","company");
	});
	var add = $("input[name=add]").val();
	if(add=="ok"){
		$("#modal_message").html("添加成功！");
		showModal();
		$("input[name=add]").val("");
	}
	var totalSize = $("input[name=totalData]").val();
    var totalPage = $("input[name=totalNum]").val();
    var showPageNum = $("input[name=pageSize]").val();
	pageJs(parseInt(totalSize),parseInt(totalPage),parseInt(showPageNum));
	$("input[name=Allchonse]").click(function(){
		$(".tbody").find("input").each(function(){
			$(this).prop("checked",$("input[name=Allchonse]").prop("checked"));
			if($(this).prop("checked")){
				$(this).parent().parent().css({
					background: "#D8ECF7"
				});
			}else{
				$(this).parent().parent().css({
					background: "white"
				});
			}
		});
	});
	$("#query").click(function(){

		 queryNameLog = $("#queryName").val();
		 queryExpertiseLog = $("#queryExpertise").val();
		 queryWorkUnitLog = $("#queryWorkUnit").val();
		$.ajax({
        	type:"post",
        	url:"specialistPage",
        	data:{
        		"currPage":1,
        		"pageSize":$("input[name=pageSize]").val(),
        		"queryName":queryNameLog,
        		"queryExpertise":queryExpertiseLog,
        		"queryWorkUnit":queryWorkUnitLog,
        		"falg":"true"
        	},
        	dataType : 'json',
        	success:function(data){
        		falg= true;
        		tableAjax(data);
        		pageJs(parseInt(data.totalData),parseInt(data.totalNum),parseInt(data.pageSize));
        		      
        	}
        });
	});
	$("#addPerson").click(function(){
		$(location).prop('href',"jsp/addspecialist.jsp");
	});
	$("#updatePerson").click(function(){
		var num = 0;
		var chonseId = "";
		$(".tbody").find("input").each(function(){
			if($(this).prop("checked")){
				num++;
				chonseId = $(this).parent().next().attr("value")+",";
			}
		});
		if(num == 0){
			alert("请选择要修改的数据");
		}else if(num > 1){
			alert("每次只能修改一条数据");
		}else if(num == 1){
			chonseId = chonseId.replace(",","");
			var form = $("<form action='specialistcheckandupdate' method='post'></form>");
			var input = $("<input type='hidden' name='chonseId'>");
			input.val(chonseId);
			form.append(input);
			form.appendTo(document.body);
			form.submit();	
			
		}
	});
	$("#checkPerson").click(function(){
		
		var num = 0;
		var chonseId = "";
		$(".tbody").find("input").each(function(){
			if($(this).prop("checked")){
				num++;
				chonseId = $(this).parent().next().attr("value")+",";
			}
		});
		if(num == 0){
			alert("请选择要查看的数据");
		}else if(num > 1){
			alert("每次只能查看一条数据");
		}else if(num == 1){
			chonseId = chonseId.replace(",","");
			var form = $("<form action='specialistcheck' method='post'></form>");
			var input = $("<input type='hidden' name='chonseId'>");
			input.val(chonseId);
			form.append(input);
			form.appendTo(document.body);
			form.submit();			
		}
	});
	$("#deletePerson").click(function(){
		var num = 0;
		var chonseId = "";
		$(".tbody").find("input").each(function(){
			if($(this).prop("checked")){
				num++;
				chonseId += $(this).parent().next().attr("value")+",";
			}
		});
		if(num == 0){
			alert("请选择要删除数据");
		}else{
			if(confirm("确定删除吗")){
				$.ajax({
                	type:"post",
                	url:"specialistDelete",
                	data:{
                		"currPage":1,
                		"pageSize":$("input[name=pageSize]").val(),
                		'chonseId':chonseId
                	},
                	dataType : 'json',
                	success:function(data){
                		console.log(data);
                		tableAjax(data);
                		pageJs(parseInt(data.totalData),parseInt(data.totalNum),parseInt(data.pageSize));
                		$("#modal_message").html("删除成功！");
                		showModal();
                		$("input[name=Allchonse]").prop("checked",false);
                	}
                });
				return true;
			}
		}
		return false;
	});
	chonse();
});
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
            	url:"diseasesList_managementPage",
            	data:{
            		"currPage":currPage,
            		"pageSize":5,
            	},
            	dataType : 'json',
            	success:function(data){
            		
            		page(currPage,pageSize);
            	}
            });
        }
    });
}
function chonse(){
	
	$(".tbody").on("click",function(){
		var num = 0;
		$(this).find("input").each(function(i){
			if($(this).prop("checked")){
				num = num + 1;
				$(this).parent().parent().css({
					background: "#D8ECF7"
				});
			}else{
				$(this).parent().parent().css({
					background: "white"
				});
				
			}
		});
		if(num == 5){
			$("input[name=Allchonse]").prop("checked",true);
			
		}else{
			$("input[name=Allchonse]").prop("checked",false);
			
		}
	});
}

var clearFlag = 0;
var count = 1;//设置3秒后自动消失
var showModal = function(){
    $("#my-modal-alert").toggle();//显示模态框

    $("#my-modal-alert").draggable({//设置模态框可拖动（需要引入jquery-ui.min.js）
        handle: ".modal-header"
    });

    clearFlag = self.setInterval("autoClose()",1000);//每过一秒调用一次autoClose方法
}

var autoClose = function(){
    if(count>0){
        $("#num").html(count + "秒后窗口将自动关闭");
        count--;
    }else if(count<=0){
        window.clearInterval(clearFlag);
        $("#num").html("");
        $("#my-modal-alert").fadeOut("slow");
        count = 3;
        $("#my-modal-alert").toggle();
    }
}