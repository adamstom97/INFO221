<%-- 
    Document   : confirmation   confirms that the customer's order has gone
                                through
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Confirmation</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Thank you for your order</h1>
        <p>We have e-mailed the details of your order to your registered e-mail 
            address.</p>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
