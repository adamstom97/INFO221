<%-- 
    Document   : checkout   displays the customer's chosen items and asks for
                            confirmation.
    Author     : adath325
    Version    : 3.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Shopping cart</h1>
        <p>Your order currently consists of:</p>
        <form action="Confirmation" method="post">
            <input type="submit" name="checkout" value="Checkout Order">
        </form>
    </body>
</html>
