<%--
  Created by IntelliJ IDEA.
  User: Xueyunlong
  Date: 2016/9/8
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header" class="wrap">
    <div id="banner"></div>
    <div id="navbar">
        <div class="userMenu">
            <ul>
                <li class="current"><font color="BLACK">欢迎您，<strong>${cookie.username.value}</strong></font>&nbsp;&nbsp;&nbsp;</li>
                <li><a href="index">首页</a></li>
                <li><a href="orders">我的订单</a></li>
                <li><a href="cart">购物车</a></li>
                <li><a href="logout">注销</a></li>
            </ul>
        </div>
    </div>
</div>

