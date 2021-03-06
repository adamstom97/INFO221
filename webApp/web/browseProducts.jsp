<%-- 
    Document   : displayProducts
    Author     : adath325
    Version    : 4.0
--%>

<%@page import="dao.ProductDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="dao.ProductDB"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Display Products</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Products</h1>
        <nav>
            Categories:
            <ul>
                <li><a href="browseProducts.jsp">All</a></li>
                    <%
                        Collection<String> categories = list.getCategoryList();
                        for (String category : categories) {
                    %>
                <li><a href="browseProducts.jsp?category=<%=category%>">
                        <%=category%></a></li>
                    <%
                        }
                    %>
            </ul>
        </nav>
        <%            Collection<Product> products;
            String category = (String) request.getParameter("category");
            if (category == null) {
                products = list.getProductList();
            } else {
                products = list.getProductsByCategory(category);
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
            <form action="BuyProduct" method="post">
                <tr>
                    <input type="hidden" name="productID" value=
                           "<%=product.getProductID()%>" />
                    <td><%=product.getName()%></td>
                    <td><%=product.getDescription()%></td>
                    <td><%=format.format(product.getPrice())%></td>
                    <td><%=product.getQuantity()%></td>
                    <td><input type="submit" name="productSelect" 
                               value="Buy"></td>
                </tr>
            </form>
            <% }%>
        </table>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
