﻿/**退出系统**/
function logout(){
    if(confirm("您确定要退出本系统吗？")){
        window.location.href = "../jsp/login.jsp";
    }
}

/**获得当前日期**/
function  getDate01(){
    var time = new Date();
    var myYear = time.getFullYear();
    var myMonth = time.getMonth()+1;
    var myDay = time.getDate();
    if(myMonth < 10){
        myMonth = "0" + myMonth;
    }
    document.getElementById("yue_fen").innerHTML =  myYear + "." + myMonth;
    document.getElementById("day_day").innerHTML =  myYear + "." + myMonth + "." + myDay;
}



/* zTree插件加载目录的处理  */
var zTree;

var setting = {
    view: {
        dblClickExpand: false,
        showLine: false,
        expandSpeed: ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast"
    },
    data: {
        key: {
            name: "resourceName"
        },
        simpleData: {
            enable:true,
            idKey: "resourceID",
            pIdKey: "parentID",
            rootPId: ""
        }
    },
    callback: {
        // 				beforeExpand: beforeExpand,
        // 				onExpand: onExpand,
        onClick: zTreeOnClick
    }
};

var curExpandNode = null;
function beforeExpand(treeId, treeNode) {
    var pNode = curExpandNode ? curExpandNode.getParentNode():null;
    var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
    for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
        if (treeNode !== treeNodeP.children[i]) {
            zTree.expandNode(treeNodeP.children[i], false);
        }
    }
    while (pNode) {
        if (pNode === treeNode) {
            break;
        }
        pNode = pNode.getParentNode();
    }
    if (!pNode) {
        singlePath(treeNode);
    }

}
function singlePath(newNode) {
    if (newNode === curExpandNode) return;
    if (curExpandNode && curExpandNode.open==true) {
        if (newNode.parentTId === curExpandNode.parentTId) {
            zTree.expandNode(curExpandNode, false);
        } else {
            var newParents = [];
            while (newNode) {
                newNode = newNode.getParentNode();
                if (newNode === curExpandNode) {
                    newParents = null;
                    break;
                } else if (newNode) {
                    newParents.push(newNode);
                }
            }
            if (newParents!=null) {
                var oldNode = curExpandNode;
                var oldParents = [];
                while (oldNode) {
                    oldNode = oldNode.getParentNode();
                    if (oldNode) {
                        oldParents.push(oldNode);
                    }
                }
                if (newParents.length>0) {
                    for (var i = Math.min(newParents.length, oldParents.length)-1; i>=0; i--) {
                        if (newParents[i] !== oldParents[i]) {
                            zTree.expandNode(oldParents[i], false);
                            break;
                        }
                    }
                }else {
                    zTree.expandNode(oldParents[oldParents.length-1], false);
                }
            }
        }
    }
    curExpandNode = newNode;
}

function onExpand(event, treeId, treeNode) {
    curExpandNode = treeNode;
}

/** 用于捕获节点被点击的事件回调函数  **/
function zTreeOnClick(event, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj("dleft_tab1");
    zTree.expandNode(treeNode, null, null, null, true);
    // 		zTree.expandNode(treeNode);
    // 规定：如果是父类节点，不允许单击操作
    if(treeNode.isParent){
        // 			alert("父类节点无法点击哦...");
        return false;
    }
    // 如果节点路径为空或者为"#"，不允许单击操作
    if(treeNode.accessPath=="" || treeNode.accessPath=="#"){
        //alert("节点路径为空或者为'#'哦...");
        return false;
    }
    // 跳到该节点下对应的路径, 把当前资源ID(resourceID)传到后台，写进Session
    rightMain(treeNode.accessPath);

    if( treeNode.isParent ){
        $('#here_area').html('当前位置：'+treeNode.getParentNode().resourceName+'&nbsp;>&nbsp;<span style="color:#1A5CC6">'+treeNode.resourceName+'</span>');
    }else{
        $('#here_area').html('当前位置：系统&nbsp;>&nbsp;<span style="color:#1A5CC6">'+treeNode.resourceName+'</span>');
    }
};

/* 上方菜单 */
function switchTab(tabpage,tabid){
    var oItem = document.getElementById(tabpage).getElementsByTagName("li");
    for(var i=0; i<oItem.length; i++){
        var x = oItem[i];
        x.className = "";
    }
    if('left_tab1' == tabid){
        $(document).ajaxStart(onStart).ajaxSuccess(onStop);
        // 异步加载"业务模块"下的菜单
        loadMenu('YEWUMOKUAI', 'dleft_tab1');
    }
}


$(document).ready(function(){
    $(document).ajaxStart(onStart).ajaxSuccess(onStop);
    /** 默认异步加载"业务模块"目录  **/
    loadMenu('YEWUMOKUAI', "dleft_tab1");
    // 默认展开所有节点
    if( zTree ){
        // 默认展开所有节点
        zTree.expandAll(true);
    }
});

function loadMenu(resourceType, treeObj){
    data = [
        //个人用户管理员
        {"accessPath":"","checked":false,"delFlag":0,"parentID":1,"resourceCode":"","resourceDesc":"","resourceGrade":2,"resourceID":3,"resourceName":"超级管理员","resourceOrder":0,"resourceType":""},
        //个人用户管理下拉选项
        {"accessPath":"showAdmin.jsp","checked":false,"delFlag":0,"parentID":3,"resourceCode":"","resourceDesc":"","resourceGrade":3,"resourceID":61,"resourceName":"后台管理员列表","resourceOrder":0,"resourceType":""},
        {"accessPath":"showBill.jsp","checked":false,"delFlag":0,"parentID":3,"resourceCode":"","resourceDesc":"","resourceGrade":3,"resourceID":61,"resourceName":"账单记录","resourceOrder":0,"resourceType":""},
        {"accessPath":"changeSuperPwd.jsp","checked":false,"delFlag":0,"parentID":3,"resourceCode":"","resourceDesc":"","resourceGrade":3,"resourceID":61,"resourceName":"修改密码","resourceOrder":0,"resourceType":""},

    ];
    // 如果返回数据不为空，加载"业务模块"目录
    if(data != null){
        // 将返回的数据赋给zTree
        $.fn.zTree.init($("#"+treeObj), setting, data);
             //alert(treeObj);
        zTree = $.fn.zTree.getZTreeObj(treeObj);
        if( zTree ){
            // 默认展开所有节点
            zTree.expandAll(true);
        }
    }

}
//ajax start function
function onStart(){
    $("#ajaxDialog").show();
}

//ajax stop function
function onStop(){
    // 		$("#ajaxDialog").dialog("close");
    $("#ajaxDialog").hide();
}

$(function(){
    $('#TabPage2 li').click(function(){
        var index = $(this).index();
        $(this).find('img').attr('src', '../general/images/common/'+ (index+1) +'_hover.jpg');
        $(this).css({background:'#fff'});
        $('#nav_module').find('img').attr('src', '../general/images/common/module_'+ (index+1) +'.png');
        $('#TabPage2 li').each(function(i, ele){
            if( i!=index ){
                $(ele).find('img').attr('src', '../general/images/common/'+ (i+1) +'.jpg');
                $(ele).css({background:'#044599'});
            }
        });
        // 显示侧边栏
        switchSysBar(true);
    });

    // 显示隐藏侧边栏
    $("#show_hide_btn").click(function() {
        switchSysBar();
    });
});

/**隐藏或者显示侧边栏**/
function switchSysBar(flag){
    var side = $('#side');
    var left_menu_cnt = $('#left_menu_cnt');
    if( flag==true ){	// flag==true
        left_menu_cnt.show(500, 'linear');
        side.css({width:'280px'});
        $('#top_nav').css({width:'77%', left:'304px'});
        $('#main').css({left:'280px'});
    }else{
        if ( left_menu_cnt.is(":visible") ) {
            left_menu_cnt.hide(10, 'linear');
            side.css({width:'60px'});
            $('#top_nav').css({width:'100%', left:'60px', 'padding-left':'28px'});
            $('#main').css({left:'60px'});
            $("#show_hide_btn").find('img').attr('src', '../general/images/common/nav_show.png');
        } else {
            left_menu_cnt.show(500, 'linear');
            side.css({width:'280px'});
            $('#top_nav').css({width:'77%', left:'304px', 'padding-left':'0px'});
            $('#main').css({left:'280px'});
            $("#show_hide_btn").find('img').attr('src', '../general/images/common/nav_hide.png');
        }
    }
}