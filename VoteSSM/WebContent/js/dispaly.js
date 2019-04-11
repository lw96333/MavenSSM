// 基于准备好的dom，初始化echarts图表
        $(function(){
        	$(".form-control").change(function(){
        		var voteId = $('.form-control option:checked').val();
        	
        		$.ajax({
        			type:"get",
        			url:"selectContextById",
        			data:{
        				"id":voteId
        			},
        			dataType:"json",
        			success:function(data){
        				
        				var contexts = data.data['voteContes'];
        				var str = "";
        				var dataOne = new Array();
        				var dataTwo = new Array();
        				var type;
        				
        				for(var index = 0 ; index < contexts.length ;index++){
        					type = contexts[index].voteType;
        					if(contexts[index].voteType == 1){
        						str += "<div class='form-group'><span>"+ contexts[index].context +" </span><input type='radio' name='allSelect' checkId='"+ contexts[index].votecontext_id +"'/></div><br/>";
        						
        					}else{
        						str += "<div class='form-group'><span>"+ contexts[index].context +" </span><input type='checkbox' name='allSelect' checkId='"+ contexts[index].votecontext_id +"'/></div><br/>";
        					}
        					
        					dataOne.push(contexts[index].context);
        					dataTwo.push(contexts[index].count);
        				}
        				str +="<div class='form-group'><input type='button' name='toupiao'value='投票'/><div>";
        				$(".panel-body").html(str);

        				
        				 var myChart = echarts.init(document.getElementById('main'));
        			      // 为echarts对象加载数据
        			      myChart.setOption(option(dataOne,dataTwo));
        			      
        			      $("input[name=toupiao]").click(function(){
        			    	  var id = "";
        			    	  if(type == 1){
        			    		   id += $("input[name=allSelect]:checked").attr("checkId") + "^";
        			    	  }else{
        			    		  
        			    		  $('input[name="allSelect"]:checked').each(function(){ 
        			    			  id += $(this).attr("checkId") + "^";
        			    		    }); 
        			    	  }
        			    	  
        			    	  $.ajax({
        			    		  type:"post",
        			    		  url:"updateVoteContext",
        			    		  data:{
        			    			  _method:"put",
        			    			  "id":id,
        			    			  "voteId":voteId
        			    		  },
        			    	  	  dateType:"json",
        			    	  	  success:function(data){
        			    	  		var contexts = data.data['voteContes'];
        	        			
        	        				var dataOne = new Array();
        	        				var dataTwo = new Array();
        	        				
        	        				
        	        				for(var index = 0 ; index < contexts.length ;index++){
        	        					
        	        					
        	        					dataOne.push(contexts[index].context);
        	        					dataTwo.push(contexts[index].count);
        	        				}
        	        				

        	        				
        	        				 var myChart = echarts.init(document.getElementById('main'));
        	        			      // 为echarts对象加载数据
        	        			      myChart.setOption(option(dataOne,dataTwo));
        			    	  	  }
        			    	  });
        			      });
        			}
        		});
        	});
        	
        	$.ajax({
        		type:"get",
        		url:"selectAllPubVote",
        		dataType:"json",
        		success:function(data){
        			console.log(data);
        			var votes = data.data["votes"];
        			var str = "<option>请选择投票</option>";
        			for(var index = 0; index < votes.length; index++){
        				str += "<option value='"+ votes[index].vote_id +"'>" + votes[index].title + "</option>";
        			}
        			$(".form-control").html(str);
        			
        		}
        	});
        });
       

       function option(dataOne,dataTwo){
    	   var option = {
		            title: {
		                x: 'center',
		                text: $('.form-control option:checked').text(),
		                subtext: 'Rainbow bar example',
		                link: 'http://echarts.baidu.com/doc/example.html'
		            },
		            tooltip: {
		                trigger: 'item'
		            },
		            toolbox: {
		                show: true,
		                feature: {
		                    dataView: {show: true, readOnly: false},
		                    restore: {show: true},
		                    saveAsImage: {show: true}
		                }
		            },
		            calculable: true,
		            grid: {
		                borderWidth: 0,
		                y: 80,
		                y2: 60
		            },
		            xAxis: [
		                {
		                    type: 'category',
		                    show: false,
		                    data: dataOne
		                }
		            ],
		            yAxis: [
		                {
		                    type: 'value',
		                    show: false
		                }
		            ],
		            series: [
		                {
		                    name: 'ECharts例子个数统计',
		                    type: 'bar',
		                    itemStyle: {
		                        normal: {
		                            color: function(params) {
		                                // build a color map as your need.
		                                var colorList = [
		                                    '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
		                                    '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
		                                    '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
		                                ];
		                                return colorList[params.dataIndex]
		                            },
		                            label: {
		                                show: true,
		                                position: 'top',
		                                formatter: '{b}\n{c}'
		                            }
		                        }
		                    },
		                    data: dataTwo,
		                    markPoint: {
		                        tooltip: {
		                            trigger: 'item',
		                            backgroundColor: 'rgba(0,0,0,0)',
		                            formatter: function(params){
		                                return '<img src="'
		                                        + params.data.symbol.replace('image://', '')
		                                        + '"/>';
		                            }
		                        },
		                        data: [
		                            {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://../asset/ico/折线图.png'},
		                            {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://../asset/ico/柱状图.png'},
		                            {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://../asset/ico/散点图.png'},
		                            {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://../asset/ico/K线图.png'},
		                            {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://../asset/ico/饼状图.png'},
		                            {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://../asset/ico/雷达图.png'},
		                            {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://../asset/ico/和弦图.png'},
		                            {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://../asset/ico/力导向图.png'},
		                            {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://../asset/ico/地图.png'},
		                            {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://../asset/ico/仪表盘.png'},
		                            {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://../asset/ico/漏斗图.png'},
		                        ]
		                    }
		                }
		            ]
		        };
    	   return option;
       }

     