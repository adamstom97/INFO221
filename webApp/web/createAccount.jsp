<%-- 
    Document   : createAccount
    Author     : adath325
    Version    : 4.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Create Account</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>Create an Account</h1>
        <form action="CreateAccount" method="post">
            <fieldset>
                <legend>Account Details</legend>
                <label for="username">Username:</label>
                <input type="text" name="userName"><br>
                <label for="name">Name:</label>
                <input type="text" name="name"><br>
                <label for="email">Email:</label>
                <input type="text" name="email"><br>
                <label for="address">Address:</label>
                <input type="text" name="address"><br>
                <label for="creditcard">Credit Card:</label>
                <input type="text" name="creditCardDetails"><br>
                <label for="password">Password:</label>
                <input type="password" name="password"><br>
                <input type="submit" name="create" value="Create Account">
            </fieldset>
        </form>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
