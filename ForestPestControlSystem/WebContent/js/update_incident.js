$('#update').click(function() {
			var flag = true;
			var stageId =  $("#stageId option:selected").val();
			var controlMethod = $('#controlMethod').val();
			var incidentId = $('#incidentId option:selected').val();
			
			if(controlMethod == "" || controlMethod == null){
				 $('#controlMethod').css({
						"border": "1px solid red"
				 });
					$("#controlMethod").attr({
						"placeholder" : "不能为空哦"
					});
				 flag = false;
			}
			if(flag){
				$.ajax({
					type : "post",
					dataType : "json",
					url : "updateIncident",
					data : {
						'stageId' : stageId,
						'controlMethod' : controlMethod,
						'incidentId': incidentId
					},
					success : function(data) {
						if (data == 1) {
							window.location.href = 'incident';
						}
					}
				});
			}
		});