<%-- 
    Document   : index      home page of the site.
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Home</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Welcome to TheShop.com</h1>
        <figure>
            <img src="img/shop.jpg" alt="TheShop.com illustration">
        </figure>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
