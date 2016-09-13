<%-- 
    Document   : displayProducts
    Created on : 13/09/2016, 2:38:41 PM
    Author     : adath325
--%>

<%@page import="java.util.Collection"%>
<%@page import="dao.ProductDB"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Products</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <%
            ProductDB list = new ProductDB();
            Collection<Product> products = list.getProductList();
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th></th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <%
                for (Product product : products) {
            %>
            <tr>
                <td><%=product.getProductID()%></td>
                <td><%=product.getName()%></td>
                <td><%=product.getDescription()%></td>
                <td><%=product.getCategory()%></td>
                <td><%=product.getPrice()%></td>
                <td><%=product.getQuantity()%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
