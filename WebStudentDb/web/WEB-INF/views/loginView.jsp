
<%--
  
  User: Igor Gavrilyuk
  Date: 04.11.2016
  Time: 13:35
  
--%>
<%--@elvariable id="user" type="net.students.model.UserAccount"--%>
<%--@elvariable id="errorString" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<h3>Login Page</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="<c:url value="/doLogin"/>">
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value= "${user.userName}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value= "${user.password}" /> </td>
        </tr>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<p style="color:blue;">Tip: User Name: admin, password: 1234 </p>

<jsp:include page="footer.jsp"/>

</body>
</html>
