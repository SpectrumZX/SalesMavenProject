<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
<style>
   <%@include file='./css/form.css' %>
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>   
    <form method="GET" action="saveSale.htm"> 
        <input type="hidden" name="action" value="${action}" />
        <input type="hidden" name="id" value="${sale.id}" />
        
      <table border="0">
        <tr>
          <td colspan="2">Id: ${sale.id}</td>
        </tr>
        <tr>
            
          <td>Выберите товар: </td>
          <td><select name="goods_id">
            <option value="${current_goods.id}" selected>${current_goods.name}</option>
            <c:forEach items="${goodsList}" var="goods">
              <option value="${goods.id}">${goods.name}</option>
            </c:forEach>
          </select></td>
        </tr>
        <tr>
          <td>Количество: </td>
          <td><input type="text" name="number" value="${sale.number}" /></td>
        </tr>
        <tr>
          <td>Cтоимость: </td>
          <td><input type="text" name="cost" value="${sale.cost}" /></td>
        </tr>
        <tr>
          <td>Дата: </td>
          <td><input type="text" name="date" value="${sale.date}" /></td>
        </tr>
          <tr>
              <td colspan="2" style="text-align: center"><p/><br/><input type="submit"  value="Сохранить"/>
            </td>
        </tr>
      </table>            
      </form>
        <a href="sales.htm">< к списоку продаж</a><p/>
    </body>
</html>