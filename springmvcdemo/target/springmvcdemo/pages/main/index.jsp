<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xueyunlong
  Date: 2016/9/6
  Time: 22:30
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
        <form method="post" name="shoping" action="addCart">
            <table>
                <tr class="title">
                    <th class="checker"></th>
                    <th>书名</th>
                    <th class="info">简介</th>
                    <th class="price">价格</th>

                    <th class="view">图片预览</th>
                </tr>

                <c:forEach var="book" items="${books}" >
                    <tr>
                        <td><input type="checkbox" id="bookid" name="bookid" value="${book.id}" /></td>
                        <td class="title">${book.title}</td>
                        <td class="info">${book.describe}</td>
                        <td>￥${book.price}</td>
                        <td class="thumb"><img src="${book.face}"/></td>
                    </tr>
                </c:forEach>


            </table>
            <div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
        </form>
    </div>
</div>
</body>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有，
</div>
</html>
