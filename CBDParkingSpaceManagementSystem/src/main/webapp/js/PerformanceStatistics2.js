$(function(){
	var number =[];
	var address =[];
	var list = [];
	$.ajax({
		  async:false, 
		  url:"showResponsetime",
		  type:"post",
	  success:function(data){
		  list = data.data.pge;
/*		 for(var index = 0;index < responsetime.length; index++){
			 number.push(responsetime[index].consuming);
			 address.push(responsetime[index].name)
		 }*/
	  }
	})
	
	var num = [];
	var date=[];
	 for(var index = 0;index < 100; index++){
		 num.push(list[index].consuming);
		 date.push(list[index].name)
	 }
	 
	 var myChart = echarts.init(document.getElementById("box"));
	 var app={};
	 option=null;
	 option = {
			 	title:{
			 		text:''
			 	},
			 	tooltip:{
			 		trigger:'axis'
			 	},
			 	legend:{
			 		data:['请求时间']
			 	},
			 	qrid:{
			 		left:'3%',
			 		right:'4%',
			 		botton:'3%',
			 		containLabel:true
			 	},
			 	toolbox:{
			 		feature:{
			 			saveAsImage:{}
			 		}
			 	},
			    xAxis: {
			        type: 'category',
			        boundaryGap:true,
			 		name:"请求地址",
			        data: date
			    },
			    yAxis: {
			        type: 'value',
			        name:"请求时间",
			        max:100,
			        min:0
			    },
			    series: [{
			    	name:'请求时间',
			    	type: 'line',
			    	stack:'总量',
			        data: num
			    }]
			};
	 if(option && typeof option === "object"){
		 myChart.setOption(option,true); 
	 }
	 
	 
	 var start=10;
		var end=110;
		setInterval(function(){
			num=[];
			date=[];
			for(;start<end&&end<list.length;start++){
			
				num.push(list[start].consuming);
				date.push(list[start].name)
			}
		/*	if(end<test){*/
			
			myChart.setOption({
				xAxis: {
			        data: date
			    },
			    series: [{
			        data: num
			    }]
			})
		/*	}*/
			
			start-=99;
			end+=1;
		},1000)
	
})


	
	