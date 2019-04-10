 	var inputfile;
    var fileListSize;
    function add(){
    var num2=1;
   	 var formData =  new FormData();
   //合同单位
	    if(!(/[^\s]{1,}/.test($("#contractcompany").val().trim()))){
		 $("#contractcompany").attr("placeholder","不能为空");
		 $("#contractcompany").css("border","1px red solid");
		}else{
			debugger;
			num2+=1;
			$("#contractcompany").css("border","1px #DCDCDC solid");
		}
 	
 	//联系人
		    if(!(/[^\s]/.test($("#contactperson").val().trim()))){
			 $("#contactperson").attr("placeholder","不能为空");
			 $("#contactperson").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#contactperson").css("border","1px #DCDCDC solid");
			}
 	
 	// 联系人电话
		    if(!(/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test($("#phone").val().trim()))){
			 $("#phone").attr("placeholder","电话号码不正确");
			 $("#phone").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#phone").css("border","1px #DCDCDC solid");
			}
     // 车位地址
		    if(!(/[^\s]{1,}/.test($("#stalladdress").val().trim()))){
			 $("#stalladdress").attr("placeholder","不能为空");
			 $("#stalladdress").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#stalladdress").css("border","1px #DCDCDC solid");
			}
 	// 车位所属单位详细地址
		    if(!(/[^\s]{1,}/.test($("#address").val().trim()))){
			 $("#address").attr("placeholder","不能为空");
			 $("#address").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#address").css("border","1px #DCDCDC solid");
			}
		    //合同单位
		    if(!(/[^\s]{1,}/.test($("#contractcompany").val().trim()))){
			 $("#contractcompany").attr("placeholder","不能为空");
			 $("#contractcompany").css("border","1px red solid");
			}else{
				num2+=1;
				$("#contractcompany").css("border","1px #DCDCDC solid");
			}
		    //开始日期
		    if(!(/[^\s]{1,}/.test($("#datemin").val().trim()))){
			 $("#datemin").attr("placeholder","不能为空");
			 $("#datemin").css("border","1px red solid");
			}else{
				num2+=1;
				$("#datemin").css("border","1px #DCDCDC solid");
			}
		    //结束日期
		    if(!(/[^\s]{1,}/.test($("#datemax").val().trim()))){
			 $("#datemax").attr("placeholder","不能为空");
			 $("#datemax").css("border","1px red solid");
			}else{
				num2+=1;
				$("#datemax").css("border","1px #DCDCDC solid");
			}
    	// 车位编号
		    if(!(/[a-zA-Z]/.test($("#stallnumber").val().trim()))){
			 $("#stallnumber").attr("placeholder","请使用英文编号");
			 $("#stallnumber").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#stallnumber").css("border","1px #DCDCDC solid");
			}
 	// 车位起始位置
		    if(!(/^[+]{0,1}(\d+)$/.test($("#startnumber").val().trim()))){
			 $("#startnumber").attr("placeholder","只能是正整数");
			 $("#startnumber").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#startnumber").css("border","1px #DCDCDC solid");
			}
 	// 车位数量
		    if(!(/^[+]{0,1}(\d+)$/.test($("#number").val().trim()))){
			 $("#number").attr("placeholder","只能是正整数");
			 $("#number").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#number").css("border","1px #DCDCDC solid");
			}
 	
 	// 匹配成交价格
		    if(!(/^[+]{0,1}(\d+)$/.test($("#price").val().trim()))){
			 $("#price").attr("placeholder","只能是正整数");
			 $("#price").css("border","1px red solid");
			
			}else{
				num2+=1;
				$("#price").css("border","1px #DCDCDC solid");
			}
   	 //合同编号*
    formData.append("contractnumber",$("#contractnumber").val().trim());
    //合同单位
    formData.append("contractcompany",$("#contractcompany").val().trim());
    //联系人
    formData.append("contactperson",$("#contactperson").val().trim());
    //联系人电话
    formData.append("phone",$("#phone").val().trim());
    //车位地址
    formData.append("stalladdress",$("#stalladdress").val().trim());
    //车位所属单位详细地址
    formData.append("address",$("#address").val().trim());
    //合同生效日期
	formData.append("starttime",$("#datemin").val().trim());
	 //合同失效日期
	formData.append("endtime",$("#datemax").val().trim());
   	//车位编号
	formData.append("stallnumber",$("#stallnumber").val().trim());
	//车位起始位置
  	 formData.append("startnumber",$("#startnumber").val().trim());
  	 //车位数量
  	 formData.append("number",$("#number").val().trim());
  	 //车位价格
 	formData.append("price",$("#price").val().trim());
 	//车位图片
   	formData.append("contract",$("#fileinput")[0].files[0]);
   	 
	
	if(num2==13){
		$.ajax({
    		type : "post",
    		url : "inserterExternalcontract",
    		cache: false,
    		data : formData,
    		async:false,
    		processData:false,
    		contentType:false,
    		dataType : "json",
    		success : function(data) {
    			if(data.message=="开始时间等于当前日期"){
    				layer.msg('开始时间等于当前日期',{
    					icon:1,
    					time:1500
    				});
    				self.location="jsp/backstage/admin/externalContact/RenewalExternalContracts.jsp"
	    		}else if(data.message=="ok"){
	    			layer.msg('添加成功',{icon:1,time:1500});
	        		window.location.href="jsp/backstage/admin/externalContact/ViewExternalContracts.jsp";
    			}else if(data.message=="车位编号已存在"){
    				layer.msg('车位编号已存在',{icon:1,time:1500});
    			}else if(data.message=="请将信息添加完整"){
    				debugger;
    				layer.msg('请将信息添加完整',{icon:1,time:1500});
    				window.location.href="jsp/backstage/admin/externalContact/RenewalExternalContracts.jsp"
    			};
    				
    		}
		});  
	}else{
		layer.msg('请填写完整信息',{icon:1,time:1500});
		
	}
  };
    $(function(){
    	//合同单位
    	$("#contractcompany").blur(function(){
		    if(!(/\S{1,}/.test($("#contractcompany").val().trim()))){
			 $("#contractcompany").attr("placeholder","不能为空");
			 $("#contractcompany").css("border","1px red solid");
			
			}else{
				$("#contractcompany").css("border","1px #DCDCDC solid");
			}
    	})
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
        // 车位地址
    	$("#stalladdress").blur(function(){
		    if(!(/\S{1,}/.test($("#stalladdress").val().trim()))){
			 $("#stalladdress").attr("placeholder","不能为空");
			 $("#stalladdress").css("border","1px red solid");
			
			}else{
				$("#stalladdress").css("border","1px #DCDCDC solid");
			}
    	})
    	// 车位所属单位详细地址
    	$("#address").blur(function(){
		    if(!(/\S{1,}/.test($("#address").val().trim()))){
			 $("#address").attr("placeholder","不能为空");
			 $("#address").css("border","1px red solid");
			
			}else{
				$("#address").css("border","1px #DCDCDC solid");
			}
    	})
       	//起始日期
    	$("#datemin").blur(function(){
		    if(!(/\S{1,}/.test($("#datemin").val().trim()))){
			 $("#datemin").attr("placeholder","不能为空");
			 $("#datemin").css("border","1px red solid");
			
			}else{
				$("#datemin").css("border","1px #DCDCDC solid");
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
       	// 车位编号
    	$("#stallnumber").blur(function(){
		    if(!(/[a-zA-Z]/.test($("#stallnumber").val().trim()))){
			 $("#stallnumber").attr("placeholder","请使用英文编号");
			 $("#stallnumber").css("border","1px red solid");
			
			}else{
				$("#stallnumber").css("border","1px #DCDCDC solid");
			}
    	})
    	// 车位起始位置
    	$("#startnumber").blur(function(){
		    if(!(/^[+]{0,1}(\d+)$/.test($("#startnumber").val().trim()))){
			 $("#startnumber").attr("placeholder","只能是正整数");
			 $("#startnumber").css("border","1px red solid");
			}else{
				$("#startnumber").css("border","1px #DCDCDC solid");
			}
    	})
    	// 车位数量
    	$("#number").blur(function(){
		    if(!(/^[+]{0,1}(\d+)$/.test($("#number").val().trim()))){
			 $("#number").attr("placeholder","只能是正整数");
			 $("#number").css("border","1px red solid");
			
			}else{
				$("#number").css("border","1px #DCDCDC solid");
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
    	
    	
    	var t=new Date();
    	var y=t.getFullYear();
    	var m=t.getMonth()+1;
    	if(m<10){
    	m="0"+m;
    	}
    	var d=t.getDate();
    	var No="KF-"+y+m+d+t.getHours()+t.getMinutes()+t.getMilliseconds();
    	
    	$("#contractnumber").val(No);
    	
    	//
    	$("#button").click(function(){
            if(fileListSize>0){
            	add();
            }else{
            	alert("请选择图片")
            }
    	});
    	// 验证文件大小
        inputfile = $('#fileinput').fileinput({

            // 初始化上传文件框
            language: "zh",// 配置语言
            showPreview: true,// 是否显示预览
            showUpload: true, // 显示整体上传的按钮
            showRemove: false,// 显示整体删除的按钮
            uploadAsync: false,// 默认异步上传
// uploadLabel: "上传",//设置整体上传按钮的汉字
            removeLabel: "移除",// 设置整体删除按钮的汉字
            uploadClass: "btn btn-primary",// 设置上传按钮样式
            showCaption: true,// 是否显示标题
            dropZoneEnabled: false,// 是否显示拖拽区域
            showUpload: false,// 是否显示上传按钮
// uploadUrl:
// getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
            maxFileSize : 1024,// 文件大小限制
            maxFileCount: 1,// 允许最大上传数，可以多个，
            enctype: 'multipart/form-data',
            allowedFileExtensions : ["png","jpg"],/*
													 * 上传文件格式限制
													 * "gif","docx","zip","xlsx","txt"
													 */
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            showBrowse: true,
            browseOnZoneClick: true,
            initialCaption: "请选择上传图片",// 输入提示
            slugCallback : function(filename) {
                return filename.replace('(', '_').replace(']', '_');
            }
        });
        // 选择文件后校验通过才会进入该方法
        $('#fileinput').on("filebatchselected", function(event, files,msg) {
/*
 * console.log(event); console.log(files); console.log(msg);
 */
            fileListSize = files.length;
        });
        // 文件上传成功后的回调方法
/*
 * $('#fileinput').on("fileimageuploaded", function(event, files) {
 * console.log(event); console.log(files);
 * 
 * });
 */
/*
 * $('#fileinput').on('filebatchuploadsuccess', function(event, data, previewId,
 * index) { console.log(event); console.log(data); console.log(previewId);
 * console.log(index);
 * 
 * });
 */
        
        
        
        
        
        
        
        
    });