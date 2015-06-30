<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
   
        <form method="GET" action="saveGoods.htm"> 
        <input type="hidden" name="action" value="${action}" />
        <input type="hidden" name="id" value="${id}" />
        <table border="0">
          <tr>
            <td colspan="2">Id: ${id}</td>
          </tr>
          <tr>
            <td>Название товара:</td>
            <td><input type="text" name="name" value="${goods.name}" /></td>
          </tr>
          <tr>
            <td>Цена руб: </td>
            <td><input type="text" name="price" value="${goods.price}" /></td>
          </tr>
          <tr>
            <td colspan="2" style="text-align: center"><p/><br/><input type="submit"  value="Сохранить"/></td>
          </tr>
      </table>    
    </form>
          <a href="goods.htm">< к списоку товаров</a><p/>
    </body>
</html>