<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
   <%@include file='./css/styles.css' %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Товары</title>
</head>
<body>
<h1>Товары</h1>
 
<table>
 <thead>
  <tr>
   <th>id</th>
   <th>Наименование</th>
   <th>Цена</th>
    <th>Кол-во продаж</th>
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
   <td><c:out value="00" /></td>
   <td><a href="goodsEdit.htm?id=${goods.id}">Edit</a></td>
   <td><a href="delGoods.htm?id=${goods.id}">Delete</a></td>
  </tr>
 </c:forEach>
 </tbody>
</table>
 <p/>
 <a href="goodsNew.htm">Создать новый товар</a><p/>
  <a href="sales.htm">Список продаж</a>

 
</body>
</html>