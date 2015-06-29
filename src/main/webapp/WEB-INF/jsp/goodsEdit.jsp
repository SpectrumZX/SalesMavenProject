<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
        <form method="GET" action="saveGoods.htm"> 
        <input type="hidden" name="action" value="${action}" />
        <input type="hidden" name="id" value="${id}" />
        Id: ${id}<p/>
        Название товара: <input type="text" name="name" value="${goods.name}" /><p/>
        Цена руб: <input type="text" name="price" value="${goods.price}" /><p/>
        
            <input type="submit"  value="Сохранить"/>
        </form>
    </body>
</html>