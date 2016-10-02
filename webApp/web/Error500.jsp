<%-- 
    Document   : Error500
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>500</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>500 Error</h1>
        <p>Sorry, something went wrong.</p>
        <a href="javascript:history.back()">Back</a>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
