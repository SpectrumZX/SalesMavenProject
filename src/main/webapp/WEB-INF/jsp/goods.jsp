<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
   <%@include file='./css/list.css' %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Товары</title>
</head>
<body>
    <div class="bod">
<h1>Товары</h1>
 
<table>
 <thead>
  <tr>
   <th>id</th>
   <th>Наименование</th>
   <th>Цена</th>
    <th>Продажи (шт)</th>
   <th colspan="3"></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${goodsList}" var="goods">
  <tr>
   <td><c:out value="${goods.id}" />
   </td>
   <td><c:out value="${goods.name}" /></td>
   <td><c:out value="${goods.price} руб." /></td>
   <td><a href="sales_select.htm?id=${goods.id}">${goods.getCountSales()}</a></td>
   <td><a href="goodsEdit.htm?id=${goods.id}">Edit</a></td>
   <td><a href="delGoods.htm?id=${goods.id}">Delete</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
 <p/>
 <a href="goodsNew.htm">Добавить новый товар</a><p/>
 <a href="saleNew.htm">Добавить новую продажу</a> <p/>
  <a href="sales.htm">Список продаж</a>

 </div>
</body>
</html>