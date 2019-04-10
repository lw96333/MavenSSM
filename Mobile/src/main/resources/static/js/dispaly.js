// 基于准备好的dom，初始化echarts图表
		var li;
		
        $(function(){
        	$.ajax({
        		type:"post",
        		url:"selectMobileForfigure",
        		dataType:"json",
        		success:function(data){
        			
        			li = data.data.li;
        			console.log(li);
        			load(li,1);
  			      pageJs(li.length,li.length/10,5);
        		}
        	});
        });
        	
        function load(li,pageNum){
        	var dataOne = new Array();
    		var dataTwo = new Array();
			for(var index = (pageNum-1)*10;index < pageNum*10;index++){
				dataOne.push(li[index].city);
				dataTwo.push(li[index].num);
			}

			var myChart = echarts.init(document.getElementById('main'));
		      // 为echarts对象加载数据
		      myChart.setOption(option(dataOne,dataTwo));
        }

       function option(dataOne,dataTwo){
    	   var option = {
		            title: {
		                x: 'center',
		                text: $('.form-control option:checked').text(),
		                subtext: '统计数据',
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
       
       function pageJs(totalSize,totalPage,showPageNum){
			$("#pagination_2").whjPaging({
	 	         css: 'css-2',
	 	         pageSizeOpt: [
	 	             {value: 5, text: '5/page', selected: true},
	 	             {value: 10, text: '10/page'},
	 	             {value: 15, text: '15/page'},
	 	             {value: 20, text: '20/page'}
	 	         ],
	 	        	totalSize: totalSize,
	 	         totalPage: totalPage,
	 	         showPageNum: showPageNum,
	 	         firstPage: '首页',
	 	         previousPage: '上一页',
	 	         nextPage: '下一页',
	 	         lastPage: '尾页',
	 	         skip: '',
	 	         confirm: '跳转',
	 	         refresh: 'refresh',
	 	         totalPageText: '共 {} 页',
	 	         totalSizeText: "共 {} 条",
	 	         isShowFL: true,
	 	         isShowSkip: true,
	 	         isResetPage: false,
	 	         isShowRefresh: false,
	 	         isShowTotalPage: true,
	 	         isShowTotalSize: true,
	 	         isShowPageSizeOpt: false,
	 	         callBack: function (currPage, pageSize) {
	 	        	load(li,currPage);
	 	         }
	 	     });
		}
			
	

     