<%--
  Created by IntelliJ IDEA.
  User: Xueyunlong
  Date: 2016/9/9
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网上书城</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<script type="text/javascript">
    //全部输入项非空检查
    //检查用户名是否存在
    function isUsernameLegal(){
        var username = document.getElementById("username").value;
        var usernull = document.getElementById("usernull");
        if(username == null || username == ""){
            usernull.innerHTML = "<font color=\"red\">用户名不能为空！</font>"
            return false;
        }
        return true;
    }
    //检查密码内容位数
    function isPasswordLegal(){
        var password = document.getElementById("password").value;
        var pwdnull = document.getElementById("nullpassword");

        if(password == null || password == ""){
            pwdnull.innerHTML = "<font color=\"red\">密码不能为空！</font>"
            return false;
        }else if(password.length < 8){
            pwdnull.innerHTML = "<font color=\"red\">密码长度小于8位！！</font>"
            return false;
        }else
            pwdnull.innerHTML = ""
        return true;
    }
    //检查密码是否一致
    function isRepasswordLegal(){
        var repassword = document.getElementById("rePassword").value;
        var password = document.getElementById("password").value;
        var pwdnull = document.getElementById("nullrePassword");

        if(repassword == null || repassword == ""){
            pwdnull.innerHTML = "<font color=\"red\">确认密码不能为空！</font>"
            return false;
        }else if(repassword != password){
            pwdnull.innerHTML = "<font color=\"red\">两次密码输入不一致！</font>"
            return false;
        }else
            pwdnull.innerHTML = ""
        return true;
    }
    //检查邮箱格式是否正确
    function isEmailLegal(){
        var email = document.getElementById("email").value;
        var emailnull = document.getElementById("nullemail");

        var regEx = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z_-]+)+$/;

        if(email == null || email == ""){
            emailnull.innerHTML = "<font color=\"red\">邮箱不能为空！</font>"
            return false;
        }else if(!regEx.test(email)){
            emailnull.innerHTML = "<font color=\"red\">邮箱格式不正确！</font>"
            return false;
        }else
            emailnull.innerHTML = ""
        return true;
    }

    function check(){
        var username = document.getElementById("username");
        if(!isUsernameLegal()){
            username.focus();
            return false;
        }else if(!isPasswordLegal()){
            username.focus();
            return false;
        }
        else if(!isRepasswordLegal()){
            username.focus();
            return false;
        }
        else if(!isEmailLegal()){
            username.focus();
            return false;
        }
        return true;
    }
</script>

<body>
<div id="container">
    <div id="header" class="wrap">
        <div id="banner"></div>
        <div id="navbar">
        </div>
    </div>
    <div id="register">
        <div class="title">
            <h2>欢迎注册网上书城</h2>
        </div>
        <div class="steps">
            <ul class="clearfix">
                <li class="current">1.填写注册信息</li>
                <li class="unpass">2.注册成功</li>
            </ul>
        </div>
        <form method="post" action="roRegister" onsubmit="return check()"  >
            <dl>
                <dt>用 户 名：</dt>
                <dd><input class="input-text" type="text" id="username" name="username" onblur="isUsernameLegal()"/><span id="usernull"></span></dd>
                <dt>密　　码：</dt>
                <dd><input class="input-text" type="password" id="password" name="password" onblur="isPasswordLegal()" /><span id="nullpassword"><font color=\"green\">密码至少8位</font></span><span id="simplepassword"></span></dd>
                <dt>确认密码：</dt>
                <dd><input class="input-text" type="password" id="rePassword" name="rePassword" onblur="isRepasswordLegal()" /><span id="nullrePassword"></span><span id="uneq"></span></dd>
                <dt>Email地址：</dt>
                <dd><input class="input-text" type="text" id="email" name="email" onblur="isEmailLegal()" /><span id="nullemail"><font color=\"green\">请输入正确格式的邮箱</font></span><span id="errorInput"></span></dd>
                <dt></dt>
                <dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
            </dl>
        </form>
    </div>
    <div id="footer" class="wrap">
        网上书城 &copy; 版权所有
    </div>
</body>
</html>
</div>

