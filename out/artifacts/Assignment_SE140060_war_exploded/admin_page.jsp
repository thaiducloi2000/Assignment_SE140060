<%-- 
    Document   : Admind_Page
    Created on : Mar 11, 2021, 12:46:17 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>  
            label{
                color: white;
            }
            .table-dark{
                width: 65%;
                table-layout: inherit;

            }
            body{
                background-image: url("CSS/Ningguang_Theme.jpg");   
                background-size: cover;
/*                height: 500%;
                position: relative;
                background-position: center;*/
                background-repeat: no-repeat;
                background-size: cover;
            }
            h1{
                text-align: center;
                color: white;
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Welcome ${sessionScope.LIST_USER.userName}</h1>
            <form action="MainController">
                <input type="submit" name="action" value="Logout" />
            </form>
            <form action="MainController">
                <label>Search</label>
                <input type="text" name="search" value="${param.search}"/>
                <input type="submit" name="action" value="Search" /> 
            </form>
            <c:if test="${requestScope.LIST_USER != null }">
                <c:if test="${not empty LIST_USER}">
	  <table border="1" class="table-dark">
	      <thead>
	          <tr>
	              <th>No</th>
	              <th>User Name</th>
	              <th>Address</th>
	              <th>Phone</th>
	              <th>Gender</th>
	              <th>Role ID</th>
	              <th>Delete</th>
	              <th>Update</th>
	          </tr>
	      </thead>
	      <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
	          <form action="MainController">
	              <tbody>
		<tr>
		    <td>${counter.count}</td>
		    <td>${user.userName}</td>
		    <td>${user.address}</td>
		    <td>${user.phone}</td>
		    <td>${user.sex}</td>
		    <td>${user.roleID}</td>
		    <td>
		        <c:url var="delete" value="MainController">
		            <c:param name="action" value="Delete"> </c:param>
		            <c:param name="search" value="${param.search}"> </c:param>
		            <c:param name="userID" value="${user.userID}"> </c:param>
		        </c:url>
		        <a href="${delete}">Delete</a>
		    </td>
		    <td>
		        <input type="submit" name="action" value="Update"/>
		        <input type="hidden" name="userID" value="${user.userID}"/>
		        <input type="hidden" name="userName" value="${user.userName}"/>
		        <input type="hidden" name="address" value="${user.address}"/>
		        <input type="hidden" name="phone" value="${user.phone}"/>
		        <input type="hidden" name="sex" value="${user.sex}"/>
		        <input type="hidden" name="roleID" value="${user.roleID}"/>
		        <input type="hidden" name="search" value="${param.search}"/>
		    </td>
		</tr>
	              </tbody>
	          </form>
	      </c:forEach>	  
	  </table>
                </c:if>
            </c:if>   
        </div>
    </body>
</html>
