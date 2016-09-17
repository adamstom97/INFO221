<%-- 
    Document   : createAccount
    Created on : 6/09/2016, 3:23:39 PM
    Author     : adath325
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </body>
</html>
