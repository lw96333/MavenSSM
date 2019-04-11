<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/reset.css"/>
<link rel="stylesheet" href="../css/accountCSS.css"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<div style="width: 100%;height: 100%;background-color: #788EDA">
    <div class="col-md-8 col-md-offset-2" style="position: absolute;top:15%">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">修改管理员员</h3>
            </div>
            <div class="panel-body" style="text-align: center;">
                <fieldset>
                    <label>输入老密码：</label>
                    <input type="text" placeholder="输入老密码…" name="oldPwd"><br/><br/>
                    <label>输入新密码：</label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="password" placeholder="输入新密码…" name="newPwd1"><br/><br/>
                    <label>再次输入密码：</label>
                    <input type="password" placeholder="再次输入密码…" name="newPwd2"><br/><br/>
                    <br/><br/><br/>
                    <button type="button" class="sure">确定</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" class="btn">重置</button>
                </fieldset>
            </div>
        </div>
    </div>
</div>
<input type="hidden" value='${admin.password}' name="password"/>
<script src="../js/jquery-1.7.2.min.js"></script>
<script src="../js/updateAccount.js"></script>