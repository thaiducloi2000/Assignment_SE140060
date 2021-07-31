<%-- 
    Document   : update
    Created on : Mar 12, 2021, 8:00:37 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <form action="MainController">
            User ID : <input type="text" name="userID" value="${param.userID}" readonly="true"> <br/>
            User Name : <input type="text" name="userName" value="${param.userName}" required="true"><br/>
            Address : <input type="text" name="address" value="${param.address}" required="true"><br/>
            Phone : <input type="text" name="phone" value="${param.phone}" required="true"><br/>
            Gender : <input type="text" name="sex" value="${param.sex}" required="true"><br/>
            Role ID : <input type="text" name="roleID" value="${param.roleID}" required="true"><br/>
            <input type="submit" name="action" value="Confirm"/>
            <input type="reset"  value="reset"/> 
        </form>
    </body>
</html>
