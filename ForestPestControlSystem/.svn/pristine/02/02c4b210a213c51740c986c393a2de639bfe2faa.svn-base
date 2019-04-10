		$('#addSmallClass').click(
				function(){
					var flag = true;
					var smallClassName = $("#smallClassName").val();
					var personName = $("#personName").val();
					var personPhone = $("#personPhone").val();
					var personNum = $("#personNum").val();
					var areaName = $("#areaName option:selected").val();
					if(smallClassName == "" || smallClassName == null ){
						$("#smallClassName").css({
							"border": "1px solid red"
						});
						 flag = false;
					}
					if(personName == "" || personName == null || !(/^[\u4e00-\u9fa5]{2,6}$/.test(personName.trim()))){
						$("#personName").css({
							"border": "1px solid red"
						});
						$("#personName").val("");
						$("#personName").attr({
							"placeholder": "请输入中文(2-6)"
						});
						 flag = false;
					}
					if(personPhone == "" || personPhone == null || !(/^1([38]\d|4[579]|57[0-35-9]|66|9[98])[0-9]{8}$/.test(personPhone.trim()))){
						$("#personPhone").css({
							"border": "1px solid red"
						});
						$("#personPhone").val("");
						$("#personPhone").attr({
							"placeholder": "请输入中文11位电话号码"
						});
						 flag = false;
					}
					if(personNum == "" || personNum == null || !(/^[1-9][0-9]$/.test(personNum.trim()))){
						$("#personNum").css({
							"border": "1px solid red"
						});
						$("#personNum").val("");
						$("#personNum").attr({
							"placeholder": "请输入最多两位数"
						});
						 flag = false;
					}
					if(flag){
						$.ajax({
							type : "post",
							dataType : "json",
							url : "addSmallClass",
							data : {
								'areaName' : areaName,
								'smallClassName' : smallClassName,
								'personName' : personName,
								'personNum' : personNum,
								'personPhone' : personPhone
							},
							success : function(data) {
								if (data == 1) {
									window.location.href = 'smallClass';
								}else if(data == 2){
									$("#smallClassName").css({
										"border": "1px solid red"
									});
									$("#smallClassName").val("");
									$("#smallClassName").attr({
										"placeholder": "小班名称已被占用"
									});
								}
							}
						});
					}
					
				});