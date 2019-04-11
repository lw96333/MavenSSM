<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/reset.css"/>
<link rel="stylesheet" href="../css/accountCSS.css"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<div style="width: 100%;height: 100%;background-color: #788EDA">
    <div class="col-md-8 col-md-offset-2" style="position: absolute;top:15%">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">查找投票</h3>
            </div>
            <div class="panel-body" style="text-align: center;">
                <fieldset>
                    <label>输入查找内容：</label>
                    <input type="text" placeholder="输入条件…" name="condition"><br/><br/>
                     <div id="context"></div>
                    <br/><br/><br/>
                    <button type="button" class="btn">确定</button>
                </fieldset>
               
            </div>
        </div>
    </div>
</div>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/select.js"></script>