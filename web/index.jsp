<%-- 
    Document   : index
    Created on : Apr 12, 2021, 1:51:03 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Index</h1>
        <a>${requestScope.UserGoogle}</a><br/>
        <a>${requestScope.id}</a><br/>
        <a>${requestScope.email}</a>
    </body>
</html>
