<%-- 
    Document   : Error422
    Created on : 20/09/2016, 2:55:49 PM
    Author     : adath325
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>422</title>
    </head>
    <body>
        <h1>422 Error</h1>
        <p><%=request.getAttribute("javax.servlet.error.message")%></p>
        <a href="javascript:history.back()">Back</a>
    </body>
</html>
