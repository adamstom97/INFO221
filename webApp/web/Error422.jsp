<%-- 
    Document   : Error422
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>422</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>422 Error</h1>
        <p><%=request.getAttribute("javax.servlet.error.message")%></p>
        <a href="javascript:history.back()">Back</a>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
