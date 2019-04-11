<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/reset.css"/>
<link rel="stylesheet" href="../css/accountCSS.css"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<div style="width: 100%;height: 100%;background-color: #788EDA">
    <div class="col-md-8 col-md-offset-2" style="position: absolute;top:15%">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">输入投票信息</h3>
            </div>
            <div class="panel-body" style="text-align: center;">
                <fieldset>
                    <label>投票主题：</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" placeholder="投票主题…" name="title"><br/><br/>
                    <label>子选项个数：</label>
                    <select id="chose">
                    	<option value="0">选着投票个数</option>
                    	<option value="1">1</option>
                    	<option value="2">2</option>
                    	<option value="3">3</option>
                    	<option value="4">4</option>
                    	<option value="5">5</option>
                    </select><br/><br/>
                    <div id="context">
                        
                    </div>
                    <label>投票类型：</label>
                    <select id="sin"><option value="1">单选</option><option value="0">复选</option></select><br/><br/>
                    <label>是否开放：</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <select id="pub"><option value="1">是</option><option value="0">否</option></select><br/><br/>
                    <br/>
                    <button type="button" class="sure">确定</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" class="clear">重置</button>
                </fieldset>
            </div>
        </div>
    </div>
</div>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/new.js"></script>