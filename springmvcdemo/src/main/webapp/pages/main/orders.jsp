<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xueyunlong
  Date: 2016/9/7
  Time: 17:17
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


<body>

<body></body>
<jsp:include page="/pages/public/header.jsp"></jsp:include>
<div id="content" class="wrap">
    <div class="list orderList">
        <table>
            <tr class="title">
                <th class="orderId">订单编号</th>


                <th class="createTime">下单时间</th>
                <th class="status">总价</th>
                <th>收货人</th>
            </tr>

           <c:forEach var="order" items="${orders}">

               <tr onclick="orderDetail(${order.id})">
                   <td style="width:15%;text-align:center;">${order.id}</td>
                   <td style="width:15%;text-align:center;">${order.buydate}</td>
                   <td style="width:20%;text-align:center;">${order.totalprice}</td>
                   <td style="width:15%;text-align:center;">${order.receiver}</td>
               </tr>
           </c:forEach>
        </table>
    </div>
</div>
</body>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>
<script>
    function orderDetail(id){

        window.location.href="orderdetail?id="+id

    }
</script>
</html>



