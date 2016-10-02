<%-- 
    Document   : checkout   displays the customer's chosen items and asks for
                            confirmation.
    Author     : adath325
    Version    : 4.0
--%>

<%@page import="domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.OrderItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Checkout</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <%
            Order order = (Order) currentSession.getAttribute("order");
            ArrayList<OrderItem> items = order.getItems();
            %>
        <h1>Shopping cart</h1>
        <p>Your order currently consists of:</p>
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            <%
                for (OrderItem item : items) {
            %>
                <tr>
                    <td><%=item.getProduct()%></td>
                    <td><%=format.format(item.getProduct().getPrice())%></td>
                    <td><%=item.getQuantityPurchased()%></td>
                    <td><%=format.format(item.getItemTotal())%></td>
                </tr>
            <% }%>
            <tr class="emph">
                <td>Total cost</td>
                <td></td>
                <td></td>
                <td><%=format.format(order.getTotal())%></td>
            </tr>
        </table>
        <form id="checkoutForm" action="Confirmation" method="post">
            <input type="submit" name="checkout" id="checkout" 
                   value="Checkout Order">
        </form><br>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
