<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 04.11.2016
  Time: 0:49
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="../../css/students.css">
  <title>Home Page</title>
</head>
<body>

    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>

<h3>Home Page</h3>

This is demo Simple web application using jsp,servlet &amp; Jdbc. <br><br>
<b>It includes the following functions:</b>
<ul>
  <li>Login</li>
  <li>Storing user information in cookies</li>
  <li>Student List</li>
  <li>Filtering by groups of students</li>
  <li>Search for students by name, surname, other</li>
  <li>Create Student</li>
  <li>Edit Student</li>
  <li>Delete Student</li>
  <li>Academic Groups List</li>
  <li>Create Academic Group</li>
  <li>Edit Academic Group</li>
  <li>Delete Academic Group</li>
  <li>Mentors List</li>
  <li>Create Mentor</li>
  <li>Edit Mentor</li>
  <li>Delete Mentor</li>
</ul>

<jsp:include page="footer.jsp"/>

</body>
</html>
