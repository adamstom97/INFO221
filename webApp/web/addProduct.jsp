<%-- 
    Document   : addProduct     for adding an amount of a chosen product to the
                                customer's order.
    Author     : adath325
    Version    : 4.0
--%>

<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Add to Cart</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <%            Product product = (Product) (currentSession.getAttribute(
                "product"));
        %>
        <h1>How many <%=product.getName()%>s do you want to buy?</h1>
        <table>
            <tr>
                <td class="th">ID</td>
                <td><%=product.getProductID()%></td>
            </tr>
            <tr>
                <td class="th">Description</td>
                <td><%=product.getDescription()%></td>
            </tr>
            <tr>
                <td class="th">Price</td>
                <td><%=product.getPrice()%></td>
            </tr>
            <tr>
                <td class="th">Quantity available</td>
                <td><%=product.getQuantity()%></td>
            </tr>
        </table>
            <form action="AddProduct" method="post">
                <fieldset>
                    <legend>Select quantity</legend>
                    <label for="quantity">How many?</label>
                    <input type="text" id="quantity" name="quantity"><br>
                    <input type="submit" name="quantitySelect" 
                           value="Add to Cart">
                </fieldset>
            </form>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
