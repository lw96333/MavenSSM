$(function() {
	$('#file-pic1').fileinput({
		// 初始化上传文件框
		language : "zh",// 配置语言
		showPreview : false,// 是否显示预览
		showUpload : true, // 显示整体上传的按钮
		showRemove : false,// 显示整体删除的按钮
		uploadAsync : false,// 默认异步上传
		// uploadLabel: "上传",//设置整体上传按钮的汉字
		removeLabel : "移除",// 设置整体删除按钮的汉字
		uploadClass : "btn btn-primary",// 设置上传按钮样式
		showCaption : true,// 是否显示标题
		dropZoneEnabled : false,// 是否显示拖拽区域
		showUpload : false,// 是否显示上传按钮
		// uploadUrl:
		// getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
		maxFileSize : 9999,// 文件大小限制
		maxFileCount : 1,// 允许最大上传数，可以多个，
		enctype : 'multipart/form-data',
		allowedFileExtensions : [ "jpg", "png", "gif" ],/* 上传文件格式限制 */
		msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		showBrowse : true,
		browseOnZoneClick : true,
		initialCaption : "请选择上传图片",// 输入提示
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});
	$("#areaName").change(function() {
		var smallClassId = $(this).val();
		$.ajax({
			type : "post",
			url : "querySmallClassById",
			data : {
				"smallClassId" : smallClassId
			},
			dataType : 'json',
			success : function(data) {
				$('#smallClassName').html("<span>" + data.name + "</span>");
			}
		});
	});
});
function fromVerify() {
	var flag = true;
	var incidentName = $("input[name=incidentName]").val();
	var influence = $("input[name=influence]").val();
	var controlMethod = $("input[name=controlMethod]").val();
	var initialloss = $("input[name=initialloss]").val();
	var disaster = $("textarea[name=disaster]").val();
	var time = $("input[name=time]").val();
	var uploadImgFile = $("input[name=uploadImgFile]").val();
	if(incidentName == "" || incidentName == null ){
		$("input[name=incidentName]").css({
			"border": "1px solid red"
		});
		flag = false;
	}
	if(influence == "" || influence == null || !(/^[1-9][0-9]{0,10}(平方米|平方|亩)$/.test(influence))){
		$("input[name=influence]").css({
			"border": "1px solid red"
		});
		$("input[name=influence]").val("");
		$("input[name=influence]").attr({
			"placeholder": "数字开头【单位(平方米|平方|亩)】"
		});
		flag = false;
	}
	if(controlMethod == "" || controlMethod == null ){
		$("input[name=controlMethod]").css({
			"border": "1px solid red"
		});
		flag = false;
	}
	if(initialloss == "" || initialloss == null || !(/^[1-9][0-9]{0,10}([W]|(万元{0,1}))$/.test(initialloss)) ){
		$("input[name=initialloss]").css({
			"border": "1px solid red"
		});
		$("input[name=initialloss]").val("");
		$("input[name=initialloss]").attr({
			"placeholder": "数字开头【单位(W|万元|元)】"
		});
		flag = false;
	}
	if(time == "" || time == null ){
		$("input[name=time]").css({
			"border": "1px solid red"
		});
		flag = false;
	}
	if(uploadImgFile == "" || uploadImgFile == null ){
		$("input[name=uploadImgFile]").css({
			"border": "1px solid red"
		});
		flag = false;
	}
	if(disaster == "" || disaster == null ){
		$("textarea[name=disaster]").css({
			"border": "1px solid red"
		});
		flag = false;
	}
	return flag;
}






