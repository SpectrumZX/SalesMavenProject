<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@include file='./css/list.css' %>
        </style>
        <title>Продажи</title>
    </head>
    <body>
        <div class="bod">
        <h1>Продажи</h1>
    
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Наименование</th>
                    <th>Количество</th>
                    <th>Стоимость</th>
                    <th>Дата</th>
                    <th colspan="3"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${salesList}" var="sale">
                    <tr>
                        <td><c:out value="${sale.id}" /></td>
                        <td><c:out value="${sale.getNameOfGoods()}" /></td>
                        <td><c:out value="${sale.number}" /></td>
                        <td><c:out value="${sale.cost} руб." /></td>
                        <td><c:out value="${sale.date}" /></td>
                        <td><a href="saleEdit.htm?id=${sale.id}">Edit</a></td>
                        <td><a href="delSale.htm?id=${sale.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
   
        <p/>
        <a href="goodsNew.htm">Добавить новый товар</a><p/>
        <a href="saleNew.htm">Добавить новую продажу</a> <p/>
        <a href="goods.htm">Список товаров</a>
</div>
    </body>
</html>