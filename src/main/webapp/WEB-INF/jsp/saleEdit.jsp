<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
        <form method="GET" action="saveSale.htm"> 
        <input type="hidden" name="action" value="${action}" />
        <input type="hidden" name="id" value="${id}" />
        Id: ${id}<p/>
        goodsId: <input type="text" name="goods_id" value="${sale.goodsId}" /><p/>
        Количество: <input type="text" name="number" value="${sale.number}" /><p/>
        стоимость: <input type="text" name="cost" value="${sale.cost}" /><p/>
        Дата: <input type="text" name="date" value="${sale.date}" /><p/>
        
            <input type="submit"  value="Сохранить"/>
        </form>
    </body>
</html>