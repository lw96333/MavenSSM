function judge(obj,str){
		var my = obj;
		if(my.val() != "" && my.val() != null){
			my.css({
				"border": "1px solid gainsboro"
			});
			return true;
		}else{
			my.attr("placeholder",str);
			my.css({
				"border": "1px solid red"
			});
			return false;
		}
	}
	$("input[name=pestsName]").on("blur",function(){
		judge($(this),"请输入虫害名称");
	});
	$("input[name=pestsHost]").on("blur",function(){
		judge($(this),"请输入寄主");
	});

	$("input[name=pestsreproduction]").on("blur",function(){
		judge($(this),"请输入繁殖规律");
	});
	$("input[name=pestsnaturalEnemy]").on("blur",function(){
		judge($(this),"请输入自然天敌");
	});
	$("textarea[name=pestspreventiveMeasures]").on("blur",function(){
		judge($(this),"请输入防治措施");
	});
	$("textarea[name=pestsmainHazards]").on("blur",function(){
		judge($(this),"请输入主要危害");
	});
	
	
    $(function(){
    	$("#add").click(function(){
    		var falg = true;
    		var dname = $("input[name=pestsName]").val();
    		var dlogy = $("input[name=pestsHost]").val();
    		var dsymptom = $("input[name=pestsreproduction]").val();
    		var dity = $("input[name=pestsnaturalEnemy]").val();
    		var dmeasures = $("textarea[name=pestspreventiveMeasures]").val();
    		var dmeasures2 = $("textarea[name=pestsmainHazards]").val();
    		
    		if(dname == "" || dname == null){
    			$("input[name=pestsName]").blur();
				falg = false;
			}
    		if(dlogy == "" || dlogy == null){
				$("input[name=pestsHost]").blur();
				falg = false;
			}
    		if($("input[name=uploadImgFile1]").val() != "" && $("input[name=uploadImgFile1]").val() != null){
    			$(".file-caption").css({
    				"border": "1px solid gainsboro"
    			});
    		}else{
    			$(".file-caption").css({
    				"border": "1px solid red"
    			});
    			falg = false;
    		}
    		if($("input[name=uploadImgFile2]").val() != "" && $("input[name=uploadImgFile2]").val() != null){
    			$(".file-caption").css({
    				"border": "1px solid gainsboro"
    			});
    		}else{
    			$(".file-caption").css({
    				"border": "1px solid red"
    			});
    			falg = false;
    		}

    		
    		if(dsymptom == "" || dsymptom == null){
				$("input[name=pestsreproduction]").blur();
				falg = false;
			}
    		if(dity == "" || dity == null){
				$("input[name=pestsnaturalEnemy]").blur();
				falg = false;
			}
    	
    		if(dmeasures == "" || dmeasures == null){
				$("textarea[name=pestspreventiveMeasures]").blur();
				falg = false;
			}
    		if(dmeasures2 == "" || dmeasures2 == null){
				$("textarea[name=pestsmainHazards]").blur();
				falg = false;
			}
    		
    		if(falg){
				$(".form-horizontal").submit();
			}
    	});
    	
    	
        $('#file-pic1').fileinput({

            //初始化上传文件框
            language: "zh",//配置语言
            showPreview: false,//是否显示预览
            showUpload: true, //显示整体上传的按钮
            showRemove: false,//显示整体删除的按钮
            uploadAsync: false,//默认异步上传
//            uploadLabel: "上传",//设置整体上传按钮的汉字
            removeLabel: "移除",//设置整体删除按钮的汉字
            uploadClass: "btn btn-primary",//设置上传按钮样式
            showCaption: true,//是否显示标题initialCaption:"请选择图片",
            dropZoneEnabled: false,//是否显示拖拽区域
            showUpload: false,//是否显示上传按钮
//                    uploadUrl: getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
            maxFileSize : 9999,//文件大小限制
            maxFileCount: 1,//允许最大上传数，可以多个，
            enctype: 'multipart/form-data',
            allowedFileExtensions : ["jpg", "png","gif","docx","zip","xlsx","txt"],/*上传文件格式限制*/
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            showBrowse: true,
            browseOnZoneClick: true,
            initialCaption: "请选择上传图片",//输入提示
            slugCallback : function(filename) {
                return filename.replace('(', '_').replace(']', '_');
            }
        });
        $('#file-pic2').fileinput({

            //初始化上传文件框
            language: "zh",//配置语言
            showPreview: false,//是否显示预览
            showUpload: true, //显示整体上传的按钮
            showRemove: false,//显示整体删除的按钮
            uploadAsync: false,//默认异步上传
//            uploadLabel: "上传",//设置整体上传按钮的汉字
            removeLabel: "移除",//设置整体删除按钮的汉字
            uploadClass: "btn btn-primary",//设置上传按钮样式
            showCaption: true,//是否显示标题initialCaption:"请选择图片",
            dropZoneEnabled: false,//是否显示拖拽区域
            showUpload: false,//是否显示上传按钮
//                    uploadUrl: getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
            maxFileSize : 9999,//文件大小限制
            maxFileCount: 1,//允许最大上传数，可以多个，
            enctype: 'multipart/form-data',
            allowedFileExtensions : ["jpg", "png","gif","docx","zip","xlsx","txt"],/*上传文件格式限制*/
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            showBrowse: true,
            browseOnZoneClick: true,
            initialCaption: "请选择上传图片",//输入提示
            slugCallback : function(filename) {
                return filename.replace('(', '_').replace(']', '_');
            }
        });
    });