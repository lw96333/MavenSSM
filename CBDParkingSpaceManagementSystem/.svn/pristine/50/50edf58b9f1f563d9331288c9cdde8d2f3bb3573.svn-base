 	var inputfile;
    var fileListSize;
	var url = window.location.href;//项目里面这里用window.location.href;
	var  arr = url.split("id=");
	var id = arr[1];
    
function add(){
	var num=1;	
   	 var formData =  new FormData();
   	 formData.append("id",id);
   	 formData.append("contract",$("#fileinput")[0].files[0]);
 	 formData.append("starttime",$("#datemin").val().trim());
 	 formData.append("endtime",$("#datemax").val().trim());

   	//匹配原合同编号
	formData.append("oldcontractnumber",$("#oldcontractnumber").val().trim());
 	//匹配合同编号
	formData.append("contractnumber",$("#contractnumber").val().trim());
	//匹配联系人
	formData.append("contactperson",$("#contactperson").val().trim());
	//匹配联系人电话
	formData.append("phone",$("#phone").val().trim());
	//匹配成交价格
	formData.append("price",$("#price").val().trim());
	//匹配合同单位
	formData.append("contractcompany",$("#contractcompany").val().trim());
	//联系人
	    if(!(/[^\s]{1,}/.test($("#contactperson").val().trim()))){
		 $("#contactperson").attr("placeholder","不能为空");
		 $("#contactperson").css("border","1px red solid");
		
		}else{
			num+=1;
			$("#contactperson").css("border","1px #DCDCDC solid");
		}
	
	// 联系人电话
	    if(!(/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test($("#phone").val().trim()))){
		 $("#phone").attr("placeholder","电话号码不正确");
		 $("#phone").css("border","1px red solid");
		
		}else{
			num+=1;
			$("#phone").css("border","1px #DCDCDC solid");
		}
	    //结束日期
	    if(!(/[^\s]{1,}/.test($("#datemax").val().trim()))){
		 $("#datemax").attr("placeholder","不能为空");
		 $("#datemax").css("border","1px red solid");
		}else{
			num2+=1;
			$("#datemax").css("border","1px #DCDCDC solid");
		}
	// 匹配成交价格
	    if(!(/^[+]{0,1}(\d+)$/.test($("#price").val().trim()))){
		 $("#price").attr("placeholder","只能是正整数");
		 $("#price").css("border","1px red solid");
		
		}else{
			num+=1;
			$("#price").css("border","1px #DCDCDC solid");
		}
	//合同单位
	    if(!(/[^\s]{1,}/.test($("#contractcompany").val().trim()))){
		 $("#contractcompany").attr("placeholder","不能为空");
		 $("#contractcompany").css("border","1px red solid");
		
		}else{
			num+=1;
			$("#contractcompany").css("border","1px #DCDCDC solid");
		}
	
	
	if(num2==5){
		$.ajax({
    		type : "post",
    		url : "updataExternalcontract",
    		cache: false,
    		data : formData,
    		async:false,
    		processData:false,
    		contentType:false,
    		dataType : "json",
    		success : function(data) {
    			if(data.message=="开始时间需要等于或大于当前日期"){
    				layer.msg('开始时间需要等于或大于当前日期',{
    					icon:1,
    					time:500
    				});
    					window.parent.location.href="jsp/backstage/admin/externalContact/ViewExternalContracts.jsp";
    			}else if(data.message=="ok"){
    				layer.msg('续约成功',{
    					icon:1,
    					time:500
    				});
    				window.parent.location.href="jsp/backstage/admin/externalContact/ViewExternalContracts.jsp";
			
				};
    		}
		});  
  }else{
		layer.msg('请填写完整信息',{icon:1,time:1500});
		
	}
};
    $(function(){
    	$.ajax({
            type: 'POST',
            url: 'getExternalcontract',
            data:{"id":id},
            dataType: 'json',
            success: function(data){
                if(data.message=="ok"){
                	var str = data.data.externalcontract;
                	var t=new Date();
                	var y=t.getFullYear();
                	var m=t.getMonth()+1;
                	if(m<10){
                	m="0"+m;
                	}
                	var d=t.getDate();
                	var No="KF-"+y+m+d+t.getHours()+t.getMinutes()+t.getMilliseconds();
                	$("#oldcontractnumber").val(str.contractnumber);  
                	$("#contractnumber").val(No);
                	$("#contactperson").val(str.contactperson);
                	$("#phone").val(str.phone);
                	$("#contractcompany").val(str.contractcompany);
                	$("#datemin").val(str.endtime);
                	
                }           
            }
        });
    	
    	//联系人
    	$("#contactperson").blur(function(){
		    if(!(/\S{1,}/.test($("#contactperson").val().trim()))){
			 $("#contactperson").attr("placeholder","不能为空");
			 $("#contactperson").css("border","1px red solid");
			
			}else{
				$("#contactperson").css("border","1px #DCDCDC solid");
			}
    	})
    	
    	// 联系人电话
    	$("#phone").blur(function(){
		    if(!(/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test($("#phone").val().trim()))){
			 $("#phone").attr("placeholder","电话号码不正确");
			 $("#phone").css("border","1px red solid");
			
			}else{
				$("#phone").css("border","1px #DCDCDC solid");
			}
    	})
    	//结束日期
    	$("#datemax").blur(function(){
		    if(!(/\S{1,}/.test($("#datemax").val().trim()))){
			 $("#datemax").attr("placeholder","不能为空");
			 $("#datemax").css("border","1px red solid");
			
			}else{
				$("#datemax").css("border","1px #DCDCDC solid");
			}
    	})
    	// 匹配成交价格
    	$("#price").blur(function(){
		    if(!(/^[+]{0,1}(\d+)$/.test($("#price").val().trim()))){
			 $("#price").attr("placeholder","只能是正整数");
			 $("#price").css("border","1px red solid");
			
			}else{
				$("#price").css("border","1px #DCDCDC solid");
			}
    	})
    	//合同单位
    	$("#contractcompany").blur(function(){
		    if(!(/\S{1,}/.test($("#contractcompany").val().trim()))){
			 $("#contractcompany").attr("placeholder","不能为空");
			 $("#contractcompany").css("border","1px red solid");
			
			}else{
				$("#contractcompany").css("border","1px #DCDCDC solid");
			}
    	})
    	$("#button").click(function(){
            if(fileListSize>0){
            	add();
            }else{
            	alert("请选择图片")
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
//          uploadLabel: "上传",//设置整体上传按钮的汉字
            removeLabel: "移除",//设置整体删除按钮的汉字
            uploadClass: "btn btn-primary",//设置上传按钮样式
            showCaption: true,//是否显示标题
            dropZoneEnabled: false,//是否显示拖拽区域
            showUpload: false,//是否显示上传按钮
//          uploadUrl: getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
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
        //选择文件后校验通过才会进入该方法
        $('#fileinput').on("filebatchselected", function(event, files,msg) {
            fileListSize = files.length;
        });
    });