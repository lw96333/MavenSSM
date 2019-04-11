<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/reset.css"/>
<link rel="stylesheet" href="../css/accountCSS.css"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<div style="width: 100%;height: 100%;background-color: #788EDA">
    <div class="col-md-8 col-md-offset-2" style="position: absolute;top:15%">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title"></h3>
            </div>
            <div class="panel-body" style="text-align: center;">
                <fieldset>
                    <label><a href="javascript:(void)" id="add">新增一个选项</a></label><br/><br/>
                    <div id="context">
                        
                    </div>
                    <label>投票类型：</label>
                    <input type="radio" name="sin" id="sinA" value="1">单选&nbsp;&nbsp;<input type="radio" name="sin" id="sinB" value="0">复选<br/><br/>
                    <label>是否开放：</label>
                    <input type="radio" name="pub" id="pubA" value="1">是&nbsp;&nbsp;<input type="radio" name="pub" id="pubB" value="0">否<br/><br/>
                    <button type="button" class="btn">更新</button>
                </fieldset>
            </div>
        </div>
    </div>
</div>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/updateManage.js"></script>