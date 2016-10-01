<%-- 
    Document   : Error500
    Created on : 20/09/2016, 2:11:24 PM
    Author     : adath325
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
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
