<%-- 
    Document   : addProduct     for adding an amount of a chosen product to the
                                customer's order.
    Author     : adath325
    Version    : 3.0
--%>

<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add to Cart</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>How many do you want to buy?</h1>
        <%          
Product product = (Product) (currentSession.getAttribute("product"));
        %>
        <table>
            <tr>
                <td>ID</th>
                <td><%=product.getProductID()%>
            </tr>
            <tr>
                <td>Description</th>
                <td><%=product.getDescription()%></td>
            </tr>
            <tr>
                <td>Price</th>
                <td><%=product.getPrice()%></td>
            </tr>
            <tr>
                <td>Quantity available</th>
                <td><%=product.getQuantity()%></td>
            </tr>
        </table>
    </body>
</html>
