$('#updataSmall').click(
		function() {
			var flag = true;
			var personName = $("#personName").val();
			var personPhone = $("#personPhone").val();
			if (personName == "" || personName == null
					|| !(/^[\u4e00-\u9fa5]{2,6}$/.test(personName.trim()))) {
				$("#personName").css({
					"border" : "1px solid red"
				});
				$("#personName").val("");
				$("#personName").attr({
					"placeholder" : "请输入中文(2-6)"
				});
				flag = false;
			}
			if (personPhone == ""
					|| personPhone == null
					|| !(/^1([38]\d|4[579]|57[0-35-9]|66|9[98])[0-9]{8}$/
							.test(personPhone.trim()))) {
				$("#personPhone").css({
					"border" : "1px solid red"
				});
				$("#personPhone").val("");
				$("#personPhone").attr({
					"placeholder" : "请输入中文11位电话号码"
				});
				flag = false;
			}
			if (flag) {
				$.ajax({
					type : "post",
					dataType : "json",
					url : "updataSmallClass",
					data : {
						'smallId' : $("#smallClassId").val(),
						'personName' : personName,
						'personPhone' : personPhone,
					},
					success : function(data) {
						if (data == 1) {
							window.location.href = 'smallClass';
						}
					}
				});
			}

});