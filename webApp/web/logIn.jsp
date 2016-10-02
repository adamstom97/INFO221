<%-- 
    Document   : logIn
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Log in</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Log In</h1>
        <p>Please log in to continue.</p>
        <form action="LogIn" method="post">
            <fieldset>
                <legend>Login details</legend>
                <label for="username">Username:</label>
                <input type="text" name="userName"><br>
                <label for="password">Password:</label>
                <input type="password" name="password"><br>
                <input type="submit" name="create" value="Log in">
            </fieldset>
        </form>
        <p>If you don't have an account then you can <a href='createAccount.jsp'
                                                        >create one</a>.</p>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
