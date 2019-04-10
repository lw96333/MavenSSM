	var number =[];
	var address =[];
	
	function getApi(){
		$.ajax({
			  async:false, 
			  url:"showResponsetime",
			  type:"post",
		  success:function(data){
			  var  responsetime = data.data.pge.records;
			 for(var index = 0;index < responsetime.length; index++){
				 number.push(responsetime[index].consuming);
				 address.push(responsetime[index].name)
			 }
		  }
		})
	}
$(function(){
	getApi();
	var myChart = echarts.init(document.getElementById("box"));
	option = {
		    xAxis: {
		        type: 'category',
		        data: address
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [{
		        data: number,
		        type: 'line'
		    }]
		};
	myChart.setOption(option);
	
})
