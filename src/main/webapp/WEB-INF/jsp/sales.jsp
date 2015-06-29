<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@include file='./css/styles.css' %>
        </style>
        <title>Продажи</title>
    </head>
    <body>
        <h1>Продажи</h1>

        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>goods_id</th>
                    <th>Кол-во</th>
                    <th>Стоимость</th>
                    <th>Дата</th>
                    <th colspan="3"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${salesList}" var="sale">
                    <tr>
                        <td><c:out value="${sale.id}" /></td>
                        <td><c:out value="${sale.goodsId}" /></td>
                        <td><c:out value="${sale.number}" /></td>
                        <td><c:out value="${sale.cost} руб." /></td>
                        <td><c:out value="${sale.date}" /></td>
                        <td><a href="#">Edit</a></td>
                        <td><a href="del_sales.htm?id=${sale.id}">Delete</a></td>
                        <td><a href="#">Add</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p/>
        <a href="#">Добавить продажу</a> <p/>
        <a href="goods.htm">Список товаров</a>

    </body>
</html>