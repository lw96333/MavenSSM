$(function(){
    
    $.ajax({
        type:"post",
        url:"countPersonBilling",
        dataType:"json",
        success:function(data){
        	
        	console.log(data.data.countExpendSum)
        	
        	if (data.data.countIncomeSum == null && data.data.countExpendSum == null ) {
				$("#dealSum").text(data.data.countDealSum);
            	$("#expendSum").text("0");
            	$("#incomeSum").text("0");
			}else if (data.data.countIncomeSum == null) {
        		$("#dealSum").text(data.data.countDealSum);
	            $("#expendSum").text(data.data.countExpendSum);
            	$("#incomeSum").text("0");
			}else if (data.data.countExpendSum == null) {
				$("#dealSum").text(data.data.countDealSum);
            	$("#expendSum").text("0");
            	$("#incomeSum").text(data.data.countIncomeSum);
			}else {
				$("#dealSum").text(data.data.countDealSum);
	            $("#expendSum").text(data.data.countExpendSum);
	            $("#incomeSum").text(data.data.countIncomeSum);
			}
            
        }
    });
    
    $("#close").click(function(){
        window.parent.location.reload();
    })

});