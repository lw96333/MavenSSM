$("#addArea").click(function(){
	var flag = true;
	var areaName = $("#areaName").val();
	var areaForest = $("#areaForest").val();
	var areaAdvantage = $("#areaAdvantage").val();
	var linDi = $("#linDi option:selected").val();
	if(areaName == "" || areaName == null ||  !(/^[\u4e00-\u9fa5]{2,6}$/.test(areaName.trim()))){
		$("#areaName").css({
			"border": "1px solid red"
		});
		$("#areaName").val("");
		$("#areaName").attr({
			"placeholder": "请输入中文(2-6)"
		});
		 flag = false;
	}
	
	if(areaForest == "" || areaForest == null ||  !(/^[\u4e00-\u9fa5]{2,10}$/.test(areaForest.trim()))){
		$("#areaForest").css({
			"border": "1px solid red"
		});
		$("#areaForest").val("");
		$("#areaForest").attr({
			"placeholder": "请输入中文(2-10)"
		});
		flag = false;
	}
	if(areaAdvantage == "" || areaAdvantage == null ||  !(/^[\u4e00-\u9fa5]{2,10}$/.test(areaAdvantage.trim()))){
		$("#areaAdvantage").css({
			"border": "1px solid red"
		});
		$("#areaAdvantage").val("");
		$("#areaAdvantage").attr({
			"placeholder": "请输入中文(2-10)"
		});
		flag = false;
	}
	if(flag){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "../addArea",
			data : {
				'areaName' : areaName,
				'areaForest' : areaForest,
				'areaAdvantage' : areaAdvantage,
				'linDi' : linDi
			},
			success : function(data) {
				if(data == 1){
					 window.location.href='../areaIn';
				}else if(data == 2){
					$("#areaName").css({
						"border": "1px solid red"
					});
					$("#areaName").val("");
					$("#areaName").attr({
						"placeholder": "区域名称已被占用"
					});
				}
			}
		});
	}
});



