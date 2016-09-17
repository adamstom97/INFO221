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
        <h1>Products</h1>
        <nav>
            Categories:
            <ul>
                <li><a href="browseProducts.jsp">All</a></li>
                <li><a href="browseProducts.jsp?category=Fruit">Fruit</a></li>
                <li><a href="browseProducts.jsp?category=Vegetable">Vegetables</a></li>
            </ul>
        </nav>
        <%            Collection<Product> products;
            String category = (String) request.getParameter("category");
            if (category == null) {
                products = new ProductDB().getProductList();
            } else {
                products = new ProductDB().getProductsByCategory(category);
            }
        %>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Available</th>
                <th></th>
            </tr>
            <%
                for (Product product : products) {
            %>
            <form action="AddProduct" method="post">
            <tr>
                <td><%=product.getName()%></td>
                <td><%=product.getDescription()%></td>
                <td><%=product.getPrice()%></td>
                <td><%=product.getQuantity()%></td>
                <td><input type="submit" name="productSelect" value="Buy"></td>
            </tr>
            </form>
            <% }%>
        </table>
    </body>
</html>
