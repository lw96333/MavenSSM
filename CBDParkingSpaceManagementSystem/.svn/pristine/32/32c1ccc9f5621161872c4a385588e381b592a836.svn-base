   $(function(){
       $("#bodyTr").on("click",".ml-add",function(){
       	member_edit('添加','jsp/backstage/spuer/AddAdmin.jsp','4','','510');
       });
       $("#bodyTr").on("click",".ml-update",function(){
       	member_edit('编辑','jsp/backstage/spuer/UpdataAdmin.jsp?id='+$(this).attr("id"),'4','','510');
       });
       $("#bodyTr").on("click",".ml-del",function(){
       	member_del(this,$(this).attr("id"));
       });
       $.ajax({
       	type:"post",
       	url:"selectAdmin",
       	data:{
       		"pageNum":1,
       		"pageSize":5
       	},
       	dataType:"json",
       	success:function(data){
       		display(data.data);
       		pageJs(data.data.pageAdmin.total,data.data.pageAdmin.pages,data.data.pageAdmin.size);
       	}
       });	

   });
  
   /* 分页显示*/
   function pageJs(totalSize,totalPage,showPageNum){
   	
       $("#pagination_2").whjPaging({
           css: 'css-2',
           totalSize: totalSize,
           totalPage: totalPage,
           showPageNum: showPageNum,
           firstPage: '首页',
           previousPage: '上一页',
           nextPage: '下一页',
           lastPage: '尾页',
           skip: '',
           confirm: '跳转',
           refresh: '刷新',
           totalPageText: '总共 {} 页',
           totalSizeText: "总共 {} 条",
           isShowFL: true,
           isShowSkip: true,
           isResetPage: false,
           isShowRefresh: false,
           isShowTotalPage: true,
           isShowTotalSize: true,
           isShowPageSizeOpt: false,
           callBack: function (currPage,pageSize) {
           	
               $.ajax({
                   type:"post",
                   url:"selectAdmin",
                   data:{
                   	"pageNum":currPage,
               		"pageSize":5
                   },
                   dataType : 'json',
                   success:function(data){
                   	display(data.data);
                      
                   }
               });
           }
       });
       
       
   }
   /* 显示数据 */
   function display(data){
   	var str = "";
   	
   	var admin = data.pageAdmin.records;
   	var power = data.power;
   	for(var index = 0;index < admin.length; index++){
   		str += "<tr class='text-c'>";
   		str += "<td>"+ admin[index].jobnumber +"</td>";
   		str += "<td>"+ admin[index].name +"</td>";
   		str += "<td>"+ admin[index].phone +"</td>";
   		str += "<td>";
   		var pwoer = power[admin[index].adminid];
   		var falg = true;
   		for(var i = 0;i< pwoer.length ;i++){
			
   			if(pwoer[i]==4){
   				str += " 个人用户权限  ";
   			} else if(pwoer[i]==5){
   				str += " 租约管理权限  ";
   			}  else if(pwoer[i]==6){
   				str += " 外部合约管理权限  ";
   			}  else if(pwoer[i]==7){
   				str += " 车位管理权限  ";
   			}  else if(pwoer[i]==3){
   				str += " 超级管理员权限  ";
   				falg =false;
   			}
   		}
   		str += "</td>"
   		if(falg){
	   		str += "<td class='td-manage'>";
	   		str += "<a title='编辑'href='javascript:;' id='"+admin[index].adminid+"'";
	   		str += "class='ml-update' style='text-decoration: none'><i class='Hui-iconfont'>&#xe60c;</i></a> ";
	   		str += "<a title='删除'href='javascript:;' class='ml-del' id='"+admin[index].adminid+"'";
	   		str += "style='text-decoration: none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
	   		str += "</td>"
   			
   		}else{
   			str+="<td></td>"
   		}
   		str += "</tr>";
   	}
   	
   	$("#bodyTr").html(str);
   	
   	
   }
   /*用户-添加*/
   function member_add(title,url,w,h){
       layer_show(title,url,w,h);
   }
   /*用户-查看*/
   function member_show(title,url,id,w,h){
       layer_show(title,url,w,h);
   }
   /*用户-停用*/
   function member_stop(obj,id){
       layer.confirm('确认要停用吗？',function(index){
           $.ajax({
               type: 'POST',
               url: '',
               dataType: 'json',
               success: function(data){
                   $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                   $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                   $(obj).remove();
                   layer.msg('已停用!',{icon: 5,time:1000});
               },
               error:function(data) {
                   console.log(data.msg);
               },
           });
       });
   }

   /*用户-启用*/
   function member_start(obj,id){
       layer.confirm('确认要启用吗？',function(index){
           $.ajax({
               type: 'POST',
               url: '',
               dataType: 'json',
               success: function(data){
                   $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                   $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                   $(obj).remove();
                   layer.msg('已启用!',{icon: 6,time:1000});
               },
               error:function(data) {
                   console.log(data.msg);
               },
           });
       });
   }
   /*用户-编辑*/
   function member_edit(title,url,id,w,h){
       layer_show(title,url,w,h);
   }
   /*密码-修改*/
   function change_password(title,url,id,w,h){
       layer_show(title,url,w,h);
   }
   /*用户-删除*/
   function member_del(obj,id){
       layer.confirm('确认要删除吗？',function(index){
           $.ajax({
               type: 'POST',
               url: 'super/deleteAdmin',
               dataType: 'json',
               data:{
               	"adminId":id
               },
               success: function(data){
                   layer.msg('已删除!',{icon:1,time:1000});
                   pageJs(data.data.pageAdmin.total,data.data.pageAdmin.pages,data.data.pageAdmin.size);
               	display(data.data);
               },
               error:function(data) {
                   console.log(data.msg);
               },
           });
       });
   }