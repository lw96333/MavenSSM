var inputfile;
var fileListSize;
function add() {
	var num = 1;
	var formData = new FormData();
	formData.append("propertyright", $("#fileinput")[0].files[0]);

	formData.append("equitiesid", $("#equitiesid").val().trim());
	formData.append("areaid", $("#areaid").val().trim());
	formData.append("area", $("#area").val().trim());

	$
			.ajax({
				type : "post",
				url : "addPrivatecars",
				cache : false,
				data : formData,
				async : false,
				processData : false,
				contentType : false,
				dataType : "json",
				success : function(data) {
					console.log(data);

					var areff = data.data.privateCars2;
					if (areff != null) {
						layer.msg('车位已存在!', {
							icon : 1,
							time : 1500
						});
						console.log(areff);
					} else {
						layer.msg('添加成功!', {
							icon : 1,
							time : 1500
						});
						self.location = "jsp/fortend/personal/ShowPersonageAddCarport.jsp";

					}
				}
			});

};

$(function() {
	$("#button")
			.click(
					function() {
						var equitiesid = $("#equitiesid").val();
						var area = $("#area").val();
						var areaid = $("#areaid").val();
						if (equitiesid == "" || area == "" || areaid == "") {
							layer.msg('请输入信息，不能有空!', {
								icon : 1,
								time : 1500
							});
						
						} else if( equitiesid.indexOf(" ") != -1
								|| areaid.indexOf(" ") != -1
								|| area.indexOf(" ") != -1){
							layer.msg('请输入正确信息，不能带有空格!', {
								icon : 1,
								time : 1500
							});
						}else{
							if (fileListSize > 0) {
								add();
							} else {
								layer.msg('请选择图片!', {
									icon : 1,
									time : 1500
								});

							}
						}

					});

	// 验证文件大小
	inputfile = $('#fileinput').fileinput({

		// 初始化上传文件框
		language : "zh",// 配置语言
		showPreview : true,// 是否显示预览
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
		maxFileSize : 1024,// 文件大小限制
		maxFileCount : 1,// 允许最大上传数，可以多个，
		enctype : 'multipart/form-data',
		allowedFileExtensions : [ "png", "jpg" ],/*
													 * 上传文件格式限制
													 * "gif","docx","zip","xlsx","txt"
													 */
		msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		showBrowse : true,
		browseOnZoneClick : true,
		initialCaption : "请选择上传图片",// 输入提示
		slugCallback : function(filename) {
			return filename.replace('(', '_').replace(']', '_');
		}
	});

	$('#fileinput').on("filebatchselected", function(event, files, msg) {
		fileListSize = files.length;
	});

});
