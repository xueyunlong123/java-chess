<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xueyunlong
  Date: 2016/9/7
  Time: 17:13
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
<jsp:include page="/pages/public/header.jsp"></jsp:include>
<div id="content" class="wrap">
    <div class="list bookList">
        <form method="post" name="shoping" action="addOrder">
            <table>
                <tr class="title">
                    <th class="view">图片预览</th>
                    <th>书名</th>
                    <th class="nums">数量</th>
                    <th class="price">价格</th>
                    <th class="nums">合计</th>
                </tr>
                <input type="hidden" name="carts" value="${carts}"/>
                <c:forEach var="cart" items="${carts}">
                    <tr>
                        <td class="thumb"><img src="${cart.face}" /></td>
                        <td class="title">${cart.title}</td>
                        <td>${cart.counts}</td>
                        <td>￥${cart.price}</td>
                        <td>
                            ￥${cart.totalprice}

                        </td>
                    </tr>
                </c:forEach>



                <tr>
                    <td>收货人：
                        <input type="text" id="receiver" name="receiver" onblur="isUsernameLegal()"/>
                    </td>
                    <td>收货地址：
                        <input type="text" id="raddress" name="raddress" onblur="isPasswordLegal()"/>
                    </td>
                    <td>
                        联系电话：
                        <input type="text" id="rphone" name="rphone" onblur="isPasswordLegal()"/>
                    </td>
                </tr>
                <tr><td colspan="5">
                    <input type="hidden" name="total" value="141.5"/>
                    <div class="button">
                        <h4>总价：￥${total_price}元</h4>
                        <input type="hidden" id="hidden_total_price" name="hidden_total_price" value="${total_price}"/>
                        <input class="input-chart" type="submit" name="submit" value="" />
                    </div>
                </td></tr>

            </table>
        </form>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>

</body>
</html>


