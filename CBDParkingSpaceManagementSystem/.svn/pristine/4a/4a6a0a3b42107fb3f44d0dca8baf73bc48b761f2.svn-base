$(function(){
		//alert("OOK")
		$.ajax({
			url:"getAllCBDByState",
			type:"post",
			success:function(data){
				console.log(data.data.state)
				var datas = data.data.state;
				var str ="";
				$.each(datas,function(i,ins){
					//style='display:none'
					 //"<span id="+ins.cbdid+">"+ins.areanumber+"</span>";
					
					str += "<span><input type='checkbox' style='display:none'  name='click' id="+ins.cbdid+">"+ins.areanumber+"</span>&nbsp;&nbsp;&nbsp;"; 
				})
				$(".first").append(str);
			}
		})
		var arr = new Array();
	$(".first").on("click","span",function(){
			var input = $(this).find("input").eq(0);
			var ID = input.attr("id");
			var flag = input.prop("checked");
			input.prop("checked",!flag)
			
			if($(this).css("background")=="rgb(0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box"){
				$(this).css({ "color": "#fff", "background": "#B9DEA0" });
			}else{
				$(this).css({ "color": "#ff0011", "background": "black" });
			}
			
			//alert($(this).find("input").eq(0).prop("checked"));
			//arr.push(ID);
			console.log(ID);
		});
	
	$("#add").click(function(){
		$('input[name="click"]:checked').each(function(){ //遍历，将所有选中的值放到数组中
			arr.push($(this).attr("id")+","); 
	    }); 
		//alert(arr);
		window.parent.$("#infoid").html(arr);
		layer_close();
	})
	});
	