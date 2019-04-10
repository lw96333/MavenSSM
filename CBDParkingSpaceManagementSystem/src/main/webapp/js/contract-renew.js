	var inputfile;
    var fileListSize;
    function add(){
     
     var formData =  new FormData();
     var contractNO =  $("#contractNO").val();
     var newcontractNO = $("#newcontractNO").val();
     var datemin = $("#datemin").val();
     var datemax = $("#datemax").val();
     var linkman =$("#linkman").val();
     var price =$("#price").val();
     var personuser = $("#personuser").val();
     var flag = true;
     //成交价格
     $("#price").blur(function(){

			if($(this).val() == ""){
				$("#price").css("border","1px red solid");
				$("#price").attr("placeholder","成交价格不能为空！");
			}else{
				$("#price").css("border","1px #DCDCDC solid");
				$("#price").attr("placeholder","成交价格");
			}
		});
     //联系人
     $("#linkman").blur(function(){

			if($(this).val() == ""){
				$("#linkman").css("border","1px red solid");
				$("#linkman").attr("placeholder","联系人姓名不能为空！");
			}else{
				$("#linkman").css("border","1px #DCDCDC solid");
				$("#linkman").attr("placeholder","联系人姓名");
			}
		});
   //联系人电话
     $("#personuser").blur(function(){

			if($(this).val() == ""){
				$("#personuser").css("border","1px red solid");
				$("#personuser").attr("placeholder","联系人电话不能为空！");
			}else{
				$("#personuser").css("border","1px #DCDCDC solid");
				$("#personuser").attr("placeholder","联系人电话");
			}
		});
     
     if(personuser==""){
    	 $("#personuser").blur();
    	 flag = false;
     };
     if(price==""){
    	 $("#price").blur();
    	 flag = false;
     };
     if(!/^[1-9]\d+$/.test(price)){
    	 layer.msg('价格输入格式错误',{icon:1,time:1500});
			flag=false;
     };
     if(linkman==""){
    	 $("#linkman").blur();
    	 flag = false;
     }
     if(datemax==""){
    	 layer.msg('请选择合同失效日期!',{icon:1,time:1000});
    	 flag=false;
     }
     if(datemin==""){
    	 layer.msg('请选择合同生效日期!',{icon:1,time:1000});
    	 flag=false;
     }
     if(newcontractNO==""){
    	 layer.msg('合同编号未获取，请刷新页面',{icon:1,time:1000});
    	 flag=false;
     };
     if(datemin>datemax){
			layer.msg('合同生效日期不能小于合同失效日期!',{icon:1,time:1000});
			flag=false;
		};
     if(flag){
    	 formData.append("contract",$("#fileinput")[0].files[0]);  	  
 	   	formData.append("enterprisecontractid",$("#enterprisecontractid").val().trim());
 	   	formData.append("enterpriseid",$("#enterpriseid").val().trim());
 	   	formData.append("contractnumber",$("#contractNO").val().trim());
 	   	formData.append("newcontractnumber",$("#newcontractNO").val().trim());
 	   	formData.append("fromdate",$("#datemin").val().trim());
 	   	formData.append("deadline",$("#datemax").val().trim());
 	   	formData.append("contactperson",$("#linkman").val().trim());
 	   	formData.append("price",$("#price").val().trim());
 	   	formData.append("phone",$("#personuser").val().trim());
 	   	$.ajax({
     		type : "post",
     		url : "contractExtension",
     		cache: false,
     		data : formData,
     		async:false,
     		processData:false,
     		contentType:false,
     		dataType : "json",
     		success : function(data) {
     			debugger;
     			if(data.message=="ok"){
     				layer.msg('添加成功!',{icon:1,time:1000});
     				window.parent.location.reload();
     			}else{
     				layer.msg('添加失败!',{icon:1,time:1000});
     			}
     		}
     	});
     }
  };
  
  
$(function(){ 
	$("#button").click(function(){
		debugger;
        if(fileListSize>0){
        	add();
        }else{
        	layer.msg('请上传合同复印件!',{icon:1,time:1000});
        }
	});
	
	
	
	
	//验证文件大小
    inputfile = $('#fileinput').fileinput({

        //初始化上传文件框
        language: "zh",//配置语言
        showPreview: true,//是否显示预览
        showUpload: true, //显示整体上传的按钮
        showRemove: false,//显示整体删除的按钮
        uploadAsync: false,//默认异步上传
//        uploadLabel: "上传",//设置整体上传按钮的汉字
        removeLabel: "移除",//设置整体删除按钮的汉字
        uploadClass: "btn btn-primary",//设置上传按钮样式
        showCaption: true,//是否显示标题
        dropZoneEnabled: false,//是否显示拖拽区域
        showUpload: false,//是否显示上传按钮
//                uploadUrl: getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
        maxFileSize : 1024,//文件大小限制
        maxFileCount: 1,//允许最大上传数，可以多个，
        enctype: 'multipart/form-data',
        allowedFileExtensions : ["png","jpg"],/*上传文件格式限制 "gif","docx","zip","xlsx","txt"*/
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        showBrowse: true,
        browseOnZoneClick: true,
        initialCaption: "请选择上传图片",//输入提示
        slugCallback : function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    });
    
    $('#fileinput').on("filebatchselected", function(event, files,msg) {
    	            fileListSize = files.length;
    });
	
	
	
	//$(location).attr('href');
	var url = window.location.href;//项目里面这里用window.location.href;
	var  arr = url.split("id=");
	var id = arr[1];
	//alert(id);
		$.ajax({
            type: 'POST',
            url: 'getContractByid',
            data:{"id":id},
            dataType: 'json',
            success: function(data){
                //$(obj).parents("tr").remove();
                if(data.message=="ok"){
                	//alert(data.data.enterprisecontractInfo);
                	//layer.msg('已解除!',{icon:1,time:1000});
                	//window.location.reload();
                	var str = data.data.enterprisecontractInfo;
                	var str1 = data.data.enterpriseInfo;
                	var t=new Date();
                	var y=t.getFullYear();
                	var m=t.getMonth()+1;
                	if(m<10){
                	m="0"+m;
                	}
                	var d=t.getDate();
                	var No="KF-"+y+m+d+t.getHours()+t.getMinutes()+t.getMilliseconds();
                	$("#enterprisecontractid").val(str.enterprisecontractid);
                	$("#enterpriseid").val(str1.enterpriseid);
                	$("#newcontractNO").val(No);
                	$("#contractNO").val(str.contractnumber);
                	$("#price").val(str.price);
                	$("#linkman").val(str1.contactperson);
                	$("#personuser").val(str1.phone);                	
                }           
            }
        });

	});
	