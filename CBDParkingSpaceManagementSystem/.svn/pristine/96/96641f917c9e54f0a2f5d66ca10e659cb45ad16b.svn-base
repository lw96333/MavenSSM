		var url = window.location.href;//项目里面这里用window.location.href;
		var arr = url.split("id=");
		var id = arr[1];
		
		$("#lease").click(function() {
			var info = $("#tousu").val();
			if(info == undefined || info == "") {
				layer.msg('投诉信息必须填写哦! ', {
					icon : 1,
					time : 1000
				});
			} else {
				layer.confirm('确认要投诉对方吗？', function(index) {
					 $.ajax({
						type : "post",
						url : "complaintLJQ",
						data : {
							"ComplaintInfo" : $("#ComplaintInfo").val(),
							"content" : $("#tousu").val(),
							"bid" : $("#userId").val(),
							"btid" : id,
							"state" : "受理"
						},
						dataType : 'json',
						success : function(data) {
							$.ajax({
								type : "post",
								url : "complaintPush",
								data : {
									"btuserid" :id
								}
							});
						}
					});
					layer.msg('投诉成功!等待管理员审核! ', {
						icon : 1,
						time : 1000
					});
					//延时关闭页面(模态框)
					setInterval(function() {
				        layer_close();
				    }, 1000);
					
				});
			}
			
		})
		$("#noRent").click(function() {

			layer_close();
		})