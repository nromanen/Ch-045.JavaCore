<%--
  Created by IntelliJ IDEA.
  User: Gavriluk Igor
  Date: 30.10.2016
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student personnel</h1>
        <a href="${pageContext.request.contextPath}/main">Students</a>
        <br>
        <a href="${pageContext.request.contextPath}/mentors">Mentors</a>
        <br>
        <a href="${pageContext.request.contextPath}/groups">Groups</a>
    </body>
</html>
