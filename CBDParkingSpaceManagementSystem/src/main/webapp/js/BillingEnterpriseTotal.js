$(function(){
	//alert("222");
    $.ajax({
        type:"post",
        url:"countAll",
        dataType:"json",
        success:function(data){
        	
        	console.log(data.data)
        	
        	if (data.data.countIncome == null && data.data.countExpend == null ) {
				$("#countNum").text(data.data.countNum);
            	$("#countExpend").text("0");
            	$("#countIncome").text("0");
			}else if (data.data.countIncomeSum == null) {
        		$("#countNum").text(data.data.countNum);
	            $("#countExpend").text(data.data.countExpend);
            	$("#countIncome").text("0");
			}else if (data.data.countExpend == null) {
				$("#countNum").text(data.data.countNum);
            	$("#countExpend").text("0");
            	$("#countIncome").text(data.data.countIncome);
			}else {
				$("#countNum").text(data.data.countNum);
	            $("#countExpend").text(data.data.countExpend);
	            $("#countIncome").text(data.data.countIncome);
			}
            
        }
    });
    
    $("#close").click(function(){
    	window.parent.location.reload();
    })

});
$("#cheak").click(function(){
	window.parent.location.reload();
})