
<%--
  
  User: Igor Gavrilyuk
  Date: 04.11.2016
  Time: 13:36
  
--%>
<%--@elvariable id="user" type="net.students.model.UserAccount"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<h3>Hello: ${user.userName}</h3>

User Name: <b>${user.userName}</b>
<br />
Last login date: ${user.password } <br />

<jsp:include page="footer.jsp"/>

</body>
</html>
